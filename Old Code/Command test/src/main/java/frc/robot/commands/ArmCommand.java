/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.subsystems.ArmSubsystem;

public class ArmCommand extends Command {
  public ArmCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires (Robot.armSubsystem);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.armSubsystem.stopArm();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.armSubsystem.moveArm(Robot.m_oi.getOperatorStick(), 1);
    SmartDashboard.putString("DB/String 0", "Arm: " + Robot.armSubsystem.getArmPosition());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
