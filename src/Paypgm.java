/*
Program 9:
    Define a class Pay with name and salary.
    Calculate DA (15%), HRA (10%), PF (12%), gross and net salary.
    Display all salary details using methods.
*/

import java.util.Scanner;

class Pay
{
    String name;
    double salary, da, hra, pf, gross, net;

    Pay(String n, double s)
    {
        name = n;
        salary = s;
    }

    void calculate()
    {
        da = salary * 0.15;
        hra = salary * 0.10;
        pf = salary * 0.12;
        gross = salary + da + hra;
        net = gross - pf;
    }

    void display()
    {
        System.out.println("-----------------");
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("DA: " + da);
        System.out.println("HRA: " + hra);
        System.out.println("PF: " + pf);
        System.out.println("Gross Salary: " + gross);
        System.out.println("Net Salary: " + net);
    }
}

public class Paypgm
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your salary: ");
        double salary = sc.nextDouble();

        Pay p = new Pay(name, salary);
        p.calculate();
        p.display();

        sc.close();
    }
}
