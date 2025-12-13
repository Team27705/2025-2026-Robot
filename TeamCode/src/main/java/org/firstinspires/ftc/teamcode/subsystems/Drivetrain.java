package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drivetrain {

    private final DcMotor leftFront;
    private final DcMotor rightFront;
    private final DcMotor leftBack;
    private final DcMotor rightBack;

    private double speedMultipler;

    public Drivetrain (HardwareMap hardwareMap) {


        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");

        speedMultipler = 0.4;

        setAllDriveMotorBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }




    public void setDrivetrainPower (double y, double x, double rx) {


        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double lfV = ((y + x + rx) / denominator) * speedMultipler;
        double lbV = ((y - x + rx) / denominator) * speedMultipler;
        double rfV = ((y - x - rx) / denominator) * speedMultipler;
        double rbV = ((y + x - rx) / denominator)* speedMultipler;

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


