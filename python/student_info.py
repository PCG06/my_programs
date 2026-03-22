"""
    Program 8:
    Python script to create a dict student_info to read register number and name of students.
    Sort and display the dict.
    Read user input to check if record exists in the dict.
"""

student_info = {}

n = int(input("Enter the number of students: "))
for i in range(n):
    reg = int(input("\nEnter register no: "))
    name = input("Enter name: ")
    student_info[reg] = name

print("\nStudent details:")
print("In list:", student_info)
student_info = dict(sorted(student_info.items()))
print("\nSorted order:", student_info)

num = int(input("\nEnter reg no to be searched: "))
if num in student_info.keys():
    print("Student details found\n")
    print("Student name:", student_info[num], "\nRegister no:", num)
else:
    print("Student details not found")
