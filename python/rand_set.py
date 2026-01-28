"""
    Program 9:
    Python script to create a set with 10 random numbers between range 15 to 45.
    Count numbers that are < 30.
    Delete numbers > 35.
"""

import random

b = set()
count = 0

for i in range(10):
    r = random.randint(15, 45)
    b.add(r)
print("Set elements are:", b)

for i in set(b):
    if i <= 30:
        count += 1
    elif i > 35:
        b.remove(i)
print("Set after deleting elements > 35:", b)
print("Count of elements < 30:", count)
