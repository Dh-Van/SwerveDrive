// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.util.Units;
import swervelib.math.Matter;

public final class Constants {
    
    public static final double ROBOT_MASS = (152.89) * 0.453592; // 152.89lbs * kg per pound
    public static final Matter CHASSIS = new Matter(new Translation3d(0, 0, Units.inchesToMeters(12)), ROBOT_MASS);
    public static final double LOOP_TIME  = 0.2; //s, 20ms
  
    public static class OperatorConstants {
        public static final int kDriverControllerPort = 0;
    }
}
