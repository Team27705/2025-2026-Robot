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
import org.firstinspires.ftc.teamcode.subsystems.Outtake;


@TeleOp(name = "test", group = "teleops")
public class TestDriveTrain extends LinearOpMode {

    private RobotHardware robot;

    private Outtake outtake;


    @Override
    public void runOpMode() throws InterruptedException {

        //*
        // Always setup robot before turning on
        // *//
        robot = new RobotHardware(this);
        outtake = robot.getOuttake();

        robot.init();
        waitForStart();

        while (opModeIsActive()) {
            outtakeControl();
        }
    }

    public void handleControls() {
        double x = gamepad1.left_stick_x;
        double y = gamepad1.left_stick_y;
    }


    public void outtakeControl () {
        outtake.testRunMotorForward();
    }
}
