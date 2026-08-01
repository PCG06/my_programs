SRC_DIR = src
BUILD_DIR = build

JAVAC = javac
JAVA  = java

# Apache Derby
DERBY_HOME ?= $(HOME)/derby
DERBY_LIB  := $(DERBY_HOME)/lib
DERBY_CP   := $(DERBY_LIB)/derby.jar:$(DERBY_LIB)/derbyclient.jar:$(DERBY_LIB)/derbynet.jar:$(DERBY_LIB)/derbytools.jar
DERBY_BIN  := $(DERBY_HOME)/bin

# javax.servlet
SERVLET_HOME ?= $(HOME)/servlet
SERVLET_LIB  := $(SERVLET_HOME)/lib
SERVLET_JARS := $(wildcard $(SERVLET_LIB)/*.jar)
empty :=
space := $(empty) $(empty)
SERVLET_CP   := $(subst $(space),:,$(SERVLET_JARS))

# Apache Tomcat (used for servlet packages)
TOMCAT_HOME ?= $(HOME)/tomcat
TOMCAT_BIN     := $(TOMCAT_HOME)/bin
TOMCAT_WEBAPPS := $(TOMCAT_HOME)/webapps
TOMCAT_LOGS    := $(TOMCAT_HOME)/logs

LOG_DIR    := logs
LIB_CP     := $(DERBY_CP):$(SERVLET_CP)

export CLASSPATH := $(LIB_CP)
export CATALINA_HOME := $(TOMCAT_HOME)
export PATH := $(DERBY_BIN):$(PATH)

# Compile everything
PACKAGE_SOURCES = $(wildcard $(SRC_DIR)/*/*.java)
PACKAGE_CLASSES = $(patsubst $(SRC_DIR)/%.java,$(BUILD_DIR)/%.class,$(PACKAGE_SOURCES))

MAIN_SOURCES = $(wildcard $(SRC_DIR)/*.java)
MAIN_CLASSES = $(patsubst $(SRC_DIR)/%.java,$(BUILD_DIR)/%.class,$(MAIN_SOURCES))

# FILE must be a package/folder name only, e.g. FILE=LibraryManagement
# (no FILE=LibraryManagement.java)
define check_file
	@if [ -z "$(FILE)" ]; then \
		echo "Usage: make $(1) FILE=<package folder name>"; \
		exit 1; \
	fi
	@if [ -n "$(suffix $(FILE))" ]; then \
		echo "FILE must be a package/folder name, not a file - use FILE=$(basename $(FILE)) instead of FILE=$(FILE)"; \
		exit 1; \
	fi
endef

all: $(BUILD_DIR) $(PACKAGE_CLASSES) $(MAIN_CLASSES)
	@echo "All Java files compiled!"

ifeq ($(wildcard $(DERBY_LIB)/derbyclient.jar),)
$(error Apache Derby not found! Please set DERBY_HOME or install Derby.)
endif
ifeq ($(wildcard $(DERBY_LIB)/derbytools.jar),)
$(error derbytools.jar not found in $(DERBY_LIB) - ij needs it to run.)
endif
ifeq ($(SERVLET_JARS),)
$(error javax.servlet jar not found in $(SERVLET_LIB) - please set SERVLET_HOME or install the servlet API jar there.)
endif

$(BUILD_DIR):
	mkdir -p $(BUILD_DIR)

$(BUILD_DIR)/%.class: $(SRC_DIR)/%.java | $(BUILD_DIR)
	@mkdir -p $(dir $@)
	@echo $(JAVAC) -cp $(BUILD_DIR):LIB_CP -d $(BUILD_DIR) $<
	@$(JAVAC) -cp "$(BUILD_DIR):$(LIB_CP)" -d "$(BUILD_DIR)" $<

run: $(BUILD_DIR)
	$(call check_file,run)

	@mkdir -p $(LOG_DIR)

	@if ! nc -z localhost 1527 >/dev/null 2>&1; then \
		echo "Starting Derby Network Server..."; \
		startNetworkServer > $(LOG_DIR)/derby-server.log 2>&1 & \
		for i in 1 2 3 4 5 6 7 8 9 10; do \
			nc -z localhost 1527 >/dev/null 2>&1 && break; \
			sleep 1; \
		done; \
		if ! nc -z localhost 1527 >/dev/null 2>&1; then \
			echo "Derby Network Server failed to start. See $(LOG_DIR)/derby-server.log"; \
			cat $(LOG_DIR)/derby-server.log; \
			exit 1; \
		fi; \
	fi

	@PROJ="$(FILE)"; \
	DB_DIR="$(SRC_DIR)/$$PROJ/database"; \
	DB_NAME="$$(echo $$PROJ | sed 's/Management$$//' | tr '[:upper:]' '[:lower:]')"; \
	DB_PATH="$$DB_DIR/$$DB_NAME"; \
	QUERY_DIR="$(SRC_DIR)/$$PROJ/queries"; \
	\
	if [ ! -d "$$DB_PATH" ] && [ -f "$$QUERY_DIR/database.sql" ]; then \
		echo "Creating database..."; \
		if ij "$$QUERY_DIR/database.sql" > $(LOG_DIR)/derby-database.log 2>&1 && ! grep -qi 'ERROR' $(LOG_DIR)/derby-database.log; then \
			: ; \
		else \
			echo "Database creation reported an error - see $(LOG_DIR)/derby-database.log:"; \
			cat $(LOG_DIR)/derby-database.log; \
			exit 1; \
		fi; \
	fi; \
	\
	TABLE_MARKER="$$DB_DIR/.tables_created"; \
	if [ -f "$$QUERY_DIR/table.sql" ] && [ ! -f "$$TABLE_MARKER" ]; then \
		echo "Creating table..."; \
		ij "$$QUERY_DIR/table.sql" > $(LOG_DIR)/derby-table.log 2>&1; \
		if grep -qi "ERROR" $(LOG_DIR)/derby-table.log; then \
			echo "Table creation reported an error - see $(LOG_DIR)/derby-table.log"; \
			cat $(LOG_DIR)/derby-table.log; \
			exit 1; \
		else \
			echo "Table created."; \
			touch "$$TABLE_MARKER"; \
		fi; \
	fi

	@echo $(JAVAC) -cp $(BUILD_DIR):LIB_CP -d $(BUILD_DIR) $(SRC_DIR)/$(FILE)/$(FILE).java
	@$(JAVAC) -cp "$(BUILD_DIR):$(LIB_CP)" -d "$(BUILD_DIR)" "$(SRC_DIR)/$(FILE)/$(FILE).java"
	@echo $(JAVA) -cp $(BUILD_DIR):LIB_CP $(FILE).$(FILE)
	@$(JAVA) -cp "$(BUILD_DIR):$(LIB_CP)" "$(FILE).$(FILE)"

# Servlet programs: compiles, deploys as an exploded webapp into Tomcat, starts Tomcat if needed.
servlet: $(BUILD_DIR)
	$(call check_file,servlet)

	@if [ ! -x "$(TOMCAT_BIN)/startup.sh" ]; then \
		echo "Apache Tomcat not found at $(TOMCAT_HOME) - set TOMCAT_HOME or install Tomcat there."; \
		exit 1; \
	fi

	@if [ ! -f "$(SRC_DIR)/$(FILE)/index.html" ]; then \
		echo "Warning: $(SRC_DIR)/$(FILE)/index.html not found - servlet packages are expected to have one."; \
	fi

	@echo $(JAVAC) -cp $(BUILD_DIR):LIB_CP -d $(BUILD_DIR) $(SRC_DIR)/$(FILE)/$(FILE).java
	@$(JAVAC) -cp "$(BUILD_DIR):$(LIB_CP)" -d "$(BUILD_DIR)" "$(SRC_DIR)/$(FILE)/$(FILE).java"

	@echo "Deploying $(FILE) to Tomcat..."
	@rm -rf "$(TOMCAT_WEBAPPS)/$(FILE)"
	@mkdir -p "$(TOMCAT_WEBAPPS)/$(FILE)/WEB-INF/classes/$(FILE)"
	@cp "$(BUILD_DIR)/$(FILE)/$(FILE).class" "$(TOMCAT_WEBAPPS)/$(FILE)/WEB-INF/classes/$(FILE)/$(FILE).class"
	@if [ -f "$(SRC_DIR)/$(FILE)/index.html" ]; then \
		cp "$(SRC_DIR)/$(FILE)/index.html" "$(TOMCAT_WEBAPPS)/$(FILE)/index.html"; \
	fi

	@mkdir -p $(LOG_DIR)
	@if ! nc -z localhost 8080 >/dev/null 2>&1; then \
		echo "Starting Tomcat..."; \
		"$(TOMCAT_BIN)/startup.sh" > $(LOG_DIR)/tomcat-startup.log 2>&1; \
		for i in 1 2 3 4 5 6 7 8 9 10; do \
			nc -z localhost 8080 >/dev/null 2>&1 && break; \
			sleep 1; \
		done; \
		if ! nc -z localhost 8080 >/dev/null 2>&1; then \
			echo "Tomcat failed to start. See $(LOG_DIR)/tomcat-startup.log and $(TOMCAT_LOGS)/catalina.out"; \
			cat $(LOG_DIR)/tomcat-startup.log; \
			tail -n 40 "$(TOMCAT_LOGS)/catalina.out" 2>/dev/null; \
			exit 1; \
		fi; \
	else \
		sleep 2; \
	fi

	@echo "Deployed! Open: http://localhost:8080/$(FILE)/"

clean:
	rm -rf $(BUILD_DIR)
	rm -rf $(SRC_DIR)/*/database
	rm -rf $(LOG_DIR)
	@echo "Build folder has been cleaned and removed!"

cleanbuild: clean all

.PHONY: all run servlet clean cleanbuild
