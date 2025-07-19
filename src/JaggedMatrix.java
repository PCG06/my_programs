/*
Program 7:
    Create a matrix having various different number of columns for each row and print row wise sum
*/

import java.util.Scanner;

public class JaggedMatrix
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int row = sc.nextInt();

        int[][] matrix = new int[row][]; // Create a 2D array with known row size
        for (int i = 0; i < row; i++)
        {
            int rowNum = i + 1;
            System.out.print("Enter number of columns for row " + rowNum + ": ");
            int cols = sc.nextInt();
            matrix[i] = new int[cols]; // Now with different column size

            System.out.print("Enter " + cols + " values for row " + rowNum + ": ");
            for (int j = 0; j < cols; j++)
                matrix[i][j] = sc.nextInt();
        }

        // Calculate and print row-wise sums
        System.out.println("\nRow-wise sums:");
        for (int i = 0; i < row; i++)
        {
            int rowNum = i + 1;
            int sum = 0;

            for (int val : matrix[i])
                sum += val;

            System.out.println("Sum of row " + rowNum + ": " + sum);
        }

        sc.close();
    }
}
