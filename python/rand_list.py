"""
    Program 5:
    Python script to create a list with 'n' number of random elements and count occurance of each element using a dictionary
"""

import random as r

n = int(input("Enter the number of random elements: "))
start, end = map(int, input("Enter the minimum and maximum range: ").split())

if start >= end:
    print("Range is too small.")
else:
    ran_lis = []
    for i in range(n):
        ran_lis.append(r.randint(start, end + 1))

    cnt_dict = {}
    for i in ran_lis:
        cnt_dict[i] = ran_lis.count(i)

    print("\nList of random elements:", ran_lis)
    print("Occurances of each element:", cnt_dict)
