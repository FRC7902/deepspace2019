/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import edu.wpi.first.wpilibj.command.PIDSubsystem;


/**
 * Add your docs here.
 */
public class ArmSubsystem extends Subsystem {
  //TalonSRX myTalon = new TalonSRX(0);//set this to the correct port
  WPI_TalonSRX myTalon = new WPI_TalonSRX(5);
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public ArmSubsystem (){
    myTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);

  }
  

  public void moveArm(Joystick joystick, double speed) {
    myTalon.set(ControlMode.PercentOutput, joystick.getY()*speed);
    
  }

  public void stopArm(){
    myTalon.disable();
  }

  public int getArmPosition(){
    return myTalon.getSelectedSensorPosition() % 4096;
  }
  

  public void setPreset(int position){

    int desPosition = 0;
    switch (position) {//will need to be set to arbitrary numbers
      case 1://lowest cargo
        desPosition = 1;
      case 2://middle cargo
        desPosition = 1;
      case 3://highest cargo
        desPosition = 1;
      case 4://lowest hatch
        desPosition = 1;
      case 5://middle hatch
        desPosition = 1;
      case 6://highest hatch
        desPosition = 1;
      case 7://lowest back hatch
        desPosition = 1;
      case 8://middle back hatch
        desPosition = 1;  
      case 9://highest back hatch
        desPosition = 1;
      case 10://lowest back cargo
        desPosition = 1;
      case 11://middle back cargo
        desPosition = 1;
      case 12://highest back cargo
        desPosition = 1;
      case 13://ground position
        desPosition = 1;
    }

    int currPosition = getArmPosition();

    

  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
