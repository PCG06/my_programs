# Lab assignment 1 answers

# Check if Characters are Present in a String
string <- "hello"
cat("String:", string)
var1 <- grepl("e", string)
var2 <- grepl("i", string)
cat("\nDoes string contain 'e':", var1)
cat("\nDoes string contain 'i':", var2)

# Extract n Characters From a String
string <- "programming"
cat("\n\nString:", string)
var1 <- substr(string, 1, 3)
var2 <- substr(string, 9, 11)
cat("\nFirst 3 characters of the string:", var1)
cat("\nFirst 3 characters of the string:", var2)

# Replace Characters in a String
string <- "playing"
cat("\n\nString:", string)
string <- gsub("play", "sleep", string)
cat("\nString after replacing:", string)

# Compare Two Strings
string <- "hello"
string2 <- "hello"
cat("\n\nStrings:", string, string2)
if (string == string2) { # identical(string, string2) also works
    cat("\nStrings are identical")
} else {
    cat("\nStrings are not identical")
}

# Convert Factors to Characters (vector)
fac <- factor(c("apple", "banana", "orange"))
cat("\n\nFactor:")
print(fac)
cat("Class:", class(fac))
char_vec <- as.character(fac) # becomes a vector of characters
cat("\nVector:", char_vec)
cat("\nClass:", class(char_vec))

# The maximum value in a vector using a for loop
vec1 <- c(10, 15, 34, 19, 5, 28)
max <- vec1[1]
for (x in vec1[-1]) {
    if (max < x) {
        max <- x
    }
}
cat("\n\nThe vector:", vec1)
cat("\nThe maximum value is:", max)

# Reversing a vector using a for loop
vec <- c(1, 2, 3, 4, 5)
rev_vec <- c()
for (i in length(vec):1) {
  rev_vec <- c(rev_vec, vec[i])
}
cat("\n\nThe original vector:", vec)
cat("\nThe reversed vector:", rev_vec)

#  Counting the number of even and odd elements in a vector using a for loop
vec3 <- c(1, 2, 3, 4, 5, 6, 7, 8, 9)
even_count <- 0
odd_count <- 0
cat("\n\nThe vector:", vec3)
for (x in vec3) {
    if (x %% 2 == 0) {
        even_count <- even_count + 1
    } else {
        odd_count <- odd_count + 1
    }
}
cat("\nOdd numbers:", odd_count)
cat("\nEven numbers:", even_count)

# While loop to calculate the factorial of a number
num <- 5
factorial <- 1
while (num > 0) {
  factorial <- factorial * num
  num <- num - 1
}
cat("\n\nFactorial of 5:", factorial)

# While loop to calculate the square of numbers
num <- 5
i <- 1
cat("\n\n")
while (i <= num) {
    sq <- i ^ 2
    cat("Square of", i,"is", sq)
    cat("\n")
    i <- i + 1
}

# While loop to reverse a string
string <- "everyone"
rev_str <- ""
i <- nchar(string)
while (i > 0) {
    rev_str <- paste0(rev_str, substr(string, i, i))
    i <- i - 1
}
cat("\n\nThe original string:", string)
cat("\nThe reversed string:", rev_str)

# Multiply Matrix by Vector
vec <- c(2, 4, 6)
mat <- matrix(c(1, 2, 3, 4, 5, 6, 7, 8, 9), nrow <- 3, ncol <- 3, byrow <- TRUE)
result <- mat %*% vec
cat("\n\nThe matrix:\n")
print(mat)
cat("\nThe vector:", vec)
cat("\nThe result:\n")
print(result)

# Combine Two Dataframe into One
df1 <- data.frame(
    ID = c(1, 2, 3, 4, 5),
    Category = c("A", "B", "C", "D", "E")
)
df2 <- data.frame(
    ID = c(1, 2, 3, 4, 5),
    Quantity = c(100, 200, 300, 400, 500)
)
cat("\n\nDataframe 1:\n")
print(df1)
cat("\nDataframe 2:\n")
print(df2)
merged_df <- merge(df1, df2, by <- "ID")
cat("\nMerged dataframe:\n")
print(merged_df)

# Delete Rows From Dataframe
df1 <- df1[-5, ]
cat("\n\nDataframe 1:\n")
print(df1)

# Make a List of Dataframes
df_list <- list(df1, df2, merged_df)
cat("\n\nList of dataframes:\n")
print(df_list)

# Convert factor levels to list
fac <- factor(c("car", "bike", "bus", "truck"))
cat("\n\nFactor:\n")
print(fac)
fac_list <- as.list(levels(fac))
cat("\nList:\n")
print(fac_list)
