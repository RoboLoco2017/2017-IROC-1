package org.usfirst.frc.team5338.robot.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter extends Subsystem {
	// Creates the four CANTalon motor controller objects.
	private final CANTalon SHOOTER_1 = new CANTalon(50, 1);
	private final CANTalon SHOOTER_2 = new CANTalon(51, 1);
	private final VictorSP INTAKE = new VictorSP(0);

	// DriveTrain object constructor which reverses output of backwards motors.
	public Shooter() {
		super();
		SHOOTER_1.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		SHOOTER_2.changeControlMode(TalonControlMode.Follower);
		SHOOTER_2.set(SHOOTER_1.getDeviceID());
		SHOOTER_1.reverseOutput(true);
		SHOOTER_2.reverseOutput(false);
		SHOOTER_1.configNominalOutputVoltage(+0.0f, -0.0f);
		SHOOTER_1.configPeakOutputVoltage(+12.0f, -12.0f);
		SHOOTER_1.setProfile(0);
		SHOOTER_1.setF((1 * 1023) / (-14500 * 4096.0 / 600.0));
		SHOOTER_1.setP((0.5 * 1023) / -90);
		SHOOTER_1.setI(0);
		SHOOTER_1.setD(0);
	}

	// Sets the default command to run during teleop to joystick driving.
	public void initDefaultCommand() {
	}

	// Gets joysticks input and calls the drive function with arguments.
	public void shoot() {
		INTAKE.set(-0.55);
		SHOOTER_1.changeControlMode(TalonControlMode.Speed);
		SHOOTER_1.set(-6500);
		SmartDashboard.putNumber("Speed", SHOOTER_1.getSpeed());
	}
}