# R script to create a factor for marital status and perform operations on it

marital_status <- factor(c("married", "single", "divorced"))

cat("The marital status factor:\n")
print(marital_status)

# Check if the variable is a factor
cat("\nFactor check: ")
print(is.factor(marital_status))

# Access the second and fourth elements of the factor
cat("\nSecond and fourth elements of the factor:\n") # Fourth element doesn't exist in the factor
print(marital_status[c(2,4)])

# Remove the third element from the factor
cat("\nThird element of the factor:\n")
print(marital_status[3])
marital_status <- marital_status[-3]
cat("\nRemoved third element from the factor:\n")
print(marital_status)

# Modify the second elements of the factor
cat("\nModified second element from the factor:\n")
marital_status[2] <- "married"
print(marital_status)

# Add a new level "widow" to the factor
cat("\nAdding new level to the factor:\n")
levels(marital_status) <- c(levels(marital_status), "widow")
print(levels(marital_status))
