// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.subsystems.DriveSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class DriveDistanceRed extends SequentialCommandGroup {
  /** Creates a new DriveDistanceRed. */
  public DriveDistanceRed(DriveSubsystem drive) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      // drive forward
      new DriveDistance(20, 1, drive),
      //pause
      new DriveTime(0, .5, drive),
      //turn
      new TurnDegrees(.5, 90, drive)
    );
  }
}
