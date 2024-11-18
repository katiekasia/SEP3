package via.pro3.mainserver.database;

import via.pro3.mainserver.Model.Appointment;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.sql.SQLException;

public class EventRepository implements EventInterface {
    private DatabaseInterface database;

    public EventRepository(DatabaseInterface database) {
        this.database = database;
    }
@Override
    public synchronized void createUser(String user, String password) {
        String sql = "INSERT INTO users (userid, email, password) VALUES " +
                "(?, ?, ?)";
        try (PreparedStatement statement = database.getConnection().prepareStatement(sql)) {
            statement.setObject(1, UUID.randomUUID());
            statement.setString(2, user);
            statement.setString(3, password);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void createAppointment(Appointment appointment) {
        String sql = "INSERT INTO Appointment (appointmentID, date, time, city, status, description,CPR_number, Doctor_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = database.getConnection().prepareStatement(sql)) {
            statement.setInt(1, appointment.getAppointmentId());
            statement.setDate(2, Date.valueOf(appointment.getDate()));
            statement.setTime(3, appointment.getTime());
            statement.setString(4, appointment.getCity());
            statement.setString(5, appointment.getStatus());
            statement.setString(6, appointment.getDescription());
            statement.setString(7, appointment.getPatientCPR());
            statement.setString(8, appointment.getDoctorId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}