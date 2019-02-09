package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.VictorSP;





public class DriveTrain {

    public static final int mFL = 0;
    public static final int mFR = 1;
    public static final int mRL = 2;
    public static final int mRR = 3;

    public static VictorSP frontLeft = new VictorSP(mFL);
    public static VictorSP rearLeft = new VictorSP(mRL);
    public static VictorSP frontRight = new VictorSP(mFR);
    public static VictorSP rearRight = new VictorSP(mRR);



    public static final MecanumDrive m_robotDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);



   
    public void drive() {
      // Set the default command for a subsystem here.
      // setDefaultCommand(new MySpecialCommand());
        




    }




























}