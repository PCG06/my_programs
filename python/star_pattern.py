"""
    Program 2:
    Python script to print a star pattern in increasing and decreasing width
"""

n = int(input("Enter the width: "))

# Increasing width
for i in range(1, n + 1):
    print("*" * i)

# Decreasing width
for i in range(n - 1, 0, -1):
    print("*" * i)
