/*
Program 7:
    Create a matrix having various different number of columns for each row and print row wise sum
*/

class JaggedMatrix
{
    public static void main(String[] args)
    {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7}, {8, 9}};

        System.out.println("Array elements are:");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print("Row " + (i + 1) + ": ");
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }

        System.out.println("\nSum of individual rows:");
        for (int i = 0; i < arr.length; i++)
        {
            int sum = 0;
            for (int j = 0; j < arr[i].length; j++)
                sum += arr[i][j];
            System.out.println("Row " + (i + 1) + ": " + sum);
        }
    }
}
