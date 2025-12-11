package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Outtake;
import org.firstinspires.ftc.teamcode.subsystems.Sensors.PinpointComputer;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Sensors.Limelight;

public class RobotHardware {
    private Outtake outtake;
    private Intake intake;

    private LinearOpMode opMode;

    /*
    * For initializing teleop opmodes
    * */

    public RobotHardware (LinearOpMode myOpMode) {
        opMode = myOpMode;


        outtake = new Outtake(myOpMode.hardwareMap);
        intake = new Intake(myOpMode.hardwareMap);


    }

    public void init() {
        opMode.telemetry.addData(">","Robot initialized");
    }

    public Outtake getOuttake() {
        return outtake;
    }

    public Intake getIntake() {
        return intake;
    }
}
