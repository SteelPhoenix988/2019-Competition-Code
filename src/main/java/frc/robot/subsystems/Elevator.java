//Contains the methods for moving the Elevator which is called in ElevatorCommand
//The most important and only real method is MoveElevator
//It will move with the input given as Motion I'm currently using our Joystick's Y Axis for movement
//It includes an oldschool dead band and B brake system
//This could be applied to any one motor device
//-Alex
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.TeleopDriveCommand;
import edu.wpi.first.wpilibj.PWMVictorSPX;




public class Elevator extends Subsystem {
    public final PWMVictorSPX Elevator = new PWMVictorSPX(RobotMap.elevatorMotorPort);
    

    

    public void MoveElevator(double Motion, boolean stop){
        double absMotion = Math.abs(Motion);
        
        
        if (absMotion < .1){
            Motion = 0;
        }
        //This is just a brake function until it is tested. Works like the B Brake at Cimarron

        if (stop = true){
            Motion = 0;
        }
        
        Elevator.set(Motion);
    }

    
      


    
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    @Override
    protected void initDefaultCommand() 
    {
        setDefaultCommand(new TeleopDriveCommand());
    }
}