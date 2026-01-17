package frc.robot.lib;

import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.MotionMagicVelocityVoltage;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.configs.*;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;

public class TalonFXMotor implements PIDMotor {

    private final TalonFX TalonFX;

    private MotionMagicVoltage motionMagicPositionControl = new MotionMagicVoltage(0);
    private MotionMagicVelocityVoltage motionMagicVelocityControl = new MotionMagicVelocityVoltage(0);
    private StatusSignal<Angle> motorPosition;
    private StatusSignal<AngularVelocity> motorVelocity;

    public TalonFXMotor(int id) {
        this.TalonFX = new TalonFX(id, "rio");
        this.motorPosition = this.TalonFX.getPosition();
        this.motorVelocity = this.TalonFX.getVelocity();
    }

    public void applySlotConfigs(Slot0Configs config) {
        this.TalonFX.getConfigurator().apply(config);
    }

    public void applyConfigs(TalonFXConfiguration config) {
        this.TalonFX.getConfigurator().apply(config);
    }

    @Override
    public void setMotorPosition(double reference) {
        this.motionMagicPositionControl.Position = reference;
        this.TalonFX.setControl(this.motionMagicPositionControl);
    }

    @Override
    public void setMotorVelocity(double reference) {
        this.motionMagicVelocityControl.Velocity = reference;
        this.TalonFX.setControl(this.motionMagicVelocityControl);
    }

    @Override
    public double getPosition() {
        this.motorPosition.refresh();
        return new Rotation2d(this.motorPosition.getValueAsDouble()).getRotations();
    }

    @Override
    public double getPositionAbsolute() {
        return 0;
    }

    @Override
    public double getVelocity() {
        this.motorVelocity.refresh();
        return this.motorVelocity.getValueAsDouble();
    }

    @Override
    public void setEncoderPosition(double reference) {
        this.TalonFX.setPosition(reference);
    }

    @Override
    public void setSpeed(double speed) {
        this.TalonFX.set(speed);
    }

    @Override
    public double getSpeed() {
        return this.TalonFX.get();
    }
}