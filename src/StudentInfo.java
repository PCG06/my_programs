/*
Program 1:
    Accept student name and marks in 3 subjects.
    Find total marks, average, and grade based on average.
    avg >= 80 = A, avg >= 70 = B, avg >= 60 = C, else D.
*/

import java.util.Scanner;

public class StudentInfo
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
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
        char grade;

        if (avg >= 80)
            grade = 'A';
        else if (avg >= 70)
            grade = 'B';
        else if (avg >= 60)
            grade = 'C';
        else
            grade = 'D';

        System.out.println("Your name: " + name);
        System.out.print("Your marks in 3 subjects: ");
        for (int i = 0; i < 3; i++)
            System.out.print(marks[i] + " ");
        System.out.println();
        System.out.println("Total marks: " + total);
        System.out.println("Average marks: " + avg);
        System.out.println("Grade: " + grade);

        sc.close();
    }
}