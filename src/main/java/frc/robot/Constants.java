// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
   public static final class HatchConstants {
    //public static final int kHatchSolenoidModule = 0;
   //public static final int[] kHatchSolenoidPorts = new int[] {0, 1};
  }

  public static final class AutoConstants {
    public static final double kAutoDriveDistanceInches = 60;
    public static final double kAutoBackupDistanceInches = 20;
    public static final double kAutoDriveSpeed = 0.5;
  }

  public static final class ControllerConstants {
    public static final int kDriverControllerPort = 0;
    public static final int kOperatorsControllerPort = 1;
  }
       // List of CAN IDs
  
  // drive motors

	public final static int lF_ID = 1; 
  public final static int lR_ID = 2;
  public final static int rF_ID = 3; 
  public final static int rR_ID = 4; 
  
  // intake

  public final static int iT_id1 = 10;
 
  // indexer

  public final static int iD_id1 = 11;
  public final static int iD_id2 = 12;

  // flywheel

  public final static int fM_id = 13;

  //lift 

  public final static int iL_id1 = 15;

  // flywheel constants
  public static final class m_flyWheel{
    public final static double fWkP = 6e-5; 
    public final static int fWkI = 0;
    public final static int fWkD = 0; 
    public final static int fWkIz = 0; 
    public final static double fWkFF = 0.000015; 
    public final static int fWkMaxOutput = 1; 
    public final static int fWkMinOutput = -1;
    public final static int fWmaxRPM = 10000;
    public static void loadBalls() {
    }

  }
  //indexer constants\
  public static final class m_Index{
    // indexer 1
    public final static double i1kP = 6e-5; 
    public final static int i1kI = 0;
    public final static int i1kD = 0; 
    public final static int i1kIz = 0; 
    public final static double i1kFF = 0.000015; 
    public final static int i1kMaxOutput = 1; 
    public final static int i1kMinOutput = -1;
    public final static int i1maxRPM = 5500;

    // indexer 2
    public final static double i2kP = 6e-5; 
    public final static int i2I = 0;
    public final static int i2D = 0; 
    public final static int i2Iz = 0; 
    public final static double i2FF = 0.000015; 
    public final static int i2MaxOutput = 1; 
    public final static int i2MinOutput = -1;
    public final static int i2maxRPM = 11000;
  }
  //color sensor
  public final static class s_colorSensor{
  
  }


}
