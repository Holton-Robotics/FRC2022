// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.Set;

//import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.counter.UpDownCounter;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BallDetect extends SubsystemBase{

  public static final DigitalInput intakeBallDetect = new DigitalInput(0);
  public static final DigitalInput intakeBallExit = new DigitalInput(1);
  


   
  
 // public static boolean intakeBallDetectPresent() {
  //  return intakeBallDetect.get();
 // }

 // public static boolean intakeBallExitPresent() {
 //   return intakeBallExit.get();
 // }
  public BallDetect() {



  }

  public static boolean intakeBallDetectPresent() {
    return intakeBallDetect.get();
  }

  public static boolean intakeBallExitPresent() {
    return intakeBallExit.get();
  }

@Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
