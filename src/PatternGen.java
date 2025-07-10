// Simple java program to create a pattern

import java.util.Scanner;

public class PatternGen
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a symbol: ");
        char sym = sc.next().charAt(0);

        System.out.print("Enter the number of times: ");
        int n = sc.nextInt();

        for (int i = n; i >= 1; i--)
        {
            for (int j = 0; j < i; j++)
            {
                System.out.print(sym);
            }
            System.out.println();
        }
        sc.close();
    }
}
