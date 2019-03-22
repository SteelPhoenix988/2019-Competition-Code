//Contains the methods for moving the elevator which is called in elevatorCommand
//The most important and only real method is Moveelevator
//It will move with the input given as motion I'm currently using our Joystick's Y Axis for movement
//It includes an oldschool dead band and B brake system
//This could be applied to any one motor device
//-Alex
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ArmMovement;
import edu.wpi.first.wpilibj.PWMVictorSPX;


public class Arm extends Subsystem {
    public final PWMVictorSPX arm = new PWMVictorSPX(RobotMap.armMotorPort);
   
    public void moveArm(double motion)
    {
        arm.set(motion);
    }

    @Override
    protected void initDefaultCommand() 
    {
        setDefaultCommand(new ArmMovement());
    }
}