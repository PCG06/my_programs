/*
Program 15:
    - Create 2 packages Temperature and Interest.
    - Temperature will have 2 classes to convert Centigrade int Fahrenheit and vive versa.
    - Interest will have a class to calculate simple interest.
    - Create a main class to take user input and calculate the result.
*/

import Package.Interest.*;
import Package.Temperature.*;
import java.util.Scanner;

public class TempAndInterest
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter temperature in C: ");
        Centi2Fahr c2f = new Centi2Fahr(sc.nextDouble());
        System.out.println("Temperature in F: " + c2f.convertToFahr());

        System.out.print("Enter temperature in F: ");
        Fahr2Centi f2c = new Fahr2Centi(sc.nextDouble());
        System.out.println("Temperature in C: " + f2c.convertToCenti());

        System.out.print("Enter principle amount: ");
        double p = sc.nextDouble();
        System.out.print("Enter time: ");
        double t = sc.nextDouble();
        System.out.print("Enter rate of interest: ");
        double r = sc.nextDouble();
        SimpleInterest si = new SimpleInterest(p, t, r);
        System.out.println("Simple interest: " + si.calculate());

        sc.close();
    }
}
