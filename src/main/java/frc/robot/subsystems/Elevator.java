package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.TeleopDriveCommand;
import edu.wpi.first.wpilibj.PWMVictorSPX;





public class Elevator extends Subsystem {
    public final PWMVictorSPX Elevator = new PWMVictorSPX(RobotMap.elevatorMotorPort);
    

    

    public void MoveElevator(double Motion){
        double absMotion = Math.abs(Motion);
        
        
        if (absMotion < .1){
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