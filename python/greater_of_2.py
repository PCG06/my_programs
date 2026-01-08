# Python script to find greater of 2 numbers

a, b = map(int, input("Enter two numbers: ").split())

c = a if a > b else b

print(f"Greater number: {c}")
