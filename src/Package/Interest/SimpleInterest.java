// Part of program 15: Class to calculate simple interest

package Package.Interest;

public class SimpleInterest
{
    double p, t, r;

    public SimpleInterest(double principle, double time, double rate)
    {
        p = principle;
        t = time;
        r = rate;
    }

    public double calculate()
    {
        return (p * t * r);
    }
}
