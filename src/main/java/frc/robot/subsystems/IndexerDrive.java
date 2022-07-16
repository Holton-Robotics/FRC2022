package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;


//import com.ctre.phoenix.motorcontrol.can.VictorSPX;
//import com.ctre.phoenix.motorcontrol.*;

public class IndexerDrive extends SubsystemBase{

    public final static CANSparkMax m_indexer1 = new CANSparkMax(Constants.iD_id1, MotorType.kBrushless);
    //public final static CANSparkMax m_indexer2 = new CANSparkMax(Constants.iD_id2, MotorType.kBrushless);

    private final RelativeEncoder e_indexerEncoder1 = m_indexer1.getEncoder();
    //private final RelativeEncoder e_indexerEncoder2 = m_indexer2.getEncoder();

    public static final SparkMaxPIDController  m_indexer1Controller = m_indexer1.getPIDController();
    //public static final SparkMaxPIDController m_indexer2Controller = m_indexer2.getPIDController();

    public double i1kP, i1kI, i1kD, i1kIz, i1kFF, i1kMaxOutput, i1kMinOutput, i1maxRPM;
    //public double i2kP, i2I, i2D, i2Iz, i2FF, i2MaxOutput, i2MinOutput, i2maxRPM;
 
    //private final VictorSPX m_indexer = new VictorSPX(Constants.iC_ID1);
       
    public IndexerDrive() {

      // index drive 1

        m_indexer1.setInverted(false);    
        m_indexer1.restoreFactoryDefaults();  
        m_indexer1.setIdleMode(IdleMode.kBrake);  

       // PID coefficients

        i1kP = Constants.m_Index.i1kP;
        i1kI = Constants.m_Index.i1kI;
        i1kD = Constants.m_Index.i1kD; 
        i1kIz = Constants.m_Index.i1kIz; 
        i1kFF = Constants.m_Index.i1kFF; 
        i1kMaxOutput = Constants.m_Index.i1kMaxOutput; 
        i1kMinOutput = Constants.m_Index.i1kMinOutput;
        i1maxRPM = Constants.m_Index.i1maxRPM;

       // set PID coefficients
        m_indexer1Controller.setP(i1kP);
        m_indexer1Controller.setI(i1kI);
        m_indexer1Controller.setD(i1kD);
        m_indexer1Controller.setIZone(i1kIz);
        m_indexer1Controller.setFF(i1kFF);
        m_indexer1Controller.setOutputRange(i1kMinOutput, i1kMaxOutput);

       // display PID coefficients on SmartDashboard
        SmartDashboard.putNumber("P Gain", i1kP);
        SmartDashboard.putNumber("I Gain", i1kI);
        SmartDashboard.putNumber("D Gain", i1kD);
        SmartDashboard.putNumber("I Zone", i1kIz);
        SmartDashboard.putNumber("Feed Forward", i1kFF);
        SmartDashboard.putNumber("Max Output", i1kMaxOutput);
        SmartDashboard.putNumber("Min Output", i1kMinOutput);

    

 /**    // index drive 2
        m_indexer2.setInverted(false);  
        m_indexer2.restoreFactoryDefaults();
        m_indexer2.setIdleMode(IdleMode.kBrake);

        // PID coefficients

        i2kP = Constants.m_Index.i2kP;
        i2I = Constants.m_Index.i2I;
        i2D = Constants.m_Index.i2D; 
        i2Iz = Constants.m_Index.i2Iz; 
        i2FF = Constants.m_Index.i2FF; 
        i2MaxOutput = Constants.m_Index.i2MaxOutput; 
        i2MinOutput = Constants.m_Index.i2MinOutput;
        i2maxRPM = Constants.m_Index.i2maxRPM;

       // set PID coefficients
        m_indexer1Controller.setP(i2kP);
        m_indexer1Controller.setI(i2I);
        m_indexer1Controller.setD(i2D);
        m_indexer1Controller.setIZone(i2Iz);
        m_indexer1Controller.setFF(i2FF);
        m_indexer1Controller.setOutputRange(i2MinOutput, i2MaxOutput);

       // display PID coefficients on SmartDashboard
        SmartDashboard.putNumber("P Gain", i2kP);
        SmartDashboard.putNumber("I Gain", i2I);
        SmartDashboard.putNumber("D Gain", i2D);
        SmartDashboard.putNumber("I Zone", i2Iz);
        SmartDashboard.putNumber("Feed Forward", i2FF);
        SmartDashboard.putNumber("Max Output", i2MaxOutput);
        SmartDashboard.putNumber("Min Output", i2MinOutput);
        */
  }
/**
   * Sets the speed of the front motor
   * 
   * @param indexSpeed the index speed
   */
  public void IndexSpeed(double indexSpeed) {
    m_indexer1Controller.setReference(1 * i1maxRPM, CANSparkMax.ControlType.kVelocity);
  //  m_indexer2Controller.setReference(1 * i2maxRPM, CANSparkMax.ControlType.kVelocity);
   // m_indexer2.set(1);
  }
public void loadBalls() {
  m_indexer1Controller.setReference(.75 * i1maxRPM, CANSparkMax.ControlType.kVelocity);
  //m_indexer2Controller.setReference(.75 * i2maxRPM, CANSparkMax.ControlType.kVelocity);
}

public void shootBalls() {
  m_indexer1Controller.setReference(1 * i1maxRPM, CANSparkMax.ControlType.kVelocity);
 // m_indexer2Controller.setReference(1 * i2maxRPM, CANSparkMax.ControlType.kVelocity);
 }

public void unJam() {
  m_indexer1Controller.setReference(-.4 * i1maxRPM, CANSparkMax.ControlType.kVelocity);
 // m_indexer2Controller.setReference(-.4 * i2maxRPM, CANSparkMax.ControlType.kVelocity);
 
}

public void lowerTarget() {
  m_indexer1Controller.setReference(.5 * i1maxRPM, CANSparkMax.ControlType.kVelocity);
 // m_indexer2Controller.setReference(.5 * i2maxRPM, CANSparkMax.ControlType.kVelocity);
}
public void stopMotors() {
  m_indexer1Controller.setReference(0 * i1maxRPM, CANSparkMax.ControlType.kVelocity);
 // m_indexer2Controller.setReference(0 * i2maxRPM, CANSparkMax.ControlType.kVelocity);
}

   
}
