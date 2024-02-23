package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveTrain;

public class TankDrive extends Command {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final DriveTrain driver;
    private final DoubleSupplier m_forward;
    private final DoubleSupplier m_forward2;
    public TankDrive(DriveTrain subsystem, DoubleSupplier y1,DoubleSupplier y2){
        driver = subsystem;
        m_forward = y1;
        m_forward2 = y2;
        addRequirements(driver);
    }
    @Override
    public void execute() {
        driver.tankDrive(m_forward, m_forward2);
      }
}
