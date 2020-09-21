package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.Servo;



@TeleOp(name="Driver Control 2858", group="MecanumControl2858")

public class HardwareCode extends LinearOpMode {

    //Declare Op Mode members

    //below were commented out because configuration cannot find motor means motorTest
    //private Gyroscope imu;
    //private DcMotor motorTest;
    //private DigitalChannel digitalTouch;
    //private DistanceSensor sensorColorRange;
    //private Servo servoTest;

    HardwareMecanum robot = new HardwareMecanum();

    @Override
    public void runOpMode(){

        //can't find motorTest
        //imu = hardwareMap.get(Gyroscope.class, "imu");
        //motorTest = hardwareMap.get(DcMotor.class, "motorTest");
        ////digitalTouch = hardwareMap.get(DigitalChannel.class, "digitalTouch");
        //sensorColorRange = hardwareMap.get(DistanceSensor.class, "sensorColorRange");
        //servoTest = hardwareMap.get(Servo.class, "servoTest");



        //initialize the hardware variables, see HardwareMecanum.java
        robot.init(hardwareMap);

        //Send telemetry message to signify robot waiting
        telemetry.addData("Status","Initialized");
        telemetry.update();



        //Wait for the driver to press play
        waitForStart();

        //After the player presses play, run the opmode, run until the end of the match
        while (opModeIsActive()){
            double r = Math.hypot(-gamepad1.left_stick_x, gamepad1.left_stick_y); //give r of the polar coordinates. Math.hypot means to use the distance formula
            double robotAngle = Math.atan2(gamepad1.left_stick_y, -gamepad1.left_stick_x) - Math.PI / 4; //give theta, the angle in polar coordinates, Math.atan2() is the function to return the angle in radian between the x-axis and the ray
            double rightX = gamepad1.right_stick_x;
            final double frontLeft = r * Math.cos(robotAngle) + rightX; //frontLeft and Right go in the same direction, bc. same polar coordinates
            final double frontRight = r * Math.sin(robotAngle) - rightX;
            final double backLeft = r * Math.sin(robotAngle) + rightX;
            final double backRight = r* Math.cos(robotAngle) - rightX;

            //set power to a certain value
            robot.frontLeftDrive.setPower(frontLeft);
            robot.frontRightDrive.setPower(frontRight);
            robot.backLeftDrive.setPower(backLeft);
            robot.backLeftDrive.setPower(backRight);

            //send message to the player
            telemetry.addData("frontLeft",  "%.2f", frontLeft);
            telemetry.addData("frontRight", "%.2f", frontRight);
            telemetry.addData("backLeft",  "%.2f", backLeft);
            telemetry.addData("backRight", "%.2f", backRight);
            telemetry.update();


        }


    }
    }

