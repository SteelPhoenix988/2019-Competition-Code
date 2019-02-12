package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;
import frc.robot.commands.TeleopDriveCommand;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;





public class DriveTrain extends Subsystem 
{
    private final VictorSP frontLeft = new VictorSP(RobotMap.mecanumMotorFLPort);
    private final VictorSP rearLeft = new VictorSP(RobotMap.mecanumMotorRLPort);
    private final VictorSP frontRight = new VictorSP(RobotMap.mecanumMotorFRPort);
    private final VictorSP rearRight = new VictorSP(RobotMap.mecanumMotorRRPort);

    public final MecanumDrive robotDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);

    public DriveTrain()
    {
      robotDrive.setDeadband(0.145);
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
    // setDefaultCommand(new MySpecialCommand());
    @Override
    protected void initDefaultCommand() 
    {
        setDefaultCommand(new TeleopDriveCommand());
    }




























}