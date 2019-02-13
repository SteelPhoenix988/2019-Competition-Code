package frc.robot;

public class Utility
{
    public static double applySinTransformation(double initial){

        if (initial != 0)
        {
        double sign = Math.abs(initial)/initial;
        double transformation = Math.sin((initial-.5)*Math.PI);
        transformation = ((transformation + 1)/2)*sign;
        return transformation;
        }
        else
        {
          return 0;
        }
      }
}