// Simple java program to check if inputted number is even or odd

import java.util.Scanner;

public class EvenOrOdd
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        boolean res = (num % 2) == 0 ? true : false;

        if (res)
            System.out.println("Even number!");
        else
            System.out.println("Odd number!");

        sc.close();            
    }
}
