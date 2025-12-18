"""
    Program 4:
    Python script to accept issue date and return date and calculate fine, if returned after the due date (15 days), as below:
    1 - 5 days: 0.5.
    6 - 10 days: 1.
    10+ days: 5.
    30+ days: fine and cancel membership.
"""

import datetime as dt

issue_dates = input("Enter date of issue (DD-MM-YYYY): ")
day, month, year = map(int, issue_dates.split("-"))
issue_date = dt.date(year, month, day)

return_dates = input("Enter date of return (DD-MM-YYYY): ")
day, month, year = map(int, return_dates.split("-"))
return_date = dt.date(year, month, day)

date = return_date - issue_date
days = date.days - 15

print("Total days:", date.days)

if date.days <= 15:
    print("No fine!")
elif date.days <= 30:
    if days < 5:
        fine = days * 0.5
    elif days < 10:
        fine = 2.5 + (days - 5) * 1
    else:
        fine = 7.5 + (days - 10) * 5
    print("Pay fine:", fine)
else:
    fine = 7.5 + (days - 10) * 5
    print("Pay fine:", fine)
    print("Your membership has been cancelled.")
print("Thank you!")