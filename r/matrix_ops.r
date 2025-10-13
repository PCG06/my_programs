# R script to create 2 3x3 matrices A and B and perform operations

A <- matrix(1:9, nrow=3, ncol=3, byrow=TRUE)
B <- matrix(1:9, nrow=3, ncol=3, byrow=FALSE)

cat("The 3x3 matrices are\n")
cat("Matrix A\n")
print(A)
cat("Matrix B\n")
print(B)

# Transpose of A * B
W <- t(A) %*% B
cat("\nTranpose of A * B\n")
print(W)

# Transpose of B * (A * tranpose of A)
X <- t(B) %*% (A %*% t(A))
cat("\nTranspose of B * (A * tranpose of A)\n")
print(X)

# Transpose of (A * tranpose of A) * B
Y <- (A %*% t(A)) %*% t(B)
cat("\nTranspose of (A * tranpose of A) * B\n")
print(Y)

# Transpose of [(B * tranpose of B) + (A * tranpose of A)]
Z <- (B %*% t(B)) + (A %*% t(A))
cat("\nTranspose of [(B * tranpose of B) + (A * tranpose of A)]\n")
print(Z)