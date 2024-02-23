package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class KitBot extends SubsystemBase {
    private final CANSparkMax bottom = new CANSparkMax(7, MotorType.kBrushed);
    private final CANSparkMax top = new CANSparkMax(8,MotorType.kBrushed);
    //private double speed = 1.0;
    public KitBot(){
    }
    public void shootOut(double speed){
            bottom.setInverted(false);
            top.setInverted(false);
            bottom.follow(top);
            bottom.set(speed);
            top.set(speed);
    }
    public void shootNOut(double speed){
       bottom.setInverted(true);
            top.setInverted(true);
            bottom.set(speed);
            top.set(speed);
    }
    }
