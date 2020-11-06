package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;


@TeleOp(name="Driver Control 2858", group="Mecanum Control 2858")

public class DriverControl extends LinearOpMode {

    //Declare Op Mode members


    HardwareMap robot = new HardwareMap(); //use hardware map

    private ElapsedTime runtime = new ElapsedTime();




    @Override
    public void runOpMode(){


        //initialize the hardware variables, see HardwareMecanum.java
        robot.init(hardwareMap);



        //Send telemetry message to signify robot waiting
        telemetry.addData("Status","Initialized");
        telemetry.update();



        //Wait for the driver to press play
        waitForStart();

        //After the player presses play, run the opmode, run until the end of the match
        while (opModeIsActive()){
            //gamepad 1
            //left joystick y-axis forwards and backwards
            //right joystick x-axis strafe left and right
            double speed1 = Math.hypot(gamepad1.right_stick_x, gamepad1.right_stick_y); //give r of the polar coordinates. Math.hypot means to use the distance formula
            //give theta, the angle in polar coordinates,
            // Math.atan2() is the function to return the angle in radian between the x-axis and the ray
            double speed2 = Math.hypot(gamepad1.left_stick_x, - gamepad1.left_stick_y);
            double robotAngle1 = Math.atan2(- gamepad1.left_stick_x, gamepad1.left_stick_y) - Math.PI / 4;
            double robotAngle2 = Math.atan2(- gamepad1.right_stick_x, gamepad1.right_stick_y) - Math.PI / 4;
            final double frontLeftDrive =  speed1 * Math.cos(robotAngle1); //frontLeft and Right go in the same direction, bc. same polar coordinates
            final double frontRightDrive = speed1 * Math.sin(robotAngle1);
            final double backLeftDrive = speed2 * Math.sin(robotAngle2);
            final double backRightDrive = speed2 * Math.cos(robotAngle2);



            /*final boolean rightTurn = gamepad1.right_bumper;
            final boolean leftTurn = gamepad1.left_bumper;
            //turning
                robot.frontLeftDrive.setPower(0.5);
                robot.backLeftDrive.setPower(0.5);//inverse the direction the wheel is going, because in this cause the wheel is going inside, we want it going outside to turn right
                robot.frontRightDrive.setPower(0.5);
                robot.backRightDrive.setPower(0.5);

            }else if(leftTurn){
                robot.frontLeftDrive.setPower(0.5);
                robot.backLeftDrive.setPower(0.5);//inverse the direction the wheel is going, because in this case the wheel is going outside, we want it going inside to turn left
                robot.frontRightDrive.setPower(0.5);
            if(rightTurn){
                robot.backRightDrive.setPower(0.5);
            }else{
                robot.frontLeftDrive.setPower(frontLeftDrive);//if not strafing, set power to a certain value
                robot.backLeftDrive.setPower(backLeftDrive);
                robot.frontRightDrive.setPower(-frontRightDrive);
                robot.backRightDrive.setPower(-backRightDrive);
            }*/


            //gamepad 2

            final double shootRight = -gamepad2.right_stick_y;
            final double shootLeft = gamepad2.left_stick_y;
            robot.shootDriveL.setPower(shootLeft);
            robot.shootDriveR.setPower(shootRight);

            telemetry.update();

        }}}

