# Python script to print Fibonacci series from 'm' to 'n'

start, end = map(int, input("Enter the minimum and maximum range: ").split())

if start >= end:
    print("Range is too small.")
else:
    print("The Fibonacci series is: ", end="")
    f1, f2, f3 = 0, 1, None
    for i in range(0, end + 1):
        if f1 >= start and f1 <= end:
            print(f1, end=" ")
        f3 = f1 + f2
        f1 = f2
        f2 = f3
    print()
