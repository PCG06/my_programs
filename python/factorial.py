"""
    Program 10:
    Python script to create a list of numbers and find their factorials using a recursive function
"""

def factorial(n: int) -> int:
    if n < 2:
        return 1
    else:
        return n * factorial(n - 1)


lis = []
n = int(input("Enter number of elements: "))
print("Enter the elements:")
for i in range(n):
    lis.append(int(input()))
fact = list(map(factorial, lis))
print("Enter numbers are:", lis)
print("Corresponding factorials are:", fact)
