package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.Indexer;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Limelight;
import org.firstinspires.ftc.teamcode.subsystems.Outtake;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

public class RobotHardware {
    private Outtake outtake;
    private Intake intake;
    private Indexer indexer;

    private Drivetrain drivetrain;


    private LinearOpMode opMode;

    /*
    * For initializing teleop opmodes
    * */

    public RobotHardware (LinearOpMode myOpMode) {
        opMode = myOpMode;


        outtake = new Outtake(myOpMode.hardwareMap);
        intake = new Intake(myOpMode.hardwareMap);
        indexer = new Indexer(myOpMode.hardwareMap);
        drivetrain = new Drivetrain(myOpMode.hardwareMap);
    }

    public Drivetrain getDrivetrain() {
        return drivetrain;
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

    public Indexer getIndexer() {
        return indexer;
    }
}
