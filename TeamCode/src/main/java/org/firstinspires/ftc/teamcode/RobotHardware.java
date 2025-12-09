//package org.firstinspires.ftc.teamcode;
//
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//
//import org.firstinspires.ftc.teamcode.subsystems.Sensors.PinpointComputer;
//import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
//import org.firstinspires.ftc.teamcode.subsystems.Sensors.Limelight;
//
//public class RobotHardware {
//    private final OpMode myOpMode;
//    public final Drivetrain drivetrain;
//    public final PinpointComputer pinpoint;
//
//    public final Limelight limelight;
//
//    /*
//    * For initializing teleop opmodes
//    * */
//    public RobotHardware (OpMode opMode) {
//        myOpMode = LinearOpMode.class;
//
//    }
//    /*
//    *
//    * */
//    public RobotHardware (LinearOpMode opMode) {
//        myOpMode = opMode;
//
//
//    }
//
//    public void init () {
//        drivetrain = new Drivetrain(myOpMode.hardwareMap);
//        pinpoint = new PinpointComputer(myOpMode.hardwareMap);
//        limelight = new Limelight(myOpMode.hardwareMap);
//    }
//
//}
