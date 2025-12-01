# PHP Development Environment Setup

## Table of Contents

1. [How to Install PHP](#how-to-install-php)

   * [For Windows](#for-windows)
   * [For Linux (and WSL)](#for-linux-and-wsl)
   * [For macOS](#for-macos)

2. [How to Work With PHP Programs](#how-to-work-with-php-programs)

   * [Running a PHP Script](#running-a-php-script)
   * [Using the Built-In Development Server](#using-the-built-in-development-server)
   * [Installing Dependencies With Composer](#installing-dependencies-with-composer)
   * [Summary of Commands](#summary-of-commands)

---

## How to Install PHP

### For Windows

#### Option 1 — Install XAMPP (Easy)

1. Download XAMPP:
   [https://www.apachefriends.org/download.html](https://www.apachefriends.org/download.html)
2. Install and launch it — PHP is included automatically.

#### Option 2 — Install PHP manually

1. Download PHP from:
   [https://windows.php.net/download/](https://windows.php.net/download/)
2. Extract it and add its folder to your **PATH**.

Verify installation:

```bash
php -v
```

---

### For Linux (and WSL)

Check out WSL installation [here](../INSTALL_WSL.md).

Install PHP:

```bash
sudo apt update
sudo apt install php php-cli php-zip php-curl php-mbstring
```

Verify installation:

```bash
php -v
```

---

### For macOS

Install with Homebrew:

```bash
brew install php
```

Verify installation:

```bash
php -v
```

---

## How to Work With PHP Programs

PHP doesn’t need compiling — it runs scripts directly and can also act as a local web server.

---

### Running a PHP Script

To run any file:

```bash
php file.php
```

---

### Using the Built-In Development Server

From inside your project folder:

```bash
php -S localhost:8000
```

Then visit:

```
http://localhost:8000
```

This is perfect for testing simple web pages.

---

### Installing Dependencies With Composer

If your project uses a `composer.json` file:

#### Install Composer (global)

**Windows:**
Download and run the installer:
[https://getcomposer.org/Composer-Setup.exe](https://getcomposer.org/Composer-Setup.exe)

**Linux/macOS:**

```bash
php -r "copy('https://getcomposer.org/installer', 'composer-setup.php');"
php composer-setup.php
sudo mv composer.phar /usr/local/bin/composer
```

Verify:

```bash
composer --version
```

#### Install project dependencies:

```bash
composer install
```

Add a new package:

```bash
composer require vendor/package
```

---

## Summary of Commands

| Task                 | Command                           |
| -------------------- | --------------------------------- |
| Check PHP version    | `php -v`                          |
| Run a script         | `php file.php`                    |
| Start dev server     | `php -S localhost:8000`           |
| Install dependencies | `composer install`                |
| Add dependency       | `composer require vendor/package` |
