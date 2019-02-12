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

    //This is just for if we have a motor intake on the elevator

    
    //public final PWMVictorSPX LeftIntake = new PWMVictorSPX(RobotMap.evevatorIntakePortLeft);
    //public final PWMVictorSPX RightIntake = new PWMVictorSPX(RobotMap.evevatorIntakePortRight);




    
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
    /*
    //Look into the OI and call it as whileHeld
    public void IntakeIn(boolean StartIntake){
            if (StartIntake == true){
            LeftIntake.set(1);
            RightIntake.set(-1);
            }
        }
    public void IntakeStop(boolean StopIntake){
        if (StopIntake == true){
        LeftIntake.set(0);
        RightIntake.set(0);
        }
    }

    */
      


    
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    @Override
    protected void initDefaultCommand() 
    {
        setDefaultCommand(new TeleopDriveCommand());
    }
}