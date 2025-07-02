/*
Program 1:
    Accept student register number, name and marks in 3 subjects.
    Find total marks, average, and grade based on average.
    if avg < 35 or marks in any subject < 35: Fail,
    avg >= 80: Distinction, avg >= 70: First class, avg >= 60: Second class, else Pass class.
*/

import java.util.Scanner;

public class StudentInfo
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter reg no: ");
        int regno = sc.nextInt();

        System.out.print("Enter name: ");
        sc.nextLine();
        String name = sc.nextLine();

        System.out.print("Enter marks in 3 subjects: ");
        // Can do without arrays too, but arrays are cool
        int marks[] = new int[3]; // Gotta init first
        int total = 0;
        for (int i = 0; i < 3; i++)
        {
            marks[i] = sc.nextInt();
            total += marks[i];
        }
        float avg = (float) total / 3;

        System.out.println("-----------------");
        System.out.println("Your reg no: " + regno);
        System.out.println("Your name: " + name);
        System.out.print("Your marks in 3 subjects: ");
        for (int i = 0; i < 3; i++)
            System.out.print(marks[i] + " ");
        System.out.println();
        System.out.println("Total marks: " + total);
        System.out.println("Average marks: " + avg);
        System.out.print("Grade: ");
        if (avg < 35 || marks[0] < 35 || marks[1] < 35
            || marks[2] < 35)
            System.out.println("Fail");
        else if (avg >= 80)
            System.out.println("Distinction");
        else if (avg >= 70)
            System.out.println("First class");
        else if (avg >= 60)
            System.out.println("Second class");
        else
            System.out.println("Pass class");

        sc.close();
    }
}