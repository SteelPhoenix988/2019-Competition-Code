
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
//import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.Utility;
/**
 * An example command.  You can replace me with your own command.
 */
public class ArmMovement extends Command {
 
  public ArmMovement()
  {
    requires(Robot.arm);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  
  }

  private double powerMultiplier = 0.6;
  private double motion;
  
  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  
    motion = powerMultiplier*Utility.applySinTransformation(Robot.OI.armStick.getY(Hand.kLeft));
    
    Robot.arm.moveArm(motion);
  }
 
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished()
  {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end()
  {

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted()
  {

  }
}
