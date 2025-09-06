// Part of program 15: Class to convert Centigrade to Fahrenheit

package Package.Temperature;

public class Centi2Fahr
{
    double c;

    public Centi2Fahr(double temp)
    {
        c = temp;
    }

    public double convertToFahr()
    {
        return ((c * 9.0 / 5.0) + 32);
    }
}
