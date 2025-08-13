/*
Program 11:
    Create a class named Member with data members name, age, phone number, place and salary and method printSalary().
    Inherit it into Employee and Manager classes with data members specialization and department.
    Input 1 employee and manager and display it.
*/

import java.util.Scanner;

class Member
{
    String name, phoneNum, place;
    int age;
    double salary;

    void printSalary()
    {
        System.out.println("Salary: " + salary);
    }
}

class Employee extends Member
{
    String specialization;

    void printDetails()
    {
        System.out.println("\n----Employee details----");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Phone: " + phoneNum);
        System.out.println("Place: " + place);
        System.out.println("Specialization: " + specialization);
    }
}

class Manager extends Member
{
    String department;

    void printDetails()
    {
        System.out.println("\n----Manager details----");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Phone: " + phoneNum);
        System.out.println("Place: " + place);
        System.out.println("Department: " + department);
    }
}

public class Office
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Employee emp = new Employee();
        emp.name = "Jaison";
        emp.age = 45;
        emp.phoneNum = "1234567890";
        emp.place = "Dubai";
        emp.specialization = "Software developer";
        emp.salary = 50000.0;

        Manager mgr = new Manager();
        mgr.name = "Adithya";
        mgr.age = 27;
        mgr.phoneNum = "9876543210";
        mgr.place = "Delhi";
        mgr.department = "IT";
        mgr.salary = 90000.0;

        emp.printDetails();
        emp.printSalary();

        mgr.printDetails();
        mgr.printSalary();

        sc.close();
    }
}
