# R script to create a list containing strings, numerics, vectors and logical values and perform operations

my_list <- list("apple", 100, 1:5, TRUE)
cat("List elements are:\n")
print(my_list)

# Access the first element in the list
cat("\nFirst element in the list:\n")
print(my_list[[1]])

# Give names to the elements in the list
names(my_list) <- c("fruit", "number", "vector", "flag")
cat("\nList with named elements:\n")
print(my_list)

# Print the first and third element
cat("\nFirst and third elements:\n")
print(my_list[c(1, 3)])
