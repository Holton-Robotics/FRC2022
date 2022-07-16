// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.IndexerDrive;
//import frc.robot.subsystems.BallStop;
//import static frc.robot.Constants.*;


public class ShooterTime extends CommandBase {
  private Flywheel m_flywheel;
  private IndexerDrive m_index;
  //private BallStop m_ballStop;
  private final double m_duration;
  private long m_startTime;



  /** Creates a new ShooterTime. */
  public ShooterTime(double time, Flywheel flywheel, IndexerDrive index) {
    m_flywheel = flywheel;
    m_index = index;
    //m_ballStop = stop;
    m_duration = time * 1000;
    addRequirements(m_flywheel, m_index);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_startTime = System.currentTimeMillis();
    m_index.stopMotors();
    m_flywheel.stopMotors();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_index.shootBalls();
    m_flywheel.shootBalls();
   }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  //  m_index.stopMotors();
  //  m_flywheel.stopMotors();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (System.currentTimeMillis() - m_startTime) >= m_duration;
    }
}
