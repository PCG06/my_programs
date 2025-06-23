SRC_DIR = src
BUILD_DIR = build

JAVAC = javac
JAVA = java

SOURCES = $(wildcard $(SRC_DIR)/*.java)
CLASSES = $(patsubst $(SRC_DIR)/%.java,$(BUILD_DIR)/%.class,$(SOURCES))

all: $(BUILD_DIR) $(CLASSES)
	@echo "All Java files compiled!"

$(BUILD_DIR):
	mkdir -p $(BUILD_DIR)

$(BUILD_DIR)/%.class: $(SRC_DIR)/%.java | $(BUILD_DIR)
	$(JAVAC) -d $(BUILD_DIR) $<

# From ChatGPT :)
run: $(BUILD_DIR)
	@if [ -z "$(FILE)" ]; then \
		echo "Usage: make run FILE=Example.java"; \
		exit 1; \
	fi
	$(JAVAC) -d $(BUILD_DIR) $(SRC_DIR)/$(FILE)
	$(JAVA) -cp $(BUILD_DIR) $(basename $(FILE))

clean:
	rm -rf $(BUILD_DIR)
	@echo "Build folder has been cleaned and removed!"

cleanbuild: clean all

.PHONY: all run clean cleanbuild
