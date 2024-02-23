// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.DriveAround;
import frc.robot.commands.IntakeCmd;
import frc.robot.commands.KitbotMove;
import frc.robot.commands.KitbotShoot;
import frc.robot.commands.RollOutCmd;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.IntakeSubSystem;
import frc.robot.subsystems.KitBot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  //Subsystems
  private final DriveTrain m_Subsystem = new DriveTrain();
  private final IntakeSubSystem intake = new IntakeSubSystem();
  private final Arm arm = new Arm();
  private final KitBot bud = new KitBot();

  //Commands
  //private final IntakeCmd innout = new IntakeCmd(intake, 0);

  //Joystick
  private final Joystick controller = new Joystick(0);
  //CommandJoystick
  //private final CommandJoystick m_driverController = new CommandJoystick(0);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    m_Subsystem.setDefaultCommand(
      new DriveAround(m_Subsystem, () -> controller.getY()*0.75, () -> controller.getX()*0.75)
    );

    // Configure the trigger bindings
    
    configureBindings();
  }
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new JoystickButton(controller, 1).whileTrue(new IntakeCmd(intake, 0.75));
    new JoystickButton(controller, 2).whileTrue(new RollOutCmd(intake, 0.75));   
    new JoystickButton(controller, 3).whileTrue(new KitbotMove(bud, 1));
    new JoystickButton(controller, 4).whileTrue(new KitbotShoot(bud, 1));
        //.onTrue(new ExampleCommand(m_exampleSubsystem));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    //m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_Subsystem);
 }
}
