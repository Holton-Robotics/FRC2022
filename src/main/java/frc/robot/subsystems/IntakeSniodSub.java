// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

//import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kForward;
//import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kReverse;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
//import edu.wpi.first.wpilibj.Solenoid;
//import frc.robot.Constants.HatchConstants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/** A intake liftinh mechanism actuated by a single {@link DoubleSolenoid}. */
public class IntakeSniodSub extends SubsystemBase {
  private final DoubleSolenoid m_intakeSolenoid =
      new DoubleSolenoid(20, PneumaticsModuleType.REVPH, 1, 2);
          

  /** parks the intake. */
  public void parkIntake() {
    m_intakeSolenoid.set(Value.kForward);
  }

  /** kills the intake lifting system */
  public void stopIntakeSnoid()  {
    m_intakeSolenoid.set(Value.kOff);
  }

  /** drops the intake. */
  public void runIntake() {
    m_intakeSolenoid.set(Value.kReverse);
  }
}
