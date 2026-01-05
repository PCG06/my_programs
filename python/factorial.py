"""
    Program ?:
    Python script to perform recursion to find factorial of a number
"""

def factorial(n: int) -> int:
    if n > 1:
        return n * factorial(n - 1)
    if n < 0:
        return 0
    return 1

num = int(input("Enter a number: "))
facto = factorial(num)
print(f"Factorial of {num} is {facto}")
