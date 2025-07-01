# MSYS2 Installation

## Table of Contents

1. [What is MSYS2?](#what-is-msys2)
2. [How to Install MSYS2](#how-to-install-msys2)
   * [Download the MSYS2 Installer](#download-the-msys2-installer)
   * [Run the Installer](#run-the-installer)
   * [Update MSYS2 Packages](#update-msys2-packages)
   * [Install Development Tools](#install-development-tools)
3. [Verify Installation](#verify-installation)

---

## What is MSYS2?

MSYS2 is a software distribution and development platform that provides a collection of tools and libraries for Windows, including a package management system. It allows you to run a Unix-like environment on Windows, making it easier to use many open-source tools such as GCC, make, and other utilities commonly found in Linux distributions.

---

## How to Install MSYS2

### 1. **Download the MSYS2 Installer**

* Visit the official MSYS2 website: [msys2.org/](https://www.msys2.org/)
* Click on the **"Install MSYS2"** link.
* Download the **MSYS2 installer** (`msys2-x86_64-<version>.exe`) for Windows.

### 2. **Run the Installer**

* Locate the downloaded `msys2-x86_64-<version>.exe` file and double-click to run it.
* Follow the installation steps:

  * Choose the installation directory (default is `C:\msys64`).
  * Click **Next** and then **Install**.
* Wait for the installation to complete.

### 3. **Update MSYS2 Packages**

* After installation, launch the MSYS2 terminal (found in the Start Menu under **MSYS2 64-bit**).

* Run the following commands to update the core system and packages:

  ```bash
  pacman -Syu
  ```

  * This command updates the MSYS2 core system. If prompted to restart the MSYS2 terminal, close it and reopen it, then run the command again to complete the update.

* Install necessary system updates:

  ```bash
  pacman -Su
  ```

### 4. **Install Development Tools**

MSYS2 provides a package manager called `pacman`, similar to Linux. You can install development tools like GCC (GNU Compiler Collection) and make using the following command:

```bash
pacman -S base-devel gcc vim
```

* This command installs the essential development tools and text editor (`vim`).
* You can also install additional packages depending on your needs (e.g., `git`, `make`, etc.).

---

## Verify Installation

To verify that MSYS2 is installed and functioning correctly:

1. Open the MSYS2 terminal.

2. Check if the `pacman` package manager is working:

   ```bash
   pacman --version
   ```

3. Verify that GCC (GNU Compiler Collection) is installed:

   ```bash
   gcc --version
   ```

4. Check that the `make` command is available:

   ```bash
   make --version
   ```

If all the commands return the expected versions, MSYS2 is successfully installed!

---