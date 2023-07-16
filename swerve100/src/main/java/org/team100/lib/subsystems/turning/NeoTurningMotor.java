package org.team100.lib.subsystems.turning;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class NeoTurningMotor implements TurningMotor {
    public static class Config {
        public int kCurrentLimit = 40;
    }

    private final Config m_config = new Config();
    private final CANSparkMax m_motor;

    public NeoTurningMotor(String name, int canId) {
        m_motor = new CANSparkMax(canId, MotorType.kBrushless);
        m_motor.setInverted(true);
        m_motor.setSmartCurrentLimit(m_config.kCurrentLimit);
        SmartDashboard.putData(String.format("Neo Turning Motor %s", name), this);
    }

    @Override
    public double get() {
        return m_motor.get();
    }

    @Override
    public void set(double output) {
        m_motor.set(output);
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.setSmartDashboardType("NeoTurningMotor");
        builder.addDoubleProperty("Device ID", () -> m_motor.getDeviceId(), null);
        builder.addDoubleProperty("Output", this::get, null);
    }

}