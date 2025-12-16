package org.firstinspires.ftc.teamcode.TeleOp;

import com.arcrobotics.ftclib.controller.PIDFController;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.PIDCoefficients;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.arcrobotics.ftclib.*;
import com.qualcomm.robotcore.robot.Robot;

import org.firstinspires.ftc.teamcode.RobotHardware;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Indexer;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Outtake;


@TeleOp(name = "test", group = "teleops")
public class TestDriveTrain extends LinearOpMode {

    private RobotHardware robot;

    private Drivetrain drivetrain;

    private Outtake outtake;

    private Intake intake;
    private Indexer indexer;

    public static enum StartingPosition {
        RedWallStart,
        BlueWallStart,
        Red,
        Blue
    }


    @Override
    public void runOpMode() throws InterruptedException {

        //*
        // Always setup robot before turning on
        // *//
        robot = new RobotHardware(this);

        //
        outtake = robot.getOuttake();
        intake = robot.getIntake();
        drivetrain = robot.getDrivetrain();
        indexer = robot.getIndexer();

        waitForStart();
        robot.init();
        indexer.servoTest();

        while (opModeIsActive()) {
            controllerBehaviorA();
            controllerBehaviorB();
            updateTelem();
        }


    }

    public void handleControls() {

    }


    //let A be driver
    public void controllerBehaviorA () {

        double leftX = gamepad1.left_stick_x * 1.1; //counter imperfect strafing, straffing
        double leftY = -gamepad1.left_stick_y; //forward and backward

        double rightX = gamepad1.right_stick_x * 1.1; //rotation
        double rightY = gamepad1.right_stick_y;

        boolean leftbumper = gamepad1.left_bumper;
        boolean rightbumper = gamepad1.right_bumper;



        /*
        *Mecanum control
        * DPAD change
        * Default mode is B up is max(.8-9) normal is (.45-5) min is (.3.25)
        * */
        if (gamepad1.dpadUpWasPressed()) {
            drivetrain.setSpeedMultiplier(true);
        }
        else if (gamepad1.dpadDownWasPressed()) {
            drivetrain.setSpeedMultiplier(false);
        }

        drivetrain.setDrivetrainPower(leftY, leftX, rightX);


        /*
        * set up deadzone of 0.1 for each controller
        * */
        if (leftX <= -0.1 && leftY >= 0.1) {
            leftY = 0;
            leftY = 0;
        }
        if (rightX <= -0.1 && rightY >= 0.1) {
            rightX = 0;
            rightY = 0;
        }
        /*
        / Driver controls intake w/ Left bumper and right bumper
         */
        if (leftbumper) {
            intake.spinIntake();
        }
        if (rightbumper) {
            intake.idleIntake();
        }


    }

    public void controllerBehaviorB () {

        /*
        * this part is for enabling the intake
        * let it spin at low while idling
        * then ramp up when "x" has been pressed
        * press x again to bring back to idle
        * */
        if (gamepad2.xWasPressed()) {
            outtake.runOuttake();

        }
        if (gamepad2.bWasPressed()) {
            outtake.idle();
        }

        if (gamepad2.yWasPressed()) {
            indexer.testMotor();
        }
        if (gamepad2.aWasPressed()) {
            indexer.kick();
        }

        if (gamepad2.dpadDownWasPressed()) {
            indexer.reset();
        }

        //shooting sequenence
    }

    public void updateTelem () {

        //colorsensor
        telemetry.addData("\n", intake.colorDetected());
        telemetry.update();
    }
}
