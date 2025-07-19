# R script for performing operations on the Iris data set

# Loading the data set
data("iris")

# Viewing the first 6 rows (head defaults to 6)
cat("The first 6 rows of the iris data set:\n")
print(head(iris))

# Summarizing the data set
cat("\nSummary of the iris data set:\n")
print(summary(iris))

# Displaying number of rows and columns
cat("\nNumber of rows: ", nrow(iris))
cat("\nNumber of columns: ", ncol(iris))

# Displaying the column names
cat("\n\nColumn names:\n")
print(colnames(iris))

# Histogram of values for sepal length
cat("\nHistogram of values for sepal length:\n")
hist(iris$Sepal.Length, main="Histogram", xlab="Sepal", ylab="Length", col="green", border="black")
