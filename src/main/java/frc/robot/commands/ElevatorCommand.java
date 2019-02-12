//Uses the method(s?) from Elevator.java to operate the elevator
//Not sure how to schedule to run, but will function properly once it is scheduled
//Currently using the Joystick's X axis to give motion and thereby move the Elevator
//-Alex
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
  private boolean Stop;
  
  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() 
  {
    Stop = (Robot.OI.ElevatorStick.getBButton());
    Motion = (Robot.OI.ElevatorStick.getX(Hand.kLeft));
    Robot.elevator.MoveElevator(Motion, Stop);
   
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
