/*
Program 4:
    Accept lower and upper limit for the Fibonacci series and print the series
*/

import java.util.Scanner;

public class Fibonacci
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter lower and upper limit: ");
        int low = sc.nextInt();
        int up = sc.nextInt();

        if (low >= up)
        {
            System.out.println("Upper limit is too low!");
        }
        else
        {
            System.out.print("The Fibonacci series is: ");
            for (int f1 = 0, f2 = 1, f3; f1 < up; ) // the increment happens inside the body of the loop
            {
                if (f1 >= low)
                    System.out.print(f1 + " ");
                f3 = f1 + f2;
                f1 = f2;
                f2 = f3;
            }
            System.out.println();
        }

        sc.close();
    }
}
