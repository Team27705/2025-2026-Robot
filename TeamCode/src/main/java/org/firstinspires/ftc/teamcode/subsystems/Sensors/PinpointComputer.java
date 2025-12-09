package org.firstinspires.ftc.teamcode.subsystems.Sensors;

import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class PinpointComputer {
    GoBildaPinpointDriver pinpoint;

    public PinpointComputer(HardwareMap hardwareMap) {
        pinpoint = hardwareMap.get(GoBildaPinpointDriver.class, "Pinpoint Computer");

    }
    public void runOpMode () {
    }
}