"""
    Program 7:
    Python script to create a dictionary to store data of employees
    and pay overtime of 12/hr for every hour worked above 40.
    Employees don't work for fractional part of an hour (full hour only).
"""

n = int(input("Enter the number of employees: "))

emp = {}
for i in range(n):
    print()
    eno = int(input("Enter employee number: "))
    ename = input("Enter employee name: ")
    hrs = int(input("Enter no. of hours worked: "))

    emp[eno] = []
    emp[eno].append(ename)

    if hrs > 40:
        overtime = hrs - 40
        otpay = overtime * 12
    else:
        overtime = 0
        otpay = 0
    
    emp[eno].extend([overtime, otpay])

print("Employee details:")
print("Emp no\t\tdetails (name, overtime, otpay)")
for i in emp:
    print(i, "\t\t", emp[i])
