/*
Program 5:
    Accept an array and check if its mirror inversed or not.
    Use array: 3 4 2 0 1
*/

import java.util.Scanner;

public class MirrorInverse
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter the array elements: ");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        boolean isMirrored = true;
        for (int i = 0; i < n; i++)
        {
            if (arr[arr[i]] != i)
            {
                isMirrored = false;
                break;
            }
        }

        if (isMirrored)
            System.out.println("The array is mirror inverse!");
        else
            System.out.println("The array is not mirror inverse!");
        
        sc.close();
    }
}
