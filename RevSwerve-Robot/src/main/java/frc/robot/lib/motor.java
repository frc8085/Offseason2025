package frc.robot.lib;

import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.MotionMagicVelocityVoltage;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;

import com.revrobotics.spark.SparkMax;

public interface Motor {
    void setSpeed(double speed);

    double getSpeed();
}


/*
 * class motor {
 * PIDMotor driveMotor;
 * PIDMotor armMotor;
 * Motor dumbMotor;
 * 
 * public motor() {
 * this.driveMotor = new KrakenMotor(0);
 * this.armMotor = new SparkMotor(0);
 * this.dumbMotor = new KrakenMotor(1);
 * }
 * 
 * public void setMovement() {
 * this.driveMotor.setMotorPosition(0);
 * }
 * }
 */
