# R script to find mean, median and mode of ungrouped data

data <- c(10, 20, 30, 40, 50, 20, 30, 90)
cat("The data:\n")
print(data)

# Mean
mean_value <- mean(data)
cat("\nMean:", mean_value)

# Median
median_value <- median(data)
cat("\nMedian:", median_value)

# Mode
get_mode <- function(x) {
    uniq_vals <- unique(x)
    mode_val <- uniq_vals[which.max(tabulate(match(x, uniq_vals)))]
    return(mode_val)
}
mode_value <- get_mode(data)
cat("\nMode:", mode_value)
