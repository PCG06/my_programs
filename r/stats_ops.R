# R script to perform statistical operations on a numerical vector

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

# Range
range_values <- range(data)
range_val <- range_values[2] - range_values[1]
cat("\n\nRange:", range_val)

# 35th and 78th percentile
perc_35 <- quantile(data, 0.35)
perc_78 <- quantile(data, 0.78)
cat("\n\nValue of 35th percentile:", perc_35)
cat("\nValue of 78th percentile:", perc_78)

# Standard deviation and variance
std_dev <- sd(data)
cat("\n\nStandard deviation:", std_dev)
variance <- var(data)
cat("\nVariance:", variance)

# Inter-quartile range
q1 <- quantile(data, 0.25)
q3 <- quantile(data, 0.75)
iqr <- q3 - q1
cat("\n\nInter-quartile range:", iqr)

# Z-scores for all elements
z_scores <- scale(data)
cat("\n\nZ-score:\n")
print(z_scores, right=FALSE, row.names=FALSE)
