package frc.robot.lib;

import edu.wpi.first.math.geometry.Rotation2d;

public interface PIDMotor extends Motor {
    void setMotorPosition(double reference);

    void setMotorVelocity(double reference);

    double getPosition();

    double getPositionAbsolute();

    double getVelocity();

    void setEncoderPosition(double reference);
}