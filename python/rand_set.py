"""
    Program 9:
    Python script to create a set with 10 random numbers between range 15 to 45.
    Count numbers that are < 30.
    Delete numbers > 35.
"""

import random

s = set()
count = 0

for i in range(10):
    r = random.randint(15, 45)
    s.add(r)
print("Set elements are:", s)

for i in set(s):
    if i <= 30:
        count += 1
    elif i > 35:
        s.remove(i)
print("Set after deleting elements > 35:", s)
print("Count of elements < 30:", count)
