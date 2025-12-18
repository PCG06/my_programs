"""
    CONA: Matrix norms using NumPy
"""

import numpy as np

A = np.array([[6, 7, 3], [1, 9, 5], [8, 4, 2]])
B = np.array([[3, 9, 4], [7, 5, 2], [6, 8, 1]])
AB = A + B

# Frobenius norm (root of sum of squares of all elements)
A_fNorm = np.linalg.norm(A)
B_fNorm = np.linalg.norm(B)
AB_fNorm = np.linalg.norm(AB)
A_B_fNorm = A_fNorm + B_fNorm

# 1-norm (max column sum)
A_1Norm = np.linalg.norm(A, 1)
B_1Norm = np.linalg.norm(B, 1)

# Infinity norm (max row sum)
A_infNorm = np.linalg.norm(A, np.inf)
B_infNorm = np.linalg.norm(B, np.inf)

print("Frobenius norm of A:", A_fNorm)
print("1-norm of A:", A_1Norm)
print("Infinity norm of A:", A_infNorm)

print("\nFrobenius norm of B:", B_fNorm)
print("1-norm of B:", B_1Norm)
print("Infinity norm of B:", B_infNorm)

print("\nFrobenius norm of A+B:", AB_fNorm)

tri_inequ = AB_fNorm < A_B_fNorm

print(f"Triangle inequality proved. ({AB_fNorm} < {A_B_fNorm})" if tri_inequ else f"Triangle inequality not proved. ({A_B_fNorm} < {AB_fNorm})")
