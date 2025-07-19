/*
Program 6:
    Accept 2 matrices and display it's sum and difference.
*/

import java.util.Scanner;

public class MatrixAddSub
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter row and column size: ");
        int row = sc.nextInt();
        int col = sc.nextInt();

        int[][] a = new int[row][col];
        int[][] b = new int[row][col];
        int[][] sum = new int[row][col];
        int[][] diff = new int[row][col];

        System.out.println("Enter matrix 1 elements:");
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                a[i][j] = sc.nextInt();

        System.out.println("Enter matrix 2 elements:");
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                b[i][j] = sc.nextInt();

        
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                sum[i][j] = a[i][j] + b[i][j];
                diff[i][j] = a[i][j] - b[i][j];
            }
        }

        System.out.println("\nThe sum of 2 matrices is:");
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
                System.out.print(sum[i][j] + " ");
            System.out.println();
        }

        System.out.println("\nThe difference of 2 matrices is:");
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
                System.out.print(diff[i][j] + " ");
            System.out.println();
        }

        sc.close();
    }
}