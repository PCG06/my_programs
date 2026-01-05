"""
    Program 11:
    Python script to input 2 matrices and perform addition and subtraction
"""

import numpy as np

m, n = map(int, input("Enter number of rows and columns: ").split())

a = np.zeros((m, n), int)
b = np.zeros((m, n), int)

print("\nEnter elements of matrix 1:")
for i in range(m):
    for j in range(n):
        a[i][j] = int(input())

print("\nEnter elements of matrix 2:")
for i in range(m):
    for j in range(n):
        b[i][j] = int(input())

print("\nElements of matrix 1 are:\n", a)
print("\nElements of matrix 2 are:\n", b)

c = np.add(a, b)
d = np.subtract(a, b)

print("\nAddition of 2 matrices:\n", c)
print("\nSubtraction of 2 matrices:\n", d)
