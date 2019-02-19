package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.commands.drive.TeleopDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;

public class DriveTrain extends Subsystem 
{
    private int mecanumMotorFLPort;
    private int mecanumMotorFRPort;
    private int mecanumMotorRLPort;
    private int mecanumMotorRRPort;

    private VictorSP frontLeft;
    private VictorSP rearLeft;
    private VictorSP frontRight;
    private VictorSP rearRight;

    public final MecanumDrive robotDrive;

    public DriveTrain()
    {
      initalizeAllMotorControllers();
      robotDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);

      robotDrive.setDeadband(0.05);
    }
    private void initalizeAllMotorControllers()
    {
      setTheFrontDrivingSideWithTheBattery(false);
      frontLeft = new VictorSP(mecanumMotorFLPort);
      rearLeft = new VictorSP(mecanumMotorRLPort);
      frontRight = new VictorSP(mecanumMotorFRPort);
      rearRight = new VictorSP(mecanumMotorRRPort);
    }
    private void setTheFrontDrivingSideWithTheBattery(boolean flag)
    {
      if(flag)
      {
        mecanumMotorFLPort = 3;
        mecanumMotorFRPort = 2;
        mecanumMotorRLPort = 1;
        mecanumMotorRRPort = 0;
      }
      else
      {
        mecanumMotorFLPort = 0;
        mecanumMotorFRPort = 1;
        mecanumMotorRLPort = 2;
        mecanumMotorRRPort = 3;
      }
    }


    public void manualDrive(double horizontalSpeed, double verticalSpeed, double rotationSpeed) 
    {
      robotDrive.driveCartesian(horizontalSpeed, verticalSpeed, rotationSpeed);
    }
    
    //Lol be careful when using this. The 0 power doesn't break it as the motors will just let the axle spin
    //Don't get rekt
    public void timedDrive(int Direction, double seconds, double power){

      if (Direction == 1){
        robotDrive.driveCartesian(0, power, 0);
        Timer.delay(seconds);
        robotDrive.driveCartesian(0, 0, 0);
       //This will damage the gearbox, but...
       //robotDrive.driveCartesian(0, -1, 0);
       //Timer.delay(1);
       //robotDrive.driveCartesian(0, 0, 0);
      }
    }
    
    // Set the default command for a subsystem here.
    // Without initDefaultCommand, the Scheduler in Robot.java will not be able to process inputs properly.
    @Override
    protected void initDefaultCommand() 
    {
        setDefaultCommand(new TeleopDrive());
    }
}