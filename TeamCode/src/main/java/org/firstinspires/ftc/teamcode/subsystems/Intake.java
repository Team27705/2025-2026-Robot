package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class Intake {
    private final DcMotor intakeMotor;

    private final RevColorSensorV3 colorSensor;

    public Intake (HardwareMap hardwareMap) {
        intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");
        intakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intakeMotor.setPower(0);

        colorSensor = hardwareMap.get(RevColorSensorV3.class, "colorSensor");

    }

//    public Mode returnIntakeState  () {
//        return
//    }

    public void idleIntake() {
        intakeMotor.setPower(0);
    }
    public void spinIntake () {
        intakeMotor.setPower(-0.8);
    }

    public String colorDetected () {
        String rgb = "";

        rgb += "red:" + colorSensor.red();
        rgb += "\ngreen:" + colorSensor.green();
        rgb += "\nblue:" + colorSensor.blue();
        return rgb;
    }

}
