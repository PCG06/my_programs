# R script to compute regression and predict the value of Y when X=7

x <- c(2, 4, 5, 6, 8, 11)
y <- c(18, 12, 10, 8, 7, 5)

data <- data.frame(
    "x" = x,
    "y" = y
)

cat("\n---Data---\n")
print(data, right=FALSE, row.names=FALSE)

myonx <- lm(y ~ x)
cat("\nRegression equation of Y on X: Y =", round(coef(myonx)[1], 4), "+", round(coef(myonx)[2], 4), "X\n")

mxony <- lm(x ~ y)
cat("Regression equation of X on Y: X =", round(coef(mxony)[1], 4), "+", round(coef(mxony)[2], 4), "Y\n")

y_pred <- predict(myonx, newdata = data.frame(x = 7))
cat("Predicted value of Y when X = 7:", round(y_pred, 4), "\n")
