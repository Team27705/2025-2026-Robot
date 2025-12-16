package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.hardware.motors.CRServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.RobotHardware;

public class Indexer {

    private Servo bootkicker;
    private DcMotor spindexerMotor;

    public Indexer (HardwareMap hardwareMap){
        bootkicker = hardwareMap.get(Servo.class, "bootkicker");
        spindexerMotor = hardwareMap.get(DcMotor.class, "spindexer");

    }

    public void testMotor () {
        spindexerMotor.setPower(0.5);
        spindexerMotor.setTargetPosition(4000);
    }

    public void servoTest () {

    }


}
