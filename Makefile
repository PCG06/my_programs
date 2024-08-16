# Directories for source files and build outputs
SRC_DIR = src
BUILD_DIR = build

# Automatically find all .c files in the src directory
SOURCES = $(wildcard $(SRC_DIR)/*.c)
PROGRAMS = $(patsubst $(SRC_DIR)/%.c,$(BUILD_DIR)/%,$(SOURCES))
OBJECTS = $(patsubst $(SRC_DIR)/%.c,$(BUILD_DIR)/%.o,$(SOURCES))

# Default target
all: $(BUILD_DIR) $(PROGRAMS)
	@echo "All source files are built!"

# Rule to create the build directory if it doesn't exist
$(BUILD_DIR):
	mkdir -p $(BUILD_DIR)

# Rule for compiling .c files into .o files in the build directory
$(BUILD_DIR)/%.o: $(SRC_DIR)/%.c | $(BUILD_DIR)
	gcc -c $< -o $@

# Rule for linking .o files into executables in the build directory
$(BUILD_DIR)/%: $(BUILD_DIR)/%.o
	gcc $^ -o $@ -lm

# Clean up generated files
clean:
	rm -rf $(BUILD_DIR)
	@echo "Build folder has been cleaned and removed!"

# Clean up generated files and rebuild all
cleanbuild: clean all

.PHONY: all clean
