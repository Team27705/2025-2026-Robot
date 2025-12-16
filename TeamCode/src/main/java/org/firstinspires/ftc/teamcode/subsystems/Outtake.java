package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDCoefficients;
public class Outtake {


    private final DcMotor flywheelMotor;
    private PIDCoefficients flywheelCoeffs;
    public Outtake (HardwareMap hardwareMap) {
        PIDCoefficients flywheelCoeffs = new PIDCoefficients();
        flywheelMotor = hardwareMap.get(DcMotor.class, "flywheelMotor");
        flywheelMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void testRunMotorForward() {
        flywheelMotor.setPower(0.80);
    }

    public void idle() {
        flywheelMotor.setPower(0.35);
    }


}
