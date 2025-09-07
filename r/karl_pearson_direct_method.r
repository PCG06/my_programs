# R script to calculate coeffecient of correlation using Karl Pearson's direct method

X <- c(11, 13, 14, 16, 16, 15, 15, 14, 13, 13)
Y <- c(50, 50, 55, 60, 65, 65, 65, 60, 60, 50)

XY <- X * Y
Xsq <- X * X
Ysq <- Y * Y

data <- data.frame(
    "X" = X,
    "Y" = Y,
    "XY" = XY,
    "Xsq" = Xsq,
    "Ysq" = Ysq
)

cat("\n---Mean data---\n")
print(data, right=FALSE, row.names=FALSE)

n <- length(X)
sumX <- sum(X)
sumY <- sum(Y)
sumXY <- sum(XY)
sumXsq <- sum(Xsq)
sumYsq <- sum(Ysq)

cat("\nNumber of observations:", n)
cat("\nSum of X:", sumX)
cat("\nSum of Y:", sumY)
cat("\nSum of X*X:", sumXsq)
cat("\nSum of Y*Y:", sumYsq)
cat("\nSum of X*Y:", sumXY)

r <- (((n * sumXY) - (sumX * sumY)) / sqrt((n * sumXsq - (sumX^2)) * (n * sumYsq - (sumY^2))))

cat("\n\nKarl Pearson's Correlation Coefficient (r):", r)

cat("\nCorrelation type:\n")
if (r > 0) {
    cat("Positive\n")
} else if (r < 0) {
    cat("Negative\n")
} else {
    cat("No correlation\n")
}