/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class TeleopDriveCommand extends Command {
  public TeleopDriveCommand() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.driveTrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  private double horizontalSpeed;
  private double verticalSpeed;
  private double rotation;
  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() 
  {
    horizontalSpeed = applySin(Robot.OI.joystick.getX(Hand.kLeft));
    verticalSpeed = applySin(-Robot.OI.joystick.getY(Hand.kLeft));
    rotation = applySin(Robot.OI.joystick.getX(Hand.kRight));
    if (isUnderRotationThreshold(rotation)) 
    {
      rotation = 0;
    }
    
    
    //Brake Check acts as an emergency stop
    //Must stay before here
    brakeCheck();
    Robot.driveTrain.manualDrive(horizontalSpeed, verticalSpeed, rotation);
  }
  private boolean isUnderRotationThreshold(double rotation)
  {
    return Math.abs(rotation) < 0.1;
  }
  private double applySin(double initial){

    if (initial != 0){
    double sign = Math.abs(initial)/initial;
    double finish = Math.sin((initial-.5)*Math.PI);
    finish = ((finish + 1)/2)*sign;
    return finish;
    }
    else
    {
      return 0;
    }
  }
  public void brakeCheck (){
    if (Robot.OI.joystick.getBButton())
    {
     verticalSpeed = -verticalSpeed;
     horizontalSpeed = 0;
     //Possible rotation brake
   }
  }
  
  
  
  
  
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
