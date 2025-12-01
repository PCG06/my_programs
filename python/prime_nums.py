"""
    Program 1:
    Python script to print prime numnbers within range 'm' to 'n'
"""

start = int(input("Enter the minimum range: "))
end = int(input("Enter maximum range: "))

for n in range(start, end + 1):
    if n > 1:
        for i in range(2, int(n ** 0.5) + 1):
            if n % i == 0:
                break
        else:  # only runs if the loop didn’t break
            print(n, end=" ")
print()
