/*
Program 16:
    - Create a child class ZeroElementException to inherit Exception.
    - Create a main class to test out the Exception.
*/

import java.util.Scanner;
import java.lang.Exception;

class ZeroElementException extends Exception
{
    public ZeroElementException(String message)
    {
        super(message);
    }
}

public class ExceptionHandling
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int[] arr;

        try
        {
            System.out.print("Enter array size: ");
            int n = sc.nextInt();
            arr = new int[n];

            System.out.print("Enter " + n + " elements: ");
            for (int i = 0; i < n; i++)
            {
                int ele = sc.nextInt();
                if (ele == 0)
                {
                    throw new ZeroElementException("Array element cannot be zero! (at index: " + i + ")");
                }
                arr[i] = ele;
            }
            System.out.println("Array elements and their indexes");
            for (int i = 0; i <= n; i++) // purposely done to cause 'ArrayIndexOutOfBoundsException()'
            {
                System.out.println("Index " + i + ": " + arr[i]);
            }
        }
        catch (ZeroElementException e)
        {
            System.out.println("Zero element exception caught: " + e.getMessage());
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Array index out of bounds exception caught: " + e.getMessage());
        }
        catch (Exception e)
        {
            System.out.println("General exception caught: " + e.getMessage());
        }
        finally
        {
            sc.close();
        }
    }
}
