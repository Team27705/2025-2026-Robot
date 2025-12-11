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
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Outtake;


@TeleOp(name = "test", group = "teleops")
public class TestDriveTrain extends LinearOpMode {

    private RobotHardware robot;

    private Outtake outtake;

    private Intake intake;




    @Override
    public void runOpMode() throws InterruptedException {

        //*
        // Always setup robot before turning on
        // *//
        robot = new RobotHardware(this);

        //
        outtake = robot.getOuttake();
        intake = robot.getIntake();
        robot.init();


        waitForStart();

        while (opModeIsActive()) {
            //outtakeControl();
            controllerBehaviorA();

        }
    }

    public void handleControls() {

    }


    //let A be driver
    public void controllerBehaviorA () {
        double leftX = gamepad1.left_stick_x;
        double leftY = gamepad1.left_stick_y;

        double rightX = gamepad1.right_stick_x;
        double rightY = gamepad1.right_stick_y;

        boolean leftbumper = gamepad1.left_bumper;
        boolean rightbumper = gamepad1.right_bumper;

        /*
        *Mecanum contorl
        * DPAD change
        * Default mode is B up is max(.8-9) normal is (.45-5) min is (.3.25)
        * */
        if (gamepad1.dpadDownWasPressed()) {

        }
        if (gamepad1.) {

        }



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
        double x = gamepad1.left_stick_x;
        double y = gamepad1.left_stick_y;

    }


    public void outtakeControl () {
        outtake.testRunMotorForward();
    }

}
