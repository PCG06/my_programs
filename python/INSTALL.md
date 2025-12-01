# Python Development Environment Setup

## Table of Contents

1. [How to Install Python](#how-to-install-python)

   * [For Windows](#for-windows)
   * [For Linux (and WSL)](#for-linux-and-wsl)
   * [For macOS](#for-macos)

2. [How to Work With Python Programs](#how-to-work-with-python-programs)

   * [Running a Python File](#running-a-python-file)
   * [Using a Virtual Environment](#using-a-virtual-environment)
   * [Installing Dependencies](#installing-dependencies)
   * [Summary of Commands](#summary-of-commands)

---

## How to Install Python

### For Windows

1. Download Python from the official website:
   [https://www.python.org/downloads/](https://www.python.org/downloads/)

2. During installation, **check the box**:
   **“Add Python to PATH.”**

Verify installation:

```bash
python --version
```

If that doesn't work, try:

```bash
py --version
```

---

### For Linux (and WSL)

Check out WSL installation [here](../INSTALL_WSL.md).

Install Python 3:

```bash
sudo apt update
sudo apt install python3 python3-pip python3-venv
```

Verify installation:

```bash
python3 --version
pip3 --version
```

---

### For macOS

Install using Homebrew:

```bash
brew install python
```

Verify installation:

```bash
python3 --version
pip3 --version
```

---

## How to Work With Python Programs

Python doesn’t need compiling — you run scripts directly.
This project uses a **virtual environment** so each project keeps its own dependencies clean and isolated.

---

### Running a Python File

To run any Python script:

```bash
python3 <file>.py
```

On Windows:

```bash
python <file>.py
```

### Installing Dependencies

If your project has a `requirements.txt`:

<details>
   <summary>Click here for an example...</summary>

   ```txt
   requests==2.32.3
   numpy==2.1.0
   pandas==2.2.2
   flask==3.0.3
   ```

</details>

Install everything:

```bash
pip install -r requirements.txt
```

Add a new library and update the file:

```bash
pip install somepackage
pip freeze > requirements.txt
```

---

## Summary of Commands

| Task                        | Command                           |
| --------------------------- | --------------------------------- |
| Check Python version        | `python3 --version`               |
| Install dependencies        | `pip install -r requirements.txt` |
| Run a script                | `python3 <file>.py`               |
