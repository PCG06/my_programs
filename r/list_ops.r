# R script to create a list containing strings, numerics, vectors and logical values and perform operations

my_list <- list("apple", 100, 1:5, TRUE)
cat("List elements are:\n")
print(my_list)

# Access the first element in the list
cat("\nFirst element in the list:\n")
print(my_list[[1]])

# Give names to the elements in the list
names(my_list) <- c("fruit", "number", "vector", "flag")
cat("\n\nList with named elements:\n")
print(my_list)

# Add element at specified position in the list
my_list$sports <- "football"
cat("\nFifth element is:\n")
print(my_list$sports)

# Remove an element from the given positon
cat("\n\nFourth element is:\n")
print(my_list[[4]])
my_list[[4]] <- NULL
cat("\nNew fourth element (after deletion):\n")
print(my_list[[4]])

# Print the first and third element
cat("\n\nFirst and third elements:\n")
print(my_list[c(1, 3)])

# Update the specified element
cat("\nThird element is:\n")
print(my_list[[3]])
my_list[[3]] <- 10:15
cat("\nUpdated third element:\n")
print(my_list[[3]])

