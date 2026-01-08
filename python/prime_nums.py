"""
    Program 1:
    Python script to print prime numbers within range 'm' to 'n'.
"""

start, end = map(int, input("Enter the minimum and maximum range: ").split())

if start >= end:
    print("Range is too small.")
else:
    print("The prime number series is: ", end="")
    for n in range(start, end + 1):
        if n > 1:
            for i in range(2, int(n ** 0.5) + 1):
                if n % i == 0:
                    break
            else:  # only runs if the loop didn’t break
                print(n, end=" ")
    print()
