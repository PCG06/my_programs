# C Development Environment Setup

## Table of Contents

1. [How to Install C Compiler (GCC)](#how-to-install-c-compiler-gcc)

   * [For Windows (MSYS2)](#for-windows-msys2)
   * [For Linux (and WSL)](#for-linux-and-wsl)
   * [For macOS](#for-macos)

2. [How to Work With C Programs](#how-to-work-with-c-programs)

   * [Steps to Compile Programs](#steps-to-compile-programs)
   * [Steps to Run Programs](#steps-to-run-programs)
   * [Clean the Project](#clean-the-project)
   * [Summary of Commands](#summary-of-commands)

---

## How to Install C Compiler (GCC)

### For Windows (MSYS2)

Check out MSYS installation [here](INSTALL_MSYS.md).

#### 1. Install GCC:
```bash
pacman -S mingw-w64-x86_64-gcc
```

#### 2. Verify Installation:
```bash
gcc --version
```

---

### For Linux (and WSL)

Check out WSL installation [here](INSTALL_WSL.md).

#### 1. Install Build Tools:
```bash
sudo apt update && sudo apt install build-essential
```

#### 2. Verify Installation:
```bash
gcc --version
```

---

### For macOS

#### 1. Install Command Line Tools:
```bash
xcode-select --install
```

#### 2. Verify Installation:
```bash
gcc --version
```

---

## How to Work With C Programs

This project includes a Makefile to automate compilation and project management.

### Steps to Compile Programs

1. **Navigate to project directory**:
   ```bash
   cd c_prgms
   ```

2. **Run make**:
   ```bash
   make
   ```

   - Creates `build/` directory
   - Compiles all `.c` files
   - Links object files
   - Prints: "All source files are built!"

### Steps to Run Programs
```bash
./build/<program_name>
```

### Clean the Project
1. **Clean build files**:
   ```bash
   make clean
   ```

   - Removes `build/` directory
   - Prints: "Build folder has been cleaned and removed!"

2. **Full rebuild**:
   ```bash
   make cleanbuild
   ```

### Summary of Commands

| Command            | Action                                 |
|--------------------|----------------------------------------|
| `make`             | Compiles all C source files            |
| `make clean`       | Deletes build directory                |
| `make cleanbuild`  | Full clean + rebuild                   |
| `./build/<program>`| Run compiled executable                |

---
