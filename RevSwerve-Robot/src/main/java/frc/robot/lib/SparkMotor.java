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

public class SparkMotor implements PIDMotor {

    private final SparkMax mMotor;
    private final SparkClosedLoopController mMotorClosed;
    private final RelativeEncoder mMotorREncoder;
    private final AbsoluteEncoder mMotorAEncoder;

    public SparkMotor(int id) {
        this.mMotor = new SparkMax(id, MotorType.kBrushless);
        this.mMotorClosed = this.mMotor.getClosedLoopController();
        this.mMotorREncoder = this.mMotor.getEncoder();
        this.mMotorAEncoder = this.mMotor.getAbsoluteEncoder();
    }

    @Override
    public void setMotorPosition(double reference) {
        this.mMotorClosed.setReference(reference, ControlType.kPosition);

    }

    @Override
    public void setMotorVelocity(double reference) {
        this.mMotorClosed.setReference(reference, ControlType.kVelocity);
    }

    @Override
    public double getPosition() {
        return this.mMotorREncoder.getPosition();
    }

    @Override
    public double getPositionAbsolute() {
        return this.mMotorAEncoder.getPosition();
    }

    @Override
    public double getVelocity() {
        return this.mMotorREncoder.getVelocity();
    }

    @Override
    public void setEncoderPosition(double reference) {
        
    }

    @Override
    public double getSpeed() {
        return this.mMotor.get();
    }


    @Override
    public void setSpeed(double reference) {
        this.mMotor.set(reference);
    }

}
