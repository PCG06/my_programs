/*
Program 10:
    Define a class Distance with objects feet and inches, constructor to read the values and a method sum() to add two feet and inches.
    If total inches is greater than 12, minus it by 12 and increment feet.
    Display the total distance using a separate class.
*/

import java.util.Scanner;

class Distance
{
    int feet, inches;

    Distance(int f, int i)
    {
        feet = f;
        inches = i;
    }

    Distance() {}

    void sum(Distance d1, Distance d2)
    {
        feet = d1.feet + d2.feet;
        inches = d1.inches + d2.inches;
        while (inches >= 12)
        {
            feet += 1;
            inches -= 12;
        }
    }
}

class AddDistance
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter 1st distance feet and inches: ");
        int f1 = sc.nextInt();
        int i1 = sc.nextInt();

        System.out.print("Enter 2nd distance feet and inches: ");
        int f2 = sc.nextInt();
        int i2 = sc.nextInt();

        Distance d1 = new Distance(f1, i1);
        Distance d2 = new Distance(f2, i2);
        Distance total = new Distance();

        total.sum(d1, d2);
        System.out.println("Sum of distances: " + total.feet + "\" " + total.inches + "'");
        sc.close();
    }
}
