// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

//import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
//import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
//import frc.robot.Constants.AutoConstants;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSniodSub;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.IndexerDrive;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.BallDetect;
//import frc.robot.subsystems.BallStop;

/** A complex auto command that drives forward, releases a hatch, and then drives backward. */
public class ComplexAuto extends SequentialCommandGroup {
  /**
   * Creates a new ComplexAuto.
   *
   * @param drive The drive subsystem this command will run on
   * @param snoid The hatch subsystem this command will run on
   */
  public ComplexAuto(DriveSubsystem drive, IntakeSniodSub snoid, Flywheel flywheel, IndexerDrive index, Intake intake, BallDetect ballcounter) {
    addCommands(
               // Drive forward the specified distance
        new DriveDistance(10, -.6, drive),
        // pause driving
        new DriveTime(0, .5, drive),
        // turn
        new TurnDegrees(-.4, 85, drive),
        // pause driving
        new DriveTime(0, .5, drive),
        // start the flywheel
        new ShooterTime(5, flywheel, index),
        // stop the shooting motors
        new StopMotors(intake, index, flywheel, snoid),
        // Drive backward the specified distance
        new DriveDistance(40, .35,  drive));
  }
}
