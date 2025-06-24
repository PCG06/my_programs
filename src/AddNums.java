import java.util.Scanner;

public class AddNums
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter two numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        int sum = a + b;

        System.out.println("The sum of " + a + " and " + b + " is " + sum);

        sc.close(); // Just for VSCode to not show squibbly lines
    }
}
