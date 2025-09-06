SRC_DIR = src
BUILD_DIR = build

JAVAC = javac
JAVA = java

PACKAGE_SOURCES = $(wildcard $(SRC_DIR)/Package/*/*.java)
PACKAGE_CLASSES = $(patsubst $(SRC_DIR)/%.java,$(BUILD_DIR)/%.class,$(PACKAGE_SOURCES))

MAIN_SOURCES = $(filter-out $(PACKAGE_SOURCES),$(wildcard $(SRC_DIR)/*.java))
MAIN_CLASSES = $(patsubst $(SRC_DIR)/%.java,$(BUILD_DIR)/%.class,$(MAIN_SOURCES))

all: $(BUILD_DIR) packages mains
	@echo "All Java files compiled!"

packages: $(PACKAGE_CLASSES)

mains: $(MAIN_CLASSES)

# Build directory
$(BUILD_DIR):
	mkdir -p $(BUILD_DIR)

$(BUILD_DIR)/%.class: $(SRC_DIR)/%.java | $(BUILD_DIR)
	@mkdir -p $(dir $@)
	$(JAVAC) -cp $(BUILD_DIR) -d $(BUILD_DIR) $<

# From ChatGPT :)
run: $(BUILD_DIR)
	@if [ -z "$(FILE)" ]; then \
		echo "Usage: make run FILE=Example.java"; \
		exit 1; \
	fi
	$(JAVAC) -cp $(BUILD_DIR) -d $(BUILD_DIR) $(SRC_DIR)/$(FILE)
	$(JAVA) -cp $(BUILD_DIR) $(basename $(FILE))

clean:
	rm -rf $(BUILD_DIR)
	@echo "Build folder has been cleaned and removed!"

cleanbuild: clean all

.PHONY: all packages mains run clean cleanbuild
