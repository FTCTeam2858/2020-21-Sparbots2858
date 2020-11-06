package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.VoltageSensor;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

public class HardwareMap {

        /* public opMode members */
        public DcMotor frontLeftDrive = null;
        public DcMotor frontRightDrive = null;
        public DcMotor backLeftDrive = null;
        public DcMotor backRightDrive = null;
        public DcMotor shootDriveL = null;
        public DcMotor shootDriveR = null;


        // hsvValues is an array that will hold the hue, saturation, and value information.




        // sometimes it helps to multiply the raw RGB values with a scale factor
        // to amplify/attentuate the measured values.
        public final double SCALE_FACTOR = 255;







        //Set servo initial positions


        VoltageSensor batteryVoltSensor;

        BNO055IMU teamIMU;
        // saved current (adjusted) orientation/heading
        double curHeading;
        // for logging
        String orientationLog;

        /* private opMode members */
        com.qualcomm.robotcore.hardware.HardwareMap hwMap = null;


        /* Constructor */
        public HardwareMap() {

        }

        /* Initialize standard Hardware interfaces */
        public void init(com.qualcomm.robotcore.hardware.HardwareMap ahwMap) {
            // Save reference to Hardware map
            hwMap = ahwMap;

            // Define and Initialize Motors
            frontLeftDrive = hwMap.get(DcMotor.class, "front_left_drive");
            frontRightDrive = hwMap.get(DcMotor.class, "front_right_drive");
            backLeftDrive = hwMap.get(DcMotor.class, "back_left_drive");
            backRightDrive = hwMap.get(DcMotor.class, "back_right_drive");
            shootDriveL = hwMap.get(DcMotor.class, "shoot_left_drive");
            shootDriveR = hwMap.get(DcMotor.class, "shoot_right_drive");
            //turnMotor = hwMap.get(DcMotor.class,"turn_motor");




            // Set all motors to zero power
            frontLeftDrive.setPower(0);
            frontRightDrive.setPower(0);
            backLeftDrive.setPower(0);
            backRightDrive.setPower(0);
            shootDriveR.setPower(0);
            shootDriveL.setPower(0);



            // use RUN_USING_ENCODERS
            frontLeftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            frontRightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            backLeftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            backRightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            shootDriveR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            shootDriveL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);




            // Define and initialize ALL installed servos.



            // IMU calibration file
            /*String imuCalibration = "RevIMUCalibration.json";


            batteryVoltSensor = hwMap.voltageSensor.get("Expansion Hub 3");

            // Connect to the IMU in the primary hub
            // Rev has a built-in IMU for relative position information. The swerve drive uses the IMU.
            teamIMU = hwMap.get(BNO055IMU.class, "imu");

            // Set up the parameters with which we will use our IMU.
            BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
            parameters.angleUnit           = BNO055IMU.AngleUnit.DEGREES;
            parameters.accelUnit           = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;

            parameters.calibrationDataFile = imuCalibration; // from calibration sample
            parameters.loggingEnabled      = true;
            parameters.loggingTag          = "IMU";
//        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();
            // activate the parameters
            teamIMU.initialize(parameters);

            checkOrientation();

        }

        void checkOrientation (){
            // and the angles from that IMU
            Orientation angles;
            Acceleration gravAngles;

            // read the orientation of the rob
            // ot
            angles = teamIMU.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);

            // and save the heading
            curHeading = - ( angles.firstAngle );

        }*/
    }}


