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
            double speed1 = Math.hypot(gamepad1.right_stick_x, - gamepad1.right_stick_y); //give r of the polar coordinates. Math.hypot means to use the distance formula
            //give theta, the angle in polar coordinates,
            // Math.atan2() is the function to return the angle in radian between the x-axis and the ray
            double speed2 = Math.hypot(gamepad1.left_stick_x, - gamepad1.left_stick_y);
            double robotAngle2 = Math.atan2( gamepad1.left_stick_y, - gamepad1.left_stick_x) - Math.PI / 4;
            double robotAngle1 = Math.atan2( - gamepad1.right_stick_y, gamepad1.right_stick_x) - Math.PI / 4;
            final double frontLeftDrive =  speed2 * Math.cos(robotAngle2); //frontLeft and Right go in the same direction, bc. same polar coordinates
            final double frontRightDrive = speed1 * Math.sin(robotAngle1);
            final double backLeftDrive = speed2 * Math.sin(robotAngle2);
            final double backRightDrive = speed1 * Math.cos(-robotAngle1);
            robot.frontLeftDrive.setPower(frontLeftDrive);//if not strafing, set power to a certain value
            robot.backLeftDrive.setPower(backLeftDrive);
            robot.frontRightDrive.setPower(-frontRightDrive);
            robot.backRightDrive.setPower(backRightDrive);


            final double shootRight = -gamepad2.right_stick_y;
            final double shootLeft = gamepad2.left_stick_y;
            //robot.shootDriveL.setPower(shootLeft);
          //  robot.shootDriveR.setPower(shootRight);
            final boolean gearTop = gamepad2.x;
            final boolean gearBtm = gamepad2.a;
            if(gearTop){
                robot.gearTop.setPower(1);}
            else if(!gearTop){
                robot.gearTop.setPower(0);
            }
            if(gearBtm){
                robot.gearBtm.setPower(1);}
            else if(!gearBtm){
                robot.gearBtm.setPower(0);
            }
            final boolean shootLowPower = gamepad2.right_bumper;
            final boolean shootHighPower = gamepad2.left_bumper;
            final boolean shootPowerShot = gamepad2.y;
            //final boolean intakeLiftUp = gamepad2.y;
            //final boolean intakeLiftDown = gamepad2.b;
            //final double wheelDrive = - gamepad2.left_stick_y;
            //robot.wheelDrive.setPower(wheelDrive);

            if (shootLowPower){
                robot.shootDriveL.setPower(1);
                robot.shootDriveR.setPower(-1);

            }else {
                robot.shootDriveL.setPower(0);
                robot.shootDriveR.setPower(0);
            }

            if (shootHighPower){
                robot.shootDriveL.setPower(0.80);
                robot.shootDriveR.setPower(-0.80);

            }else {
                robot.shootDriveL.setPower(0);
                robot.shootDriveR.setPower(0);
            }

            if(shootPowerShot) {
                robot.shootDriveL.setPower(0.57);
                robot.shootDriveR.setPower(-0.57);

            }else if(!shootPowerShot){

                robot.shootDriveL.setPower(0);
                robot.shootDriveR.setPower(0);

            }

            final boolean ringGrab = gamepad1.left_bumper;
            final boolean ringDrop = gamepad1.right_bumper;
            if(ringGrab){
                robot.ringDrive.setPower(-0.25);
            }else if(ringDrop){
                robot.ringDrive.setPower(0.25);
            }else if (!ringGrab && !ringDrop){
                robot.ringDrive.setPower(0);
            }

            final boolean ringPosition = gamepad1.y;
            if(ringPosition){
                robot.ringClamp.setPosition(1);
            }else if(!ringPosition){
                robot.ringClamp.setPosition(0);
            }

            final boolean ringBlock = gamepad1.b;
            if(ringBlock){
                robot.ringBlock.setPosition(0.7);
            }else if(!ringBlock){
                robot.ringBlock.setPosition(1);
            }
            double shootTest = - gamepad2.left_stick_y;
            robot.shootDriveL.setPower(shootTest);
            robot.shootDriveR.setPower(-shootTest);



            telemetry.addData("Shoot power,", shootTest);
            telemetry.update();
            //we can switch the servo with the motor in the ringDrop an ringGrab with the new intake
            //because the other idea thomas came up with did not work to its full extent

        }}}

