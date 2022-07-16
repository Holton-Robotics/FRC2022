// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;

import com.kauailabs.navx.frc.AHRS;

public class DriveSubsystem extends SubsystemBase {
  
  private static final double kCountsPerRevolution = 4096;
  private static final double kWheelDiameterInch = 6; // 70 mm
  private static final double kGearRatio = 10.75;
  private static final double kCircumference = Math.PI * kWheelDiameterInch;
  private static final double kConversionFactor = kGearRatio/kCircumference;
  private static final double kDistance = (kConversionFactor * kCircumference) / kCountsPerRevolution;

  private final CANSparkMax m_leftMotor1 = new CANSparkMax(Constants.lF_ID, MotorType.kBrushless);
  private final CANSparkMax m_leftMotor2 = new CANSparkMax(Constants.lR_ID, MotorType.kBrushless);
  private final CANSparkMax m_rightMotor1 = new CANSparkMax(Constants.rF_ID, MotorType.kBrushless);
  private final CANSparkMax m_rightMotor2 = new CANSparkMax(Constants.rR_ID, MotorType.kBrushless);


  private final RelativeEncoder m_leftEncoder = m_leftMotor1.getEncoder();
  private final RelativeEncoder m_rightEncoder = m_rightMotor1.getEncoder();

  // Set up the differential drive controller
  private final DifferentialDrive m_diffDrive = new DifferentialDrive(m_leftMotor1, m_rightMotor1);

  // Set up the Gyro
  private final AHRS m_gyro = new AHRS(SPI.Port.kMXP);

  // Set up the BuiltInAccelerometer
  private final BuiltInAccelerometer m_accelerometer = new BuiltInAccelerometer();

  /** Creates a new Drivetrain. */
  public DriveSubsystem() {
    // Use inches as unit for encoder distances
    m_leftEncoder.setPositionConversionFactor(kDistance);
    m_rightEncoder.setPositionConversionFactor(kDistance);
    resetEncoders();

    m_leftMotor1.restoreFactoryDefaults();
    m_leftMotor2.restoreFactoryDefaults();
    m_rightMotor1.restoreFactoryDefaults();
    m_rightMotor2.restoreFactoryDefaults();

    
    m_leftMotor2.follow(m_leftMotor1);
    m_rightMotor2.follow(m_rightMotor1);


    m_leftMotor1.setInverted(true);
    m_leftMotor2.setInverted(true);
    //m_rightMotor1.setInverted(true);
    //m_rightMotor2.setInverted(true);

    m_leftMotor1.setIdleMode(IdleMode.kBrake);
    m_leftMotor2.setIdleMode(IdleMode.kBrake);
    m_rightMotor1.setIdleMode(IdleMode.kBrake);
    m_rightMotor2.setIdleMode(IdleMode.kBrake);
  }

  public void arcadeDrive(double xaxisSpeed, double zaxisRotate) {
    m_diffDrive.arcadeDrive(xaxisSpeed, zaxisRotate);
  }

  public void resetEncoders() {
    m_leftEncoder.setPosition(0);
    m_rightEncoder.setPosition(0);
  }

  public int getLeftEncoderCount() {
    return m_leftEncoder.getCountsPerRevolution();
  }

  public int getRightEncoderCount() {
    return m_rightEncoder.getCountsPerRevolution();
  }

  public double getLeftDistanceInch() {
    return m_leftEncoder.getPosition();
  }

  public double getRightDistanceInch() {
    return m_rightEncoder.getPosition();
  }

  public double getAverageDistanceInch() {
    return (getLeftDistanceInch() + getRightDistanceInch()) / 2.0;
  }

  /**
   * The acceleration in the X-axis.
   *
   * @return The acceleration of the Robot along the X-axis in Gs
   */
  public double getAccelX() {
    return m_accelerometer.getX();
  }

  /**
   * The acceleration in the Y-axis.
   *
   * @return The acceleration of the Robot along the Y-axis in Gs
   */
  public double getAccelY() {
    return m_accelerometer.getY();
  }

  /**
   * The acceleration in the Z-axis.
   *
   * @return The acceleration of the Robot along the Z-axis in Gs
   */
  public double getAccelZ() {
    return m_accelerometer.getZ();
  }

  /**
   * Current angle of the Robot around the X-axis.
   *
   * @return The current angle of theRobot in degrees
   */
  public double getGyroAngleX() {
    return m_gyro.getPitch();
  }

  /**
   * Current angle of the Robot around the Y-axis.
   *
   * @return The current angle of the Robot in degrees
   */
  public double getGyroAngleY() {
    return m_gyro.getRoll();
  }

  /**
   * Current angle of the Robot around the Z-axis.
   *
   * @return The current angle of the Robot in degrees
   */
  public double getGyroAngleZ() {
    return m_gyro.getYaw();
  }

  /** Reset the gyro. */
  public void resetGyro() {
    m_gyro.reset();
  }

  public void set(double vbus) {
    m_leftMotor1.set(vbus);
    m_rightMotor1.set(vbus);
  }
/**
   * Sets the max output of the drive. Useful for scaling the drive to drive more slowly.
   *
   * @param maxOutput the maximum output to which the drive will be constrained
   */
  public void setMaxOutput(double maxOutput) {
    m_diffDrive.setMaxOutput(maxOutput);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


}
