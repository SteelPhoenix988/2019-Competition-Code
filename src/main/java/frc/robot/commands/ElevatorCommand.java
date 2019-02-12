package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class ElevatorCommand extends Command {
  

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  private double Motion;
  
  
  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() 
  {
    
    Motion = (Robot.OI.ElevatorStick.getX(Hand.kLeft));
    Robot.elevator.MoveElevator(Motion);
   
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
