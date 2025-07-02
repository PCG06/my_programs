/*
Program 2:
    Accept 2 int numbers and perform an arithmetic operation in a switch case.
*/

import java.util.Scanner;

public class SwitchCalc
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter two numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.print("Enter an operator: ");
        char op = sc.next().charAt(0);

        int result;
        switch (op)
        {
            case '+':
                result = a + b;
                System.out.println(a + " + " + b + " = " + result);
                break;

            case '-':
                result = a - b;
                System.out.println(a + " - " + b + " = " + result);
                break;

            case '*':
                result = a * b;
                System.out.println(a + " * " + b + " = " + result);
                break;

            case '/':
                if (b == 0)
                {
                    System.out.println("Cannot divide number by 0!");
                }
                else
                {
                    result = a / b;
                    System.out.println(a + " / " + b + " = " + result);
                }
                break;

            default:
                System.out.println("Invalid operator!");
                break;
        }
        sc.close();
    }
}
