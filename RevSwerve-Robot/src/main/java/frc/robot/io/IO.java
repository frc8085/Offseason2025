package frc.robot.io;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.jni.WPIMathJNI;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.commands.drivetrain.*;

public class IO {

        public void init(RobotContainer robotContainer) {

                // Additional Buttons to allow for alternate button pushes
                // final Trigger altButtonDriver = Keymap.Layout.driverRightBumper;
                final Trigger scoreLeft = Keymap.Layout.operatorLeftBumper;
                final Trigger scoreRight = Keymap.Layout.operatorRightBumper;

                // Initialization
                final Trigger zeroHeadingButton = Keymap.Layout.driverStartButton;

                // final Trigger zeroElevator = operatorController.start();
                final Trigger zeroElevator = Keymap.Layout.operatorStartButton;
                final Trigger limelightTrigger1 = Keymap.Layout.driverXButton;
                final Trigger limelightTrigger2 = Keymap.Layout.driverBButton;

                // Driver operations
                final Trigger scoreCoral = Keymap.Layout.driverAButton;
                final Trigger pickupCoral = Keymap.Layout.operatorDownButton;
                final Trigger ejectAlgae = Keymap.Layout.driverYButton;
                final Trigger lockWheels = Keymap.Layout.driverBackButton;
                final Trigger shootAlgaeNetBlue = Keymap.Layout.driverLeftBumper;
                // final Trigger left = Keymap.Layout.driverDownButton;
                // final Trigger right = Keymap.Layout.driverUpButton;
                final Trigger gorobotrelative = Keymap.Controllers.driverController.leftStick();
                final Trigger raiseClimber = Keymap.Layout.driverRightButton;
                final Trigger lowerClimber = Keymap.Layout.driverLeftButton;

                // Operator Controls
                final Trigger intakeCoral = Keymap.Layout.operatorRightTriggerButton;
                final Trigger dumpCoral = Keymap.Layout.driverLeftTriggerButton;
                final Trigger altdumpCoral = Keymap.Layout.operatorLeftTriggerButton;
                final Trigger toggleClimber = Keymap.Layout.operatorBackButton;

                // Operator Set Position Controls
                // final Trigger algaeGround = Keymap.Layout.operatorDownButton;
                final Trigger algaeReef2 = Keymap.Layout.operatorRightButton;
                final Trigger coralHandOff = Keymap.Layout.operatorUpButton;
                // final Trigger coralEject = Keymap.Layout.operatorDownButton;
                // final Trigger algaeProcessor = Keymap.Layout.operatorLeftButton;
                final Trigger coralDropOff4 = Keymap.Layout.operatorYButton;
                final Trigger coralDropOff3 = Keymap.Layout.operatorXButton;
                final Trigger coralDropOff2 = Keymap.Layout.operatorBButton;
                final Trigger coralDropOff1 = Keymap.Layout.operatorAButton;
                final Trigger algaeReef3 = Keymap.Layout.operatorLeftButton;
                // final Trigger intakeHalf = Keymap.Layout.operatorLeftButton;

                // Set Left Joystick for manual elevator/pivot movement
                final Trigger raiseElevator = Keymap.Controllers.operatorController.axisLessThan(1, -0.25);
                final Trigger lowerElevator = Keymap.Controllers.operatorController.axisGreaterThan(1, 0.25);
                final Trigger pivotClockwise = Keymap.Controllers.operatorController.axisGreaterThan(4, 0.25);
                final Trigger pivotCounterClockwise = Keymap.Controllers.operatorController.axisLessThan(4, -0.25);

                // Initialization

                // Reset heading of robot for field relative drive
                zeroHeadingButton.onTrue(new InstantCommand(() -> robotContainer.drivetrain.zeroHeading(),
                                robotContainer.drivetrain));

                // // Limelight Buttons

                lockWheels.whileTrue(new RunCommand(robotContainer.drivetrain::lock, robotContainer.drivetrain));
        }
}