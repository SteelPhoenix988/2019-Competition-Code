/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;




/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;
  
  
  
  /*
  With the following configuration of port numbers,
  the FRONT will be 
  THE SIDE OPPOSITE TO THE BATTERY

  public static final int mecanumMotorFLPort = 0;
  public static final int mecanumMotorFRPort = 1;
  public static final int mecanumMotorRLPort = 2;
  public static final int mecanumMotorRRPort = 3;
  */

  /*  
  With the following configuration of port numbers,
  the FRONT will be
  THE SIDE WITH THE BATTERY
   */
  public static final int mecanumMotorFLPort = 3;
  public static final int mecanumMotorFRPort = 2;
  public static final int mecanumMotorRLPort = 1;
  public static final int mecanumMotorRRPort = 0;

 
  public static final int elevatorMotorPort = 4;



  public static final int driveControllerPort = 0;
  public static final int elevatorControllerPort = 1;
}
