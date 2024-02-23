package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubSystem;

public class RollOutCmd extends Command {
   @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final IntakeSubSystem m_subsystem;
    private final double speed;
    public RollOutCmd(IntakeSubSystem sub, double speed){
        m_subsystem = sub;
        this.speed = speed;
        addRequirements(sub);
    }
    @Override
    public void execute() {
      m_subsystem.setNRoller(speed);
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
      m_subsystem.setNRoller(0);
    }
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return false;
    }
}
