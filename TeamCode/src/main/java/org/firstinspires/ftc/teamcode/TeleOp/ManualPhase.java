package org.firstinspires.ftc.teamcode.TeleOp;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

//import org.firstinspires.ftc.teamcode.RobotHardware;


@TeleOp(name = "Teleop", group = "Drive")
public class ManualPhase extends LinearOpMode {

    private FtcDashboard dashboard = FtcDashboard.getInstance();
//    private RobotHardware robot;

    public void runOpMode () {
        init(); // init should just apply all hardware and set up all hardwares and needed functions

        while (!isStarted()){
        }
        start(); //initalizes pids here??? idk man
//
//        while (!isNotStarted()) {
//            loop();
//        }



    }

    //*
    // Initalize all hardwares here
    // *//
//    public void init() {
//        robot = new RobotHardware(this);
//
//
//    }
}
