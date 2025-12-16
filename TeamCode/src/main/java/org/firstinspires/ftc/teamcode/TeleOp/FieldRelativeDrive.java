package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.RobotHardware;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Outtake;


@TeleOp (name = "field relative", group =  "TeleOp")
public class FieldRelativeDrive extends LinearOpMode {

    RobotHardware robot;

    private Drivetrain drivetrain;

    private Outtake outtake;

    private Intake intake;


    @Override
    public void runOpMode() throws InterruptedException {
        robot = new RobotHardware(this);
        robot.init();

        outtake = robot.getOuttake();
        intake = robot.getIntake();
        drivetrain = robot.getDrivetrain();


        while (opModeIsActive()) {

        }
    }
}
