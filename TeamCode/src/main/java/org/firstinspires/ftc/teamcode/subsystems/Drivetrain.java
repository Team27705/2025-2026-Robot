package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class Drivetrain {

    private final DcMotor leftFront;
    private final DcMotor rightFront;
    private final DcMotor leftBack;
    private final DcMotor rightBack;

    private final GoBildaPinpointDriver odo;
    private double speedMultipler;

    private double xOffset = -194.6;
    private double yOffset = 2.8;

    public Drivetrain (HardwareMap hardwareMap) {

        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");

        odo = hardwareMap.get(GoBildaPinpointDriver.class, "odometry");

        speedMultipler = 0.4;

        setAllDriveMotorBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        setOdometry();


    }

    public void setOdometry () {
        odo.setOffsets(xOffset, yOffset, DistanceUnit.INCH);
        odo.setEncoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        odo.setEncoderDirections(GoBildaPinpointDriver.EncoderDirection.FORWARD,  GoBildaPinpointDriver.EncoderDirection.FORWARD);

        odo.resetPosAndIMU();

    }

//    public void setPosition (StartingPositions) {
//        if (StartingPositions.) {
//
//        }
//        odo.setPosition();
//    }

//    public void odometryTelem () {
//        TelemetryPacket telemetryPacket = new TelemetryPacket();
//    }

    public void setDrivetrainPower (double drive, double strafe, double turn) {


        double denominator = Math.max(Math.abs(drive) + Math.abs(strafe) + Math.abs(turn), 1);
        double lfV = ((drive + strafe + turn) / denominator);
        double lbV = ((drive - strafe + turn) / denominator);
        double rfV = ((drive - strafe - turn) / denominator);
        double rbV = ((drive + strafe - turn) / denominator);

//        if () {
//
//        }
//        if () {
//
//        }
//        if () {
//
//        }

        leftFront.setPower(lfV);
        rightFront.setPower(rfV);
        leftBack.setPower(lbV);
        rightBack.setPower(rbV);
    }

    public void setAllDriveMotorBehavior(DcMotor.ZeroPowerBehavior behavior) {
        leftFront.setZeroPowerBehavior(behavior);
        rightFront.setZeroPowerBehavior(behavior);
        leftBack.setZeroPowerBehavior(behavior);
        rightBack.setZeroPowerBehavior(behavior);
    }

    public void setSpeedMultiplier (boolean highSpeed) {
        if (highSpeed) {
            speedMultipler = 0.85;
        }
        else {
            speedMultipler = 0.4;
        }
    }

    public void setLeftFront () {

    }

}


