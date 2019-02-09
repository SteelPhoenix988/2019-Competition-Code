package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;
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
      // Set the default command for a subsystem here.
      // setDefaultCommand(new MySpecialCommand());
      robotDrive.driveCartesian(horizontalSpeed, verticalSpeed, rotationSpeed);
      
    }

    @Override
    protected void initDefaultCommand() 
    {

    }




























}