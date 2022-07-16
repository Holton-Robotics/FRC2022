// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Intake;
import frc.robot.subsystems.IndexerDrive;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.IntakeSniodSub;

public class StopMotors extends CommandBase {

  private Intake m_intake;
  private IndexerDrive m_index;
  private Flywheel m_flywheel; 
  private IntakeSniodSub m_intakeSnoid;
  /** Creates a new StopMotors. */
  public StopMotors(Intake intake, IndexerDrive index, Flywheel flywheel, IntakeSniodSub IntakeSnoid)
  {
  m_intake = intake;
  m_index = index;
  m_flywheel = flywheel;
  m_intakeSnoid = IntakeSnoid;
  addRequirements(intake, index, flywheel, IntakeSnoid);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_intake.stopMotors();
    m_index.stopMotors();
    m_flywheel.stopMotors();
    m_intakeSnoid.parkIntake();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
