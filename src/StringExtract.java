/*
Program 8:
    Extract 'n' characters from a string starting at position 'm'
*/

import java.util.Scanner;

public class StringExtract
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        System.out.print("Enter starting position: ");
        int m = sc.nextInt();

        System.out.print("Enter number of characters to extract: ");
        int n = sc.nextInt();

        if (m - 1 < 1 || m > str.length())
        {
            System.out.println("Invalid starting position");
        }
        else if (m + n - 1 > str.length())
        {
            System.out.println("Not enough characters to extract");
        }
        else
        {
            String extracted = str.substring(m - 1, m - 1 + n);
            System.out.println("Extracted string: " + extracted);
        }

        sc.close();
    }
}
