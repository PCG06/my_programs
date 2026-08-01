# Java Development Environment Setup

## Table of Contents

1. [How to Install Java (JDK)](#how-to-install-java-jdk)

   * [For Windows](#for-windows)
   * [For Linux (and WSL)](#for-linux-and-wsl)
   * [For macOS](#for-macos)

2. [Apache Derby (JDBC)](#apache-derby-jdbc)

   * [Download Apache Derby](#download-apache-derby)
   * [Linux (and WSL)](#linux-and-wsl-1)
   * [Windows](#windows-1)
   * [Verify Derby Installation](#verify-derby-installation)
   * [Working with Apache Derby](#working-with-apache-derby)

3. [Servlets (Tomcat)](#servlets-tomcat)

   * [Download the javax.servlet API](#download-the-javaxservlet-api)
   * [Download and Install Tomcat](#download-and-install-tomcat)
   * [Verify Tomcat Installation](#verify-tomcat-installation)
   * [Servlet Package Requirements](#servlet-package-requirements)

4. [How to Work With Java Programs](#how-to-work-with-java-programs)

   * [Steps to Compile All Files](#steps-to-compile-all-files)
   * [Steps to Run a DB Program (`make run`)](#steps-to-run-a-db-program-make-run)
   * [Steps to Run a Servlet Program (`make servlet`)](#steps-to-run-a-servlet-program-make-servlet)
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

Check out WSL installation [here](INSTALL_WSL.md).

Install JDK:

```bash
sudo apt update
sudo apt install openjdk-21-jdk
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
brew install openjdk@21
```

Verify installation:

```bash
java -version
javac -version
```

---

## Apache Derby (JDBC)

This project is configured to use **Apache Derby Network Server** for JDBC programs.

The Makefile expects Derby to be installed in:

```text
~/derby
```

or that the environment variable:

```text
DERBY_HOME
```

points to your Derby installation.

---

### Download Apache Derby

Download the latest binary release from the Apache Derby website.

Extract it somewhere convenient.

Example:

```text
~/derby
```

The directory should contain:

```text
~/derby
├── bin/
├── demo/
├── docs/
└── lib/
```

`lib/` must contain at minimum:

```text
derby.jar
derbyclient.jar
derbynet.jar
derbytools.jar
```

(`derbytools.jar` is required for the `ij` shell — without it, database/table creation will fail.)

---

### Linux (and WSL)

Add Derby to your shell.

Open:

```bash
nano ~/.bashrc
```

Append:

```bash
export DERBY_HOME=$HOME/derby
export PATH=$DERBY_HOME/bin:$PATH
```

Reload:

```bash
source ~/.bashrc
```

---

### Windows

Create an environment variable named:

```text
DERBY_HOME
```

pointing to your Derby installation.

Example:

```text
C:\derby
```

Add:

```text
%DERBY_HOME%\bin
```

to your `PATH`.

Restart your terminal afterwards.

---

### Verify Derby Installation

```bash
echo $DERBY_HOME
```

Expected:

```text
/home/username/derby
```

You should also see `$DERBY_HOME/lib` containing `derby.jar`, `derbyclient.jar`, `derbynet.jar`, and `derbytools.jar`.

---

### Working with Apache Derby

You do **not** need to manually start Derby, open `ij`, or create databases/tables yourself — `make run` handles all of this automatically per package:

* Starts the Derby Network Server if it isn't already running (port `1527`)
* Creates the database on first run, using `src/<Package>/queries/database.sql`
* Creates the tables on first run, using `src/<Package>/queries/table.sql` (tracked via a `.tables_created` marker file so it only runs once)
* Compiles and runs your program

Logs for each step are written to `logs/` (`derby-server.log`, `derby-database.log`, `derby-table.log`) if you ever need to debug a failure.

If you ever need to interact with the database manually, you can still do so:

```bash
ij
ij> connect 'jdbc:derby://localhost:1527/library;user=root;password=1234';
```

To stop the server when you're done:

```bash
stopNetworkServer
```

---

## Servlets (Tomcat)

This project uses **Apache Tomcat 9** to run servlet packages (`javax.servlet.*` — do **not** use Tomcat 10+, which moves to `jakarta.*` and will not work with this codebase without code changes).

---

### Download the javax.servlet API

The Makefile expects a servlet API jar at:

```text
~/servlet/lib/
```

or wherever the `SERVLET_HOME` environment variable points (`SERVLET_HOME/lib/*.jar`).

```bash
mkdir -p ~/servlet/lib
curl -fL -o ~/servlet/lib/javax.servlet-api-4.0.1.jar \
  https://repo1.maven.org/maven2/javax/servlet/javax.servlet-api/4.0.1/javax.servlet-api-4.0.1.jar
```

---

### Download and Install Tomcat

The Makefile expects Tomcat to be installed in:

```text
~/tomcat
```

or wherever the `TOMCAT_HOME` environment variable points.

```bash
mkdir -p ~/tomcat
curl -fL -o /tmp/tomcat.tar.gz \
  https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.120/bin/apache-tomcat-9.0.120.tar.gz
tar xzf /tmp/tomcat.tar.gz -C ~/tomcat --strip-components=1
chmod +x ~/tomcat/bin/*.sh
```

(Check [the Tomcat 9 downloads page](https://tomcat.apache.org/download-90.cgi) for the current release number if `9.0.120` is no longer available.)

---

### Verify Tomcat Installation

```bash
ls ~/tomcat/bin/startup.sh
```

If that file exists and is executable, you're set — `make servlet` handles starting Tomcat and deploying your servlet.

---

### Servlet Package Requirements

Each servlet package under `src/` should contain:

```text
src/<Package>/
├── <Package>.java   # extends HttpServlet, annotated with @WebServlet("/path")
└── index.html       # entry page for the deployed app
```

Unlike DB programs, servlet classes do **not** need a `main()` method — Tomcat instantiates and drives them via the servlet container.

---

## How to Work With Java Programs

This project uses a Makefile to simplify Java compilation and execution. All `.java` source files are located inside the `src/` directory, organized into one folder per package. Compiled `.class` files are placed in the `build/` directory.

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

### Steps to Run a DB Program (`make run`)

`FILE` must be the **package/folder name only** — not the `.java` filename.

```bash
make run FILE=LibraryManagement
```

* Starts the Derby Network Server if needed
* Creates the database/tables on first run
* Compiles and runs `src/LibraryManagement/LibraryManagement.java`
* Your file **must** contain a `public static void main(String[] args)` method

Passing the old style (`FILE=LibraryManagement.java`) is no longer supported and will error out with a usage message.

---

### Steps to Run a Servlet Program (`make servlet`)

Also takes the package/folder name only:

```bash
make servlet FILE=Greeting
```

* Compiles `src/Greeting/Greeting.java`
* Deploys it (plus its `index.html`) into Tomcat's `webapps/` as an exploded app
* Starts Tomcat if it isn't already running
* Prints the URL to open, e.g. `http://localhost:8080/Greeting/`

Re-running `make servlet FILE=Greeting` after code changes redeploys automatically.

---

### Clean the Project

```bash
make clean
```

* Deletes `build/` directory
* Deletes each package's `src/<Package>/database/` (so `make run` recreates it from scratch)
* Deletes `logs/`
* Prints: "Build folder has been cleaned and removed!"

---

### Full Rebuild

```bash
make cleanbuild
```

* Cleans everything, then compiles all `.java` files again

---

### Summary of Commands

| Command                       | Action                                              |
| ------------------------------ | ---------------------------------------------------- |
| `make`                         | Compiles all `.java` files from `src/`               |
| `make run FILE=LibraryManagement` | Compiles and runs a DB-backed program (via Derby) |
| `make servlet FILE=Greeting`   | Compiles and deploys a servlet program (via Tomcat) |
| `make clean`                   | Deletes `build/`, per-package databases, and `logs/` |
| `make cleanbuild`              | Cleans and recompiles everything                     |
