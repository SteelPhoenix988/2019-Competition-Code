//Uses the method(s?) from Elevator.java to operate the elevator
//Not sure how to schedule to run, but will function properly once it is scheduled
//Currently using the Joystick's X axis to give motion and thereby move the Elevator
//-Alex
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
//import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.Utility;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.text.DecimalFormat;
/**
 * An example command.  You can replace me with your own command.
 */
public class ArmMovement extends Command {
 
  public ArmMovement()
  {
    requires(Robot.arm);
  }
s
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  
  }

  private double motion;
  private boolean stop;
  
  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    
    motion = Utility.applySinTransformation(Robot.OI.armStick.getY(Hand.kLeft));
    
    boolean stopped = (Robot.OI.armStick.getBButton());
    //This is no longer just a brake function
    //This will cause the arm to hold at a specific position
    if (stopped){
        motion = .05;
    }

    Robot.arm.moveArm(motion);
    // SmartDashboard.putString("Arm Motion", new DecimalFormat("#.##").format(motion));
    
    /* if (Track > 0 && AButton != true && XButton != true){
      Robot.arm.moveArm(-1, stop);
    }else if(Track == 0 && AButton != true && XButton != true){
      Robot.arm.moveArm(0, stop);
    }else if(Track < 1 && AButton != true && XButton != true){
      Robot.arm.moveArm(1, stop);
    }else if(AButton = true){
      do {
        Robot.arm.moveArm(1, stop);
        Track = Robot.armEncoder.getArmTrack();
      }while(Track<5);
    }else if(XButton = true){
      do {
        Robot.arm.moveArm(1, stop);
        Track = Robot.armEncoder.getArmTrack();
      }while(Track<7);
    }
    */
   // Robot.arm.moveArm(motion, stop);
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
