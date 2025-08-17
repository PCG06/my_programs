/*
Program 12:
    Create a class hierarchy from:
    - Student with members id and name.
    - StudentExam (derived from Student) with marks of 3 subjects, total.
    - StudentResult (derived from StudentExam) percentage and grade and methods to accept, calculate and display details of n students.
*/

import java.util.Scanner;

class Student
{
    int id;
    String name;
}

class StudentExam extends Student
{
    double m1, m2, m3, total;
}

class StudentResult extends StudentExam
{
    double perc;
    String grade;

    // Taking Scanner as an param because opening a new Scanner for each call from the for loop below causes issues
    void accept(Scanner sc)
    {
        System.out.print("Enter ID: ");
        id = sc.nextInt();
        System.out.print("Enter name: ");
        sc.nextLine();
        name = sc.nextLine();
        System.out.print("Enter marks in 3 subjects: ");
        m1 = sc.nextDouble();
        m2 = sc.nextDouble();
        m3 = sc.nextDouble();
    }

    void calculate()
    {
        total = m1 + m2 + m3;
        perc = total / 3;

        if (m1 < 35 || m2 < 35 || m3 < 35 || perc < 30)
            grade = "Fail";
        else if (perc >= 80)
            grade = "Distinction";
        else if (perc >= 60)
            grade = "First class";
        else if (perc >= 40)
            grade = "Second class";
        else if (perc >= 30)
            grade = "Third class";
        else
            grade = "Pass";
    }

    void display()
    {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.print("Marks in 3 subjects: ");
        System.out.println(m1 + " " + m2 + " " + m3);
        System.out.println("Total: " + total);
        System.out.println("Percentage: " + perc);
        System.out.println("Grade: " + grade);
    }
}

class StudentResultInfo
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        StudentResult[] s = new StudentResult[n];

        System.out.println("\nInput student details");
        for (int i = 0; i < n; i++)
        {
            System.out.println();
            s[i] = new StudentResult();
            s[i].accept(sc); // passing Scanner object argument
            s[i].calculate();
        }

        System.out.println("\n----Student results----");
        for (int i = 0; i < n; i++)
        {
            System.out.println();
            s[i].display();
        }

        sc.close();
    }
}
