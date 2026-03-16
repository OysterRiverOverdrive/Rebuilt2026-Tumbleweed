// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.DriveConstants.*;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CANDriveSubsystem extends SubsystemBase {
  private final PWMSparkMax leftLeader;
  private final PWMSparkMax leftFollower;
  private final PWMSparkMax rightLeader;
  private final PWMSparkMax rightFollower;

  private final DifferentialDrive drive;

  public CANDriveSubsystem() {
    // create brushed motors for drive
    leftLeader = new PWMSparkMax(LEFT_LEADER_ID);
    leftFollower = new PWMSparkMax(LEFT_FOLLOWER_ID);
    rightLeader = new PWMSparkMax(RIGHT_LEADER_ID);
    rightFollower = new PWMSparkMax(RIGHT_FOLLOWER_ID);

    // set up differential drive class
    drive = new DifferentialDrive(leftLeader, rightLeader);

    leftLeader.setInverted(false);
    rightLeader.setInverted(true);
    leftFollower.setInverted(false);
    rightFollower.setInverted(false);

    leftLeader.addFollower(leftFollower);
    rightLeader.addFollower(rightFollower);
  }

  @Override
  public void periodic() {}

  public void driveArcade(double xSpeed, double zRotation) {
    drive.arcadeDrive(xSpeed, zRotation);
  }
}
