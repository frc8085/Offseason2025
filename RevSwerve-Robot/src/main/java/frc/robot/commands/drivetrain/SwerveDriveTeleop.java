package frc.robot.commands.drivetrain;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.OIConstants;
import frc.robot.io.Keymap.Controllers;
import frc.robot.subsystems.Drive.DriveConstants;
import frc.robot.subsystems.Drive.DriveSubsystem;

public class SwerveDriveTeleop extends Command {

    DriveSubsystem driveSubsystem;

    public SwerveDriveTeleop(DriveSubsystem driveSubsystem) {
        this.driveSubsystem = driveSubsystem;
        addRequirements(driveSubsystem);
    }

    @Override
    public void initialize() {
        System.out.println("Normal Drive Started");
    }

    @Override
    public void execute() {

        double invert = this.driveSubsystem.invertForAlliance();

        double leftX = MathUtil.applyDeadband(-Controllers.driverController.getLeftX() * invert,
                OIConstants.kDriveDeadband);
        double leftY = MathUtil.applyDeadband(-Controllers.driverController.getLeftY() * invert,
                OIConstants.kDriveDeadband);
        double rightX = MathUtil.applyDeadband(-Math.pow(Controllers.driverController.getRightX(), 3),
                OIConstants.kTurnDeadband);

        // uses distance formula (the Pythagorean theorem) to get the speed of the robot, this is done by getting the joysticks distance from the center.
        double speedVal = Math.sqrt(Math.pow(leftY, 2)+Math.pow(leftX, 2));
        //makes the speed exponential, this can probably be done better but IDK how.
        speedVal = Math.abs(Math.pow(speedVal, DriveConstants.kDriveStickExponentialRate));

        this.driveSubsystem.drive(
                speedVal,
                leftY, // forward-backward
                leftX, // left-right
                rightX, // rotation
                true);

    }

    @Override
    public boolean isFinished() {
        return false;
    }

}