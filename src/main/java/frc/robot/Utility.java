package frc.robot;

public class Utility
{
    public static double applySinTransformation(double x)
    {
        if (x != 0)
        {
        return Math.abs(x)/x *multiplier* (-Math.cos(x*Math.PI)+1)/2;
        }
        else
        {
          return 0;
        }
    }
    private static final double multiplier = 0.7; // The function is scaled to (multiplier * 100)% of its maximum of 1.
}