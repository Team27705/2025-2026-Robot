package org.firstinspires.ftc.teamcode.subsystems.Sensors;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Limelight {
    private Limelight3A limelight;

    private int limelightMode; // 0 is to track AprilTags, 1 is used to track for balls and the colors

    public Limelight (HardwareMap hardwareMap) {

    }

    public void startLimelight (int rate) {
        setLimelightPullingRate(rate);
        limelight.start();
    }

    public void closeLimeLight () {
        limelight.close();
    }

    public void setLimelightPullingRate(int rate) {
        limelight.setPollRateHz(rate);
    }

    //**
    // Change pipeline depending on weather or not you need to get distance from an AprilTag or the ball
    // Use
    // *//

    public void updateTelemetry () {
        LLResult llResult = limelight.getLatestResult();
        if (llResult != null && llResult.isValid()) {
//
        }
    }

}
