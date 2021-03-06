/**
 * For Monday, February 18, 2019
 * WHAT IS IN THIS CODE
 * 1. Testing the timer
 *    Pressing button #8 will start the timer, and as long as the button is help, the timer will count up and display in the DriverStation
 *    When you release the button, the timer should stop.
 *    This component is important because we need the timer to work for the intake
 *    INFO WE NEED: How long an acceptable time is to delay the intake. Retrieve the value from the timer.
 * 
 * 2. Testing moving the arm to a designated position
 *    Currently, we have a variable called desPosition with a value of 0. When button #6 is pressed, that will move the arm to 0
 *    This may have some kinks, so please add more phases and try to work it out. 
 *    When changing phases, comment out all other phases so that they don't conflict.
 *    INFO WE NEED: A phase that moves the arm quickly, and doesn't go outside the arm limits.
 * 
 * 3. Testing the arm limits
 *    Obviously the arm cannot spin 360 degrees around. It is going to hit the robot. So we need to implement a safety mechanism.
 *    Right now the arm's limit is 180. From 90 to -90. This is obviously not the real limit.
 *    PLEASE BEFORE YOU TEST THE DESIGNATED ARM CODE, PLEASE CHECK THE ARM LIMITS. THE FORMER IS ALREADY COMMENT OUT FOR YOU.
 *    After you have adjusted the limit to the real limits, then you can start running arm designation tests.
 *    
 *    Please keep in mind that the arm designation tests may conflict(as in the arm will try to move out of the limit to reach a position).
 *    As mentioned, please try to work it out.
 *    INFO WE NEED: Values that accurately reflect what the real robot arm limits are.
 * 
 */
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class Robot extends TimedRobot {

  
  WPI_TalonSRX myTalon = new WPI_TalonSRX(5);
  Joystick myJoystick = new Joystick(0);
  
  
  int targetPos = 512;
  int lim = 256;
  int error = 0;
  //PID values
  double p = 0;
  double i = 0;
  
  double d = 0;

  
  //Output
  double power = 0;

  @Override
  public void robotInit() {
    myTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
  }
  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {

  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    
  }

  @Override
  public void teleopInit() {

    
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {

    SmartDashboard.putString("DB/String 0", "Position: " + Integer.toString(myTalon.getSelectedSensorPosition()));
    SmartDashboard.putString("DB/String 1",  "Desired Position: " + Integer.toString(targetPos));
    SmartDashboard.putString("DB/String 2",  "Current Power: " + Double.toString(power));


    //Phase 1
    power = 1.2;

    /*
    //calculate error
    error = targetPos - myTalon.getSelectedSensorPosition();

    //P
    p = error/lim;

    //I
    i = i + error/lim;

    //D
    
    
    
    //Output
    power = p + i + d;
    */
    myTalon.set(ControlMode.PercentOutput, power);


    
  }
  
  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
