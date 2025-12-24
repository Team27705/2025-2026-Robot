package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.hardware.motors.CRServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.RobotHardware;

public class Indexer {

    private Servo bootkicker;
    private DcMotor spindexerMotor;
    private double PPR = 7.0;
    private double GEARBOX_RATIO = 50.9;
    private double MOTOR_GEARBOX_PPR = 356.3;

    private double indexerGearUp = 5.0;

    private final double SPINDEXER_MOTOR_RPM = 6600/50.9; //129.666012 on website is 130

//    private final int ONE_CYCLE_ENCODER_AMOUNT = (int) (MOTOR_GEARBOX_PPR * ROTATE_TO_OUTTAKE_ANGLE) + 1;

    private final double oneCycle = 1453.2 * 120/72; //2422

    private final int error = 100; ///50 FOR 0.5 POWER

    private boolean motorReset = false;

    private int position;
    private String[] storage;

    //**
    // 1 Full motor rotation is 356.3 on encoder
    // need 1 rotation PPR * angle desired/1 roation angle, 356.3 * (120/72)
    // .5 power is 85% RPM, RPM is
    //593.833333 Encoder
    // **//


    public Indexer (HardwareMap hardwareMap){
        bootkicker = hardwareMap.get(Servo.class, "bootkicker");
        spindexerMotor = hardwareMap.get(DcMotor.class, "spindexer");
        storage = new String[3];
        bootkicker.setDirection(Servo.Direction.REVERSE);
        spindexerMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        spindexerMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }


    public boolean canSpin () {
        return spindexerMotor.getMode().equals(DcMotor.RunMode.STOP_AND_RESET_ENCODER); //maybe use motorReset variable instead
    }

    public void resetServo() {
        bootkicker.setPosition(0);
    }
    public void cycleOnce () {
        spindexerMotor.setTargetPosition((int)oneCycle - error);
        spindexerMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        spindexerMotor.setPower(.7);
    }

    public void motorStatus () {
        if (spindexerMotor.getCurrentPosition() == (int) oneCycle - error) { // maybe subtract a little from onecycle to account for momentum, also use != maybe?
            motorReset = true;
        }
        if (motorReset) {
            spindexerMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorReset = false;
        }
    }


    public void kick() {
        bootkicker.setPosition(.45);
    }
    public String telemetry () {
        String telemMessage = "";
        telemMessage += "\nSpindexer Motor Encoder : " + spindexerMotor.getCurrentPosition();
        telemMessage += "\nSpindexer Angle rotated: " + spindexerMotor.getCurrentPosition() / 72.0;

        telemMessage += isSpinning();
        return telemMessage;
    }

    public String isSpinning () {
        String telemMessage = "\n Indexer Status: ";
        if (spindexerMotor.getCurrentPosition() != oneCycle) {
            telemMessage = "'\n Spindexer Status: Currently spinning";
        }
        else {
            telemMessage = "\n Spindexer : Ready";
        }
        return telemMessage;
    }

}