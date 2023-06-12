package frc.robot.subsystems;

import java.io.File;
import edu.wpi.first.wpilibj.Filesystem;
import swervelib.parser.SwerveParser;
import swervelib.SwerveDrive;

public class Drivetrain {
    File swerveJsonDirectory = new File(Filesystem.getDeployDirectory(),"swerve");
    SwerveDrive swerveDrive  = new SwerveParser(swerveJsonDirectory).createSwerveDrive();
    
}
