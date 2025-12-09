package org.firstinspires.ftc.teamcode.TeleOp;

import com.arcrobotics.ftclib.controller.PIDFController;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.PIDCoefficients;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.arcrobotics.ftclib.*;


@TeleOp(name = "test", group = "teleops")
public class TestDriveTrain extends LinearOpMode {
    private final DcMotorEx frontLeftMotor;
    private final DcMotorEx frontRightMotor;
    private final DcMotorEx backLeftMotor;
    private final DcMotorEx backRightMotor;



    private final DcMotorEx flywheelMotor;

    private PIDCoefficients flywheelCoeffs = new PIDCoefficients();
//    private PIDFController flywheelPIDController = new PIDFController(flywheelCoeffs);

    public TestDriveTrain () {

        /*
        * Set up the drive train motors
        * */
        frontLeftMotor = hardwareMap.get(DcMotorEx.class, "Front Left Motor");
        frontRightMotor = hardwareMap.get(DcMotorEx.class, "Front Right Motor");
        backLeftMotor = hardwareMap.get(DcMotorEx.class, "Back Left Motor");
        backRightMotor = hardwareMap.get(DcMotorEx.class, "Back Right Motor");

        /*
        *
        * */
        flywheelMotor = hardwareMap.get(DcMotorEx.class, "");

    }

    @Override
    public void runOpMode() throws InterruptedException {
        while (opModeIsActive()) {
            flywheelMotor.setPower(1.0);
        }
    }

    public void handleControls() {
        double x = gamepad1.left_stick_x;
        double y = gamepad1.left_stick_y;
    }

}
