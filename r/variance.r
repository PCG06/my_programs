# R script to find population variance and sample variance

x <- c (12, 15, 10, 18, 14, 16)

n <- length(x)
mean_value <- mean(x)

x_u <- x - mean_value
x_u_sq <- x_u * x_u

data <- data.frame (
    "x" = x,
    "x_u" = x_u,
    "x_u_sq" = x_u_sq
)

sum_x_u_sq = sum(x_u_sq)

cat("\n---Data---\n")
print(data, right=FALSE, row.names=FALSE)

cat("\nNumber of observations:", n)
cat("\nSum of X-u^2:", sum_x_u_sq)

pv <- sum_x_u_sq / n
sv <- sum_x_u_sq / (n - 1)

cat("\n\nPopulation variance:", pv)
cat("\nSample variance:", sv, "\n")
