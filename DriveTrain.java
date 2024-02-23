// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  //Motors
  private CANSparkMax left_back;
  private CANSparkMax left_front;
  private CANSparkMax right_front;
  private CANSparkMax right_back;
  private DifferentialDrive driver;
  
  /** Creates a driveTrain */
  public DriveTrain() {
    //Set motor to ID and type
    left_back = new CANSparkMax(1, MotorType.kBrushed);
    left_front = new CANSparkMax(2,MotorType.kBrushed);
    right_front = new CANSparkMax(3,MotorType.kBrushed);
    right_back = new CANSparkMax(4, MotorType.kBrushed);
    //Set right leader motor to inverted
    right_front.setInverted(true);
    //Have both sides back motors follow the front motors
    left_back.follow(left_front);
    right_back.follow(right_front);
    //DifferentialDrive Instantiation
    driver = new DifferentialDrive(left_front, right_front);
    driver.setSafetyEnabled(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void arcadeDrive(double speed, double rotation){
    driver.arcadeDrive(speed, rotation);
  }

  public void tankDrive(double left, double right){
    driver.tankDrive(left, right);
  }

  public void arcadeDrive(DoubleSupplier y1, DoubleSupplier rotation) {
    // if true run arcade drive
    driver.arcadeDrive(y1.getAsDouble(), rotation.getAsDouble());
  }
  public void tankDrive(DoubleSupplier y1, DoubleSupplier y2) {
    driver.tankDrive(y1.getAsDouble(), y2.getAsDouble());
  }

}
