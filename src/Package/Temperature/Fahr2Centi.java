// Part of program 15: Class to convert Fahrenheit to Centigrade

package Package.Temperature;

public class Fahr2Centi
{
    double f;

    public Fahr2Centi(double temp)
    {
        f = temp;
    }

    public double convertToCenti()
    {
        return ((f - 32) * 5.0 / 9.0);
    }
}
