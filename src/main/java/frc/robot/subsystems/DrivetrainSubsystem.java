// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants.DriveTrainConstants;

public class DrivetrainSubsystem extends SubsystemBase {

  private final WPI_TalonSRX m_leftDrive = new WPI_TalonSRX(DriveTrainConstants.kLeftDriveID);
  private final WPI_TalonSRX m_rightDrive = new WPI_TalonSRX(DriveTrainConstants.kRightDriveID);

  private final DifferentialDrive m_DifferentialDrive = new DifferentialDrive(m_leftDrive::set, m_rightDrive::set);
  /** Creates a new ExampleSubsystem. */
  public DrivetrainSubsystem() {

    m_rightDrive.setInverted(true);
  }
  
  public void arcadeDrive(double drive, double rot) {
    m_DifferentialDrive.arcadeDrive(drive, rot, true);
  }
  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command meh() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
