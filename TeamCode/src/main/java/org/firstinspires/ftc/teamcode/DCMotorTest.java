package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous


public class DCMotorTest extends LinearOpMode {

    DcMotor dcMotor;

    @Override
    public void runOpMode() throws InterruptedException {

        dcMotor = hardwareMap.get(DcMotor.class, "dcMotor1");

        waitForStart();

        telemetry.log().add("Hello, this is DCMotor test");
        dcMotor.setPower(0.5);
        sleep(5000);
    }
}
