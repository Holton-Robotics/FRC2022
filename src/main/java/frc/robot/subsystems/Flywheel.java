package frc.robot.subsystems;

import frc.robot.Constants;
//import frc.robot.Constants.m_flyWheel;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxPIDController;

public class Flywheel extends SubsystemBase{
    
  public static final CANSparkMax m_flyWheel = new CANSparkMax(Constants.fM_id, MotorType.kBrushless);
  public static final RelativeEncoder e_flyWheel = m_flyWheel.getEncoder();
  /**
     * In order to use PID functionality for a controller, a SparkMaxPIDController object
     * is constructed by calling the getPIDController() method on an existing
     * CANSparkMax object
     */
  public static final SparkMaxPIDController m_flyWheelController = m_flyWheel.getPIDController();

  public double fWkP, fWkI, fWkD, fWkIz, fWkFF, fWkMaxOutput, fWkMinOutput, fWmaxRPM;
 

     
    public Flywheel() {

    m_flyWheel.setInverted(true);
    
    m_flyWheel.restoreFactoryDefaults();
  
    m_flyWheel.setIdleMode(IdleMode.kCoast);

    // PID coefficients
    fWkP = Constants.m_flyWheel.fWkP;
    fWkI = Constants.m_flyWheel.fWkI;
    fWkD = Constants.m_flyWheel.fWkD; 
    fWkIz = Constants.m_flyWheel.fWkIz; 
    fWkFF = Constants.m_flyWheel.fWkFF; 
    fWkMaxOutput = Constants.m_flyWheel.fWkMaxOutput; 
    fWkMinOutput = Constants.m_flyWheel.fWkMinOutput;
    fWmaxRPM = Constants.m_flyWheel.fWmaxRPM;

    // set PID coefficients
    m_flyWheelController.setP(fWkP);
    m_flyWheelController.setI(fWkI);
    m_flyWheelController.setD(fWkD);
    m_flyWheelController.setIZone(fWkIz);
    m_flyWheelController.setFF(fWkFF);
    m_flyWheelController.setOutputRange(fWkMinOutput, fWkMaxOutput);

    // display PID coefficients on SmartDashboard
    SmartDashboard.putNumber("P Gain", fWkP);
    SmartDashboard.putNumber("I Gain", fWkI);
    SmartDashboard.putNumber("D Gain", fWkD);
    SmartDashboard.putNumber("I Zone", fWkIz);
    SmartDashboard.putNumber("Feed Forward", fWkFF);
    SmartDashboard.putNumber("Max Output", fWkMaxOutput);
    SmartDashboard.putNumber("Min Output", fWkMinOutput);

    SmartDashboard.getNumber("flywheel Speed", e_flyWheel.getVelocity());

    
  }
  
  public double getSpeed() {
    return e_flyWheel.getVelocity();
  }

  public void FlywheelDrive(double m_Fspeed) { 
  m_flyWheel.set(m_Fspeed);
  }
  
  //public void set(double rightTriggerAxis) {
  //}
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

public void stopMotors() {
  m_flyWheelController.setReference(0 * fWmaxRPM, CANSparkMax.ControlType.kVelocity);
}
public void shootBalls() {
  m_flyWheelController.setReference(1 * fWmaxRPM, CANSparkMax.ControlType.kVelocity);
}

public void loadBalls() {
  m_flyWheelController.setReference(-.2 * fWmaxRPM, CANSparkMax.ControlType.kVelocity);
}

public void unJam() {
  m_flyWheelController.setReference(-.5 * fWmaxRPM, CANSparkMax.ControlType.kVelocity);
}

public void lowerTarget() {
  m_flyWheelController.setReference(0.5 * fWmaxRPM, CANSparkMax.ControlType.kVelocity);
}
}
