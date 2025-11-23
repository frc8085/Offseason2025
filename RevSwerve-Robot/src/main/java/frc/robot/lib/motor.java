package frc.robot.lib;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.units.measure.Velocity;

interface Motor {
    void setPosition(double reference);

    void setVelocity(double reference);

    double getPosition();

    double getPositionAbsolute();

    double getVelocity();
}

// class KrakenMotor implements Motor {

// public KrakenMotor() {

// }

// @Override
// public void setPosition(double reference) {

// }

// @Override
// public void setVelocity(double reference) {

// }
// @Override
// public double getPosition(){

// }
// @Override
// public double getVelocity(){

// }
// }

class SparkMotor implements Motor {

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
    public void setPosition(double reference) {
        this.mMotorClosed.setReference(reference, ControlType.kPosition);

    }

    @Override
    public void setVelocity(double reference) {
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

}

public class motor {
    Motor driveMotor;
    Motor armMotor;

    public motor() {
        this.driveMotor = new RevMotor();
    }

    public void setMovement() {
        this.driveMotor.setPosition(0);
    }
}
