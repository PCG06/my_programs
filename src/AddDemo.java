// Simple java program to use inheritance concept

import java.util.Scanner;

class ParentClass_A
{
    int n1, n2;

    void getnumbers(int n1, int n2)
    {
        this.n1 = n1;
        this.n2 = n2;
    }
}

class ChildClass_B extends ParentClass_A
{
    int addnumbers()
    {
        return (n1 + n2);
    }
}

public class AddDemo
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ChildClass_B objB = new ChildClass_B();

        System.out.print("Enter 2 numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        objB.getnumbers(a, b);
        int sum = objB.addnumbers();

        System.out.println("Sum: " + sum);
        sc.close();
    }
}
