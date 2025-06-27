// Simple java program to accept two inputs and return sum, difference, product and quotient

import java.util.Scanner;

public class Calc
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter two numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        int sum = a + b;
        System.out.println(a + " + " + b + " = " + sum);

        int diff = a - b;
        System.out.println(a + " - " + b + " = " + diff);

        int prod = a * b;
        System.out.println(a + " * " + b + " = " + prod);

        float quot = (float) a / b;
        System.out.println(a + " / " + b + " = " + quot);

        sc.close();
    }
}
