"""
    Program 2:
    Python script to print a star pattern in increasing and decreasing width
"""

n = int(input("Enter the width: "))

# Increasing width
for i in range(n):
    for j in range(0, i + 1):
        print("*", end="")
    print()

# Decreasing width
for i in range(n - 1, 0, -1):
    for j in range(0, i):
        print("*", end="")
    print()
