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
hist(iris$Sepal.Length, main="Histogram", xlab="Sepal", ylab="Length", col="green", border="black")

# Scatterplot of sepal width vs sepal length
plot(iris$Sepal.Width, iris$Sepal.Length, main="Scatterplot of Sepal Length vs Sepal Width", xlab="Sepal Length", ylab="Sepal Width")

# Boxplot of sepal width vs sepal length
boxplot(iris$Sepal.Width~iris$Sepal.Length, main="Boxplot of Sepal Length vs Sepal Width", xlab="Sepal Length", ylab="Sepal Width")

# Pearson's correlation between sepal length and petal length
cor_sl_pl <- cor(iris$Sepal.Length, iris$Petal.Length)
cat("\nPearson's correlation between Sepal Length and Petal Length:", cor_sl_pl, "\n")

# Pearson's correlation matrix for dataset
cor_matrix <- cor(iris[, 1:4])
cat("\nPearson's correlation matrix")
print(cor_matrix)
