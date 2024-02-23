package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveTrain;

public class DriveAround extends Command {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final DriveTrain driver;
    private final DoubleSupplier m_forward;
    private final DoubleSupplier m_rotation;
    public DriveAround(DriveTrain subsystem, DoubleSupplier y1, DoubleSupplier rotate){
        driver = subsystem;
        m_forward = y1;
        m_rotation = rotate;
        addRequirements(driver);
    }
    @Override
    public void execute() {
        driver.arcadeDrive(m_forward, m_rotation);
      }
}
