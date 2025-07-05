# R Programming

This folder contains my R related code.  

## Installation

### For Windows

1. Download and install R from [CRAN for Windows](https://cran.r-project.org/bin/windows/base/)

2. Optional: Install [RTools](https://cran.r-project.org/bin/windows/Rtools/) if you want to build packages from source

Then open **RGui** or run `R` from terminal (e.g., PowerShell if R is in PATH):

```r
install.packages("jsonlite")        
install.packages("languageserver")  
install.packages("ggplot2")         
install.packages("dplyr")           
install.packages("readr")           
install.packages("tidyr")           
install.packages("stringr")         
install.packages("httpgd")          
```

---


### For Linux (and WSL)

Check out WSL installation [here](../INSTALL_WSL.md).

Run this command in the Linux terminal:
```bash
sudo apt install -y r-base libcurl4-openssl-dev libssl-dev libxml2-dev build-essential libpng-dev
```

Then enter the R environment.
```bash
R
```

And run this:
```r
install.packages("jsonlite")        # Required by VSCode extensions
install.packages("languageserver")  # For IntelliSense/autocomplete
install.packages("ggplot2")         # For plotting
install.packages("dplyr")           # Data manipulation
install.packages("readr")           # CSV / data import
install.packages("tidyr")           # Data wrangling
install.packages("stringr")         # String manipulation
install.packages("httpgd")          # For inline plots in VSCode
```

---

### For macOS

Install R using [CRAN for macOS](https://cran.r-project.org/bin/macosx/).

Then install command line tools (for building packages):

```bash
xcode-select --install
```

Enter the R environment:
```bash
R
```

Then run:
```r
install.packages("jsonlite")        
install.packages("languageserver")  
install.packages("ggplot2")         
install.packages("dplyr")           
install.packages("readr")           
install.packages("tidyr")           
install.packages("stringr")         
install.packages("httpgd")          
```

If you run into any build issues, you may also need to install `homebrew` and do:

```bash
brew install pkg-config cairo libpng jpeg libtiff
```

---

## Building

To run R programs, first enter the R environment.

```bash
R
```

Then run each program

```r
source("r/<name_of_file>.r")
```