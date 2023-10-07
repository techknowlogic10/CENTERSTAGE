package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
//import org.opencv.core.Mat;


@TeleOp
public class TeleOpDriveTest extends OpMode {
    // Declare our motors

    DcMotor testDCMotor = null;

    double Drivepower = 2;



    @Override
    public void init() {
        testDCMotor = hardwareMap.dcMotor.get("dcMotor1");

    }

    @Override
    public void loop() {


        Drivepower = 4;
        if (gamepad1.right_trigger > 0.5){
            Drivepower = 2.5;

        }
        if (gamepad1.left_stick_button){
            Drivepower = 1.5;
        }

        telemetry.addLine("left_stick_x: " + gamepad1.left_stick_x);
        telemetry.addLine("left_stick_y: " + gamepad1.left_stick_y);
        telemetry.addLine("left_stick_button: " + gamepad1.left_stick_button);
        telemetry.addLine("right_stick_x: " + gamepad1.right_stick_x);
        telemetry.addLine("right_stick_y: " + gamepad1.right_stick_y);

        double y = gamepad1.left_stick_y; // Remember, this is reversed!
        double x = -gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
        double rx = -gamepad1.right_stick_x;

        // Denominator is the largest motor power (absolute value) or 1
        // This ensures all the powers maintain the same ratio, but only when
        // at least one is out of the range [-1, 1]
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), Drivepower);
        double frontLeftPower = (y + x + rx) / denominator;
        double backLeftPower = (y - x + rx) / denominator;
        double frontRightPower = (y - x - rx) / denominator;
        double backRightPower = (y + x - rx) / denominator;

        double averageSpeed = (Math.abs(frontLeftPower)+Math.abs(backLeftPower)+Math.abs(frontRightPower)+Math.abs(backRightPower))/4;

        testDCMotor.setPower(frontLeftPower);


        telemetry.update();

    }

}
