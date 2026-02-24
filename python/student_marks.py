"""
    Program 13:
    Python script to read student marks and calculate the result using class and constructors
"""

class Student:
    def __init__(self, name, regno):
        self.name = name
        self.regno = regno

    def read_marks(self, m1, m2, m3, m4):
        self.marks = {"Python": m1, "CONA": m2, "OS": m3, "FA": m4}

    def calc_result(self):
        self.total = sum(self.marks.values())
        self.percentage = self.total / len(self.marks)
        if self.percentage >= 75:
            self.result = "Distinction"
        elif self.percentage >= 65:
            self.result = "First class"
        elif self.percentage >= 55:
            self.result = "Second class"
        elif self.percentage >= 45:
            self.result = "Third class"
        else:
            self.result = "Fail"

    def display_details(self):
        print("Name:", self.name)
        print("Reg No:", self.regno)
        print("Marks:", self.marks)
        print("Total:", self.total)
        print("Percentage:", self.percentage)
        print("Result:", self.result)

name = input("Enter name: ")
regno = int(input("Enter reg no: "))
m1, m2, m3, m4 = map(int, input("Enter marks in Python, CONA, OS, FA: ").split())
st = Student(name, regno)
st.read_marks(m1, m2, m3, m4)
st.calc_result()
st.display_details()
