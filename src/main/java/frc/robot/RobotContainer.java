// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.io.File;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.drivetrain.Drivetrain;
import frc.robot.subsystems.drivetrain.commands.TeleopDrive;

public class RobotContainer {

    private final Drivetrain m_drivetrain = new Drivetrain(new File(Filesystem.getDeployDirectory(), "swerve"));
    CommandXboxController driverXbox = new CommandXboxController(OperatorConstants.kDriverControllerPort);

	public RobotContainer() {

        TeleopDrive closedFieldRel = new TeleopDrive(
            m_drivetrain,
            () -> MathUtil.applyDeadband(driverXbox.getLeftY(), OperatorConstants.LEFT_Y_DEADBAND),
            () -> MathUtil.applyDeadband(driverXbox.getLeftX(), OperatorConstants.LEFT_X_DEADBAND),
            () -> -driverXbox.getRawAxis(3), () -> true, false, true);


        m_drivetrain.setDefaultCommand(closedFieldRel);

		// Configure the trigger bindings
		configureBindings();
	}

	private void configureBindings() {
        driverXbox.back().onTrue(new InstantCommand(() -> m_drivetrain.zeroGyro()));
	}

	public Command getAutonomousCommand() {
		return null;
	}
}
