// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax.IdleMode;


//import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.NeutralMode;
//import com.ctre.phoenix.motorcontrol.can.VictorSPX;


public class Intake extends SubsystemBase {
 
    public final static CANSparkMax m_intake = new CANSparkMax(Constants.iT_id1, MotorType.kBrushless);
    //private final VictorSPX m_intake = new VictorSPX(Constants.iC_ID1);
       
    public Intake() {

      m_intake.setInverted(false);
    
      m_intake.restoreFactoryDefaults();
  
      m_intake.setIdleMode(IdleMode.kBrake);
    }
  
 /**
   * Sets the speed of the intake motor
   * 
   * @param intakeSpeed the intake speed
   */
  public void IntakeSpeed(double intakeSpeed) {
    m_intake.set(1);
  }

public void IntakeSpeed(Intake m_intakeSpeed) {
}

public void stopMotors() {
  m_intake.set(0);
}

public void shootBalls() {
  m_intake.set(1);
}

public void loadBalls() {
  m_intake.set(1);
}

public void unJam() {
  m_intake.set(-.5);
}

public void kickBalls() {
  m_intake.set(-1);
}

    }
   