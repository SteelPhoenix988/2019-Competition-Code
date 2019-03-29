/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.text.DecimalFormat;

import edu.wpi.first.wpilibj.GenericHID.Hand;
/**
 * Add your docs here.
 */
public class PowerMultiplier
{
    private static double min = 0.1;    
    private static double max = 0.9;
    private static double multiplier = max;


    public static void display()
    {
        handleUpdating();
        SmartDashboard.putString("Power Multiplier", new DecimalFormat("#.##").format(multiplier));
    }
    public static void handleUpdating()
    {
        decrementOrIncrementMutiplier();
    }
    public static void decrementOrIncrementMutiplier()
    {
        if(multiplier > min  && Robot.OI.joystick.getBumperPressed(Hand.kLeft))
        {
            multiplier -= 0.1;
        }
        if(multiplier < max && Robot.OI.joystick.getBumperPressed(Hand.kRight))
        {
            multiplier += 0.1;
        }
    }
    public static double getMultiplier()
    {
        return multiplier;
    }
}
