/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Flywheel;
//import frc.robot.subsystems.Shooter.ShotDistance;
import frc.robot.subsystems.IndexerDrive;
//import frc.robot.subsystems.LauncherLockSub;
//import static frc.robot.Constants.*;
//import edu.wpi.first.wpilibj.Timer;


public class Shoot extends CommandBase {
  /**
   * Creates a new ShooterCommand.
   */
    private Flywheel m_flywheel;
    private IndexerDrive m_index;
   // private LauncherLockSub m_lock;
       
  public Shoot(Flywheel shooter, IndexerDrive index) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_flywheel = shooter;
    m_index = index;
   // m_lock = lock;
 //
    addRequirements(m_flywheel, m_index);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
         
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Start the shooter 
    m_flywheel.shootBalls();
        // Turn on the intake motors after the delay has been met.
      m_index.shootBalls();
     //m_lock.openLaunch();
    }
    

  

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_index.stopMotors();
    m_flywheel.stopMotors();
   }

  // Command will run until the button is released, or autonomous timer hits
  @Override
  public boolean isFinished() {
    return false;
  }
}
