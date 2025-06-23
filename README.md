# Java Development Environment Setup

## Table of Contents

1. [How to Install Java (JDK)](#how-to-install-java-jdk)

   * [For Windows](#for-windows)
   * [For Linux (and WSL)](#for-linux-and-wsl)
   * [For macOS](#for-macos)

2. [How to Work With Java Programs](#how-to-work-with-java-programs)

   * [Steps to Compile All Files](#steps-to-compile-all-files)
   * [Steps to Run a Specific File](#steps-to-run-a-specific-file)
   * [Clean the Project](#clean-the-project)
   * [Summary of Commands](#summary-of-commands)

---

## How to Install Java (JDK)

### For Windows

Download and install JDK from [Adoptium](https://adoptium.net/) or [Oracle](https://www.oracle.com/java/technologies/javase-downloads.html).

Verify installation:

```bash
java -version
javac -version
```

---

### For Linux (and WSL)

Install JDK:

```bash
sudo apt update
sudo apt install openjdk-17-jdk
```

Verify installation:

```bash
java -version
javac -version
```

---

### For macOS

Install with Homebrew:

```bash
brew install openjdk@17
```

Verify installation:

```bash
java -version
javac -version
```

---

## How to Work With Java Programs

This project uses a Makefile to simplify Java compilation and execution. All `.java` source files are located inside the `src/` directory. Compiled `.class` files are placed in the `build/` directory.

---

### Steps to Compile All Files

1. **Navigate to the project directory**:

   ```bash
   cd my_programs
   ```

2. **Compile everything in `src/`**:

   ```bash
   make
   ```

   * Compiles all `.java` files in `src/`
   * Outputs `.class` files into `build/`
   * Prints: "All Java files compiled!"

---

### Steps to Run a Specific File

To compile and run a single `.java` file (e.g., `src/Example.java`):

```bash
make run FILE=Example.java
```

* Only compiles `src/Example.java`
* Runs `Example` from `build/Example.class`
* Your file **must** contain a `public static void main(String[] args)` method

---

### Clean the Project

```bash
make clean
```

* Deletes `build/` directory
* Prints: "Build folder has been cleaned and removed!"

---

### Full Rebuild

```bash
make cleanbuild
```

* Cleans everything, then compiles all `.java` files again

---

### Summary of Commands

| Command                      | Action                                 |
| ---------------------------- | -------------------------------------- |
| `make`                       | Compiles all `.java` files from `src/` |
| `make run FILE=Example.java` | Compiles and runs only `Example.java`  |
| `make clean`                 | Deletes the `build/` directory         |
| `make cleanbuild`            | Cleans and recompiles everything       |
