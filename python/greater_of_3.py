# Python script to find greater of 3 numbers

a, b, c = map(int, input("Enter three numbers: ").split())

if a > b and a > c:
    great = a
elif b > c:
    great = b
else:
    great = c

print(f"Greater number: {great}")
