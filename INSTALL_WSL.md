# Windows Subsystem for Linux (WSL) Installation

## Table of Contents

1. [What is WSL?](#what-is-wsl)
2. [Prerequisites](#prerequisites)
3. [How to Install WSL](#how-to-install-wsl)
   * [Enable WSL Feature](#enable-wsl-feature)
   * [Install a Linux Distribution](#install-a-linux-distribution)
   * [Set up the Distribution](#set-up-the-distribution)
4. [Verify Installation](#verify-installation)

---

## What is WSL?

Windows Subsystem for Linux (WSL) is a compatibility layer that allows you to run a Linux environment on Windows. It enables you to use Linux tools, run a full Linux file system, and even install and run Linux distributions directly from Windows without the need for dual-booting or using a virtual machine.

---

## Prerequisites

* **Windows 10** or higher.
* A 64-bit version of Windows (WSL 2 requires this).

---

## How to Install WSL

### 1. **Enable WSL Feature**

WSL is built into Windows, but you need to enable it before installation.

**Steps:**

1. Open **PowerShell** as Administrator. Right-click on the **Start Menu** and select **Windows PowerShell (Admin)**.

2. To enable WSL and Virtual Machine Platform, run the following command:

   ```powershell
   wsl --install
   ```

   * This will automatically enable WSL, install the necessary components, and set WSL 2 as the default version.

3. If you want to enable WSL manually, run the following commands in **PowerShell** (Admin):

   ```powershell
   dism.exe /online /enable-feature /featurename:Microsoft-Windows-Subsystem-Linux /all /norestart
   dism.exe /online /enable-feature /featurename:VirtualMachinePlatform /all /norestart
   ```

4. **Restart your computer** if prompted.

### 2. **Install a Linux Distribution**

After enabling WSL, you need to choose and install a Linux distribution.

**Steps:**

1. Open **Microsoft Store**.

2. Search for a Linux distribution. Popular choices include:

   * **Ubuntu**
   * **Debian**
   * **Kali Linux**
   * **openSUSE**

3. Click on your preferred Linux distribution, then click **Install**.

4. Wait for the installation to complete.

### 3. **Set up the Distribution**

Once the distribution is installed, you need to set it up.

**Steps:**

1. After installation, click **Launch** or search for the distribution name (e.g., "Ubuntu") in the Start Menu and open it.

2. The first time you launch the distribution, it will take a few minutes to set up. You will be prompted to create a user account and password.

---

## Verify Installation

To verify that WSL is installed and working:

1. Open the installed Linux distribution (e.g., **Ubuntu**).

2. In the terminal, check the Linux version:

   ```bash
   lsb_release -a
   ```

3. Verify that the installed version of WSL is 2:

   ```powershell
   wsl --list --verbose
   ```

   If the default version is not 2, you can change it by running the following command:

   ```powershell
   wsl --set-default-version 2
   ```

   This sets WSL 2 as the default version for future distributions.

4. **Check that you can run Linux commands**:

   Run a basic Linux command like `ls` to list directory contents.

   ```bash
   ls
   ```

---

## Additional Tips

* **Accessing Linux Files from Windows**: You can access the Linux filesystem from Windows by navigating to `\\wsl$` in File Explorer.

* **Accessing Windows Files from Linux**: Windows drives (e.g., C:) are mounted automatically under `/mnt/c/` in WSL.

---
