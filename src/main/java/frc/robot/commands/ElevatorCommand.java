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
  //private boolean IntakeStart;
  //private boolean IntakeStop;
  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Stop = (Robot.OI.ElevatorStick.getBButton());
    Motion = applySin(Robot.OI.ElevatorStick.getX(Hand.kLeft));
    //IntakeStart = Robot.OI.ElevatorStick.getAButton();
    //IntakeStop = Robot.OI.ElevatorStick.getxButton();
    
    
    
    Robot.elevator.MoveElevator(Motion, Stop);
    
    
    
    //Robot.elevator.IntakeIn(IntakeStart);
    //Robot.elevator.IntakeStop(IntakeStop);

  }
  
  
  //Might be a little messy- Tried importing it from Teleop, but it spit back a weird error about applySin requiring a boolean
  //Bug with the method?
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
