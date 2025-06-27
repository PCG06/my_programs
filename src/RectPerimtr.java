// Simple java program to calculate perimeter of a rectangle

import java.util.Scanner;

public class RectPerimtr
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length: ");
        int l = sc.nextInt();
        
        System.out.print("Enter the breadth: ");
        int b = sc.nextInt();

        int peri = 4 * (l + b);

        System.out.println("The perimeter of the rectangle is " + peri);

        sc.close();
    }
}
