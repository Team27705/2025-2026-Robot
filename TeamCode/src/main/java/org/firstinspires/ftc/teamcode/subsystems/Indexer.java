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

    private int position;
    private String[] storage;

    //*
    // Gear ratio is 5:1 RPM is
    // *//

    public Indexer (HardwareMap hardwareMap){
        bootkicker = hardwareMap.get(Servo.class, "bootkicker");
        spindexerMotor = hardwareMap.get(DcMotor.class, "spindexer");

        spindexerMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        spindexerMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        storage = new String[3];
    }

    public void testMotor () {
        spindexerMotor.setPower(0.5);
        spindexerMotor.setTargetPosition(400);
    }

    public void cycleOnce () {

    }

    public void servoTest () {
        bootkicker.setPosition(0);
    }

    public void kick () {
        bootkicker.setPosition(120);
        bootkicker.setPosition(0);
    }

}
