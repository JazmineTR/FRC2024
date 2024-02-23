package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubSystem extends SubsystemBase {
    private final CANSparkMax roller = new CANSparkMax(5,MotorType.kBrushless);
    //private final CANSparkMax updown = new CANSparkMax(6,MotorType.kBrushless);
    //private double speed = 0.75;
    public IntakeSubSystem(){
    }
    // public void takeIn(){
    //     roller.setInverted(false);
    //     roller.set(speed);
    // }
    // public void takeOut(){
    //     roller.setInverted(true);
    //     roller.set(speed);
    // }
    // public void stop(){
    //     roller.setInverted(false);
    //     roller.set(0);
    // }
    public void setRoller(double speed){
            roller.setInverted(false);
            roller.set(speed);
    }
    public void setNRoller(double speed){
            roller.setInverted(true);
            roller.set(speed);
}
}
