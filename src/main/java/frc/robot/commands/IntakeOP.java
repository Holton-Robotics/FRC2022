// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
//import java.util.function.Supplier;
//import edu.wpi.first.wpilibj.Timer;

import frc.robot.subsystems.Intake;
import frc.robot.subsystems.IndexerDrive;
import frc.robot.subsystems.Flywheel;

public class IntakeOP extends CommandBase {

  private Intake m_intake;
  private IndexerDrive m_index;
  private Flywheel m_flywheel;
  //private Timer cmdTimer;
 
  

   /**
   * Creates a new Launcher. This command will drive your robot according to the speed supplier
   * lambdas. This command does not terminate.
   *
   * @param intake The drivetrain subsystem on which this command will run
   * @param intakeSpeed Lambda supplier of intake speed
   * 
   */
  /** Creates a new IntakeOP. */
  public IntakeOP(
    Intake  intake, IndexerDrive index, Flywheel flywheel)
    {
    m_intake = intake;
    m_index = index;
    m_flywheel = flywheel;
    addRequirements(intake);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_intake.loadBalls();
    m_index.loadBalls();
    m_flywheel.loadBalls();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_flywheel.stopMotors();
    m_intake.stopMotors();
    m_index.stopMotors();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
  
}
