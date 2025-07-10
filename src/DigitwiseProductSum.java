/*
Program 3:
    Accept 2 int numbers that have same number of digits and output the sum of product of corresponding digits
*/

import java.util.Scanner;

public class DigitwiseProductSum
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter two numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        int rem1, rem2, sum = 0;

        while (a > 0 && b > 0)
        {
            rem1 = a % 10;
            rem2 = b % 10;
            sum = sum + (rem1 * rem2);
            a /= 10;
            b /= 10;
        }

        System.out.println("The sum of product of corresponding digits of is " + sum);

        sc.close();
    }
}
