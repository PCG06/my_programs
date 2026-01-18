"""
    Program 3:
    Cashier has currency notes of 5, 10, 20, 50, 100, 200 and 500.
    Write a Python script to display number of currency notes of each denomination that the cashier
    has to give to the customer for a given amount.
    Display an error message if entered amount is not divisible by 5.
"""

amt = int(input("Enter your amount: "))

if amt % 5 != 0:
    print("Amount is not divisible by 5!")
else:
    n500 = amt // 500
    amt %= 500

    n200 = amt // 200
    amt %= 200

    n100 = amt // 100
    amt %= 100

    n50 = amt // 50
    amt %= 50

    n20 = amt // 20
    amt %= 20

    n10 = amt // 10
    amt %= 10

    n5 = amt // 5
    amt %= 5

    print("\nYour notes are:")
    if n500 != 0:
        print("Notes of 500:", n500)
    if n200 != 0:
        print("Notes of 200:", n200)
    if n100 != 0:
        print("Notes of 100:", n100)
    if n50 != 0:
        print("Notes of 50:", n50)
    if n20 != 0:
        print("Notes of 20:", n20)
    if n10 != 0:
        print("Notes of 10:", n10)
    if n5 != 0:
        print("Notes of 50:", n5)
