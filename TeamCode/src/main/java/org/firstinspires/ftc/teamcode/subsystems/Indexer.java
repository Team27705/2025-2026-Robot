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
    private double PPR = 7.0;
    private double GEARBOX_RATIO = 50.9;
    private double MOTOR_GEARBOX_PPR = 356.3;

    private double indexerGearUp = 5.0;

    private final double ROTATE_TO_OUTTAKE_ANGLE = 120/72;
    private final double SPINDEXER_MOTOR_RPM = 6600/50.9; //129.666012 on website is 130

    private final int ONE_CYCLE_ENCODER_AMOUNT = (int) (MOTOR_GEARBOX_PPR * ROTATE_TO_OUTTAKE_ANGLE) + 1;

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
        spindexerMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        spindexerMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        storage = new String[3];
        bootkicker.setDirection(Servo.Direction.REVERSE);
    }

    public void testCycleOnce () {
        spindexerMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        spindexerMotor.setTargetPosition(ONE_CYCLE_ENCODER_AMOUNT);
        spindexerMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        if (spindexerMotor.isBusy()) {
            spindexerMotor.setPower(.5);
        }
        else {
            spindexerMotor.setPower(0);
        }

    }
    public boolean motorStatus () {
        return  spindexerMotor.isBusy();
    }

    public void servoTest () {
        bootkicker.setPosition(0);
    }

    public void kick () {
        bootkicker.setPosition(120);
    }
    public void reset() {
        bootkicker.setPosition(0);
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
        if (!spindexerMotor.isBusy()) {
            telemMessage = "'\n Spindexer Status: Currently spinning";
        }
        else {
            telemMessage = "\n Spindexer : Ready";
        }
        return telemMessage;
    }

}
