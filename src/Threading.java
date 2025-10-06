/*
Program 17:
    - Create child classes to get Square and Cube of numbers to inherit Thread.
    - Create a child class Number to inherit Thread to generate n number of random integers and perform squaring if even and cubing if odd.
*/

import java.lang.Thread;
import java.util.Random;
import java.util.Scanner;

class Square extends Thread
{
    int x;

    Square(int n)
    {
        x = n;
    }

    public void run()
    {
        int sqr = (int) Math.pow(x, 2);
        System.out.println("Square: " + sqr + "\n");
    }
}

class Cube extends Thread
{
    int x;

    Cube(int n)
    {
        x = n;
    }

    public void run()
    {
        int cub = (int) Math.pow(x, 3);
        System.out.println("Cube: " + cub + "\n");
    }
}

class Number extends Thread
{
    int n;

    Number(int num)
    {
        n = num;
    }

    public void run()
    {
        Random rng = new Random();

        for (int i = 0; i < n; i++)
        {
            int rno = rng.nextInt(25);
            System.out.println("Random integer: " + rno);
            if (rno % 2 == 0)
            {
                Square s = new Square(rno);
                s.start();
            }
            else
            {
                Cube c = new Cube(rno);
                c.start();
            }
            try
            {
                // Wait for 1 second after each print
                sleep(1000);
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
    }
}

public class Threading
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter maximum elements: ");
        int num = sc.nextInt();

        Number n = new Number(num);
        n.start();

        sc.close();
    }
}
