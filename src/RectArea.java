import java.util.Scanner;

public class RectArea
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length: ");
        int l = sc.nextInt();
        
        System.out.print("Enter the breadth: ");
        int b = sc.nextInt();

        int area = l * b;

        System.out.println("The area of the rectangle is " + area);

        sc.close();
    }
}
