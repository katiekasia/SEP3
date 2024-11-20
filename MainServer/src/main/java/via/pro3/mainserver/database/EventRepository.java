package via.pro3.mainserver.database;

import via.pro3.mainserver.Model.Appointment;
import via.pro3.mainserver.Model.Patient;

import java.sql.*;
import java.util.UUID;

public class EventRepository implements EventInterface {
    private final DatabaseInterface database;

    public EventRepository(DatabaseInterface database) {
        this.database = database;
    }

    @Override
    public synchronized void createAppointment(Appointment appointment) {
        String sql = "INSERT INTO Appointment (appointmentID, date, time, city, status, description,specialization, CPR_number, Doctor_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//
//        try (PreparedStatement statement = database.getConnection().prepareStatement(sql)) {
//            statement.setInt(1, appointment.getAppointmentId());
//            statement.setDate(2, Date.valueOf(appointment.getDate()));
//            statement.setTime(3, appointment.getTime());
//            statement.setString(4, appointment.getCity());
//            statement.setString(5, appointment.getStatus());
//            statement.setString(6, appointment.getDescription());
//            statement.setString(7, appointment.getSpecialization());
//            statement.setString(8, appointment.getPatientCPR());
//            statement.setString(9, appointment.getDoctorId());
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException("Failed to create appointment: " + e.getMessage(), e);
//        }
    }

    public synchronized void createUser(Patient patient) {
        String sql = "INSERT INTO Patient (cpr_number, firstName, lastName, phone_number, email, password) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            if (patient == null) {
                throw new IllegalArgumentException("Patient cannot be null");
            }

            System.out.println("Attempting to create patient:");
            System.out.println("CPR: " + patient.getCPRNo());
            System.out.println("Name: " + patient.getName());
            System.out.println("Surname: " + patient.getSurname());
            System.out.println("Phone: " + patient.getPhone());
            System.out.println("Email: " + patient.getEmail());

            try (PreparedStatement statement = database.getConnection().prepareStatement(sql)) {
                statement.setString(1, String.valueOf(patient.getCPRNo()));
                statement.setString(2, patient.getName());
                statement.setString(3, patient.getSurname());
                statement.setString(4, patient.getPhone());
                statement.setString(5, patient.getEmail());
                statement.setString(6, patient.getPassword());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Database error details:");
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            throw new RuntimeException("Failed to create patient: " + e.getMessage(), e);
            }
    }
}