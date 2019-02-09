/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.DriveTrain;
import jdk.vm.ci.hotspot.HotSpotReferenceMap;
import frc.robot.RobotMap;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static ExampleSubsystem m_subsystem = new ExampleSubsystem();
  public static OI m_oi;
  public static DriveTrain driveTrain = new DriveTrain();
  Command m_autonomousCommand;

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    m_oi = new OI();
    CameraServer.getInstance().startAutomaticCapture();
    DriveTrain.m_robotDrive.setDeadband(0.2);
  }

  /**
   * This function is called every robot packet,
   *  no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode. You
   * can use it to reset any subsystem information you want to clear when the
   * robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable chooser
   * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
   * remove all of the chooser code and uncomment the getString code to get the
   * auto name from the text box below the Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons to
   * the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
  
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() 
  {
    Scheduler.getInstance().run();
    getAndSendDriverInputToDrive();
  }
  
  private void getAndSendDriverInputToDrive()
  {
    
    double horizontalSpeed = OI.joystick.getX(Hand.kRight);
    double verticalSpeed = -OI.joystick.getY(Hand.kLeft); //A negative sign is applied to make pressing up (on the joystick) correspond  with values 0 to 1 (not 0 to -1 originally)
                                                          //This mapping allows for pressing up to move the drive train forward instead of backwards.
    DriveTrain.ManualDrive(horizontalSpeed, verticalSpeed);//The orientation of the x and y axis are switched from the way 
                                                                            // the driver sees them vs. how driveCartesian defines them in its arguments                                                     
  }
  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() 
  {
      // double first = OI.joystick.getY(Hand.kRight);
      // printStringAndDouble("ySpeed: ", first);
      // double second = OI.joystick.getX(Hand.kRight);
      // printStringAndDouble("xSpeed:", second);
      // double third = OI.joystick.getX(Hand.kRight);
      // printStringAndDouble("rotatiion", third);
  }
  // private void printStringAndDouble(String message, double x)
  // {
  //   System.out.println(message + " " + x);
  // }
}
