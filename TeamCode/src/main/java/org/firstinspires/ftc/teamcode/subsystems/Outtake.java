package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDCoefficients;
public class Outtake {

    //https://docs.google.com/document/d/1tyWrXDfMidwYyP_5H4mZyVgaEswhOC35gvdmP-V-5hA/edit?pli=1&tab=t.0


    private final DcMotor flywheelMotor; //DcMotorEx is for advanced behavior like PIDS
    private PIDCoefficients flywheelCoeffs;
    public Outtake (HardwareMap hardwareMap) {
        PIDCoefficients flywheelCoeffs = new PIDCoefficients();
        flywheelMotor = hardwareMap.get(DcMotor.class, "flywheelMotor");
        flywheelMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void runOuttake() {
        flywheelMotor.setPower(0.80);
    }

    public void idle() {
        flywheelMotor.setPower(0.35);
    }


}
