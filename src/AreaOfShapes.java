/*
Program 14:
    Create an abstract class named Shape that contains 2 ints and an empty method printArea().
    Create three child classes Rectangle, Triangle and Ellipse to define printArea().
    Create a main class to utilize these child classes.
*/

import java.util.Scanner;

abstract class Shape
{
    int a, b;
    abstract void printArea();
}

class Rectangle extends Shape
{
    void printArea()
    {
        // length * breath
        System.out.println("Area of rectangle: " + (a * b));
    }
}

class Triangle extends Shape
{
    void printArea()
    {
        // 1/2 * base * height
        System.out.println("Area of triangle: " + (0.5 * a * b));
    }
}

class Ellipse extends Shape
{
    void printArea()
    {
        // pi * a * b
        System.out.println("Area of ellipse: " + (Math.PI * a * b));
    }
}

public class AreaOfShapes
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Shape s;

        s = new Rectangle();
        System.out.print("Enter length and breath: ");
        s.a = sc.nextInt();
        s.b = sc.nextInt();
        s.printArea();

        s = new Triangle();
        System.out.print("Enter base and height: ");
        s.a = sc.nextInt();
        s.b = sc.nextInt();
        s.printArea();

        s = new Ellipse();
        System.out.print("Enter major and minor axes: ");
        s.a = sc.nextInt();
        s.b = sc.nextInt();
        s.printArea();

        sc.close();
    }
}
