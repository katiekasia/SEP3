package via.pro3.mainserver.database;

import via.pro3.mainserver.DTOs.LoginDto;
import via.pro3.mainserver.Model.Appointment;
import via.pro3.mainserver.Model.Clinic;
import via.pro3.mainserver.Model.Doctor;
import via.pro3.mainserver.Model.Patient;

import java.sql.*;

public class EventRepository implements EventInterface {
    private final DatabaseInterface database;

    public EventRepository(DatabaseInterface database) {
        this.database = database;
    }

    @Override
    public synchronized void createAppointment(Appointment appointment, Doctor doctor, Patient patient) {
        String sql = "INSERT INTO Appointment (id, description,type, date, time, status, patient_CPR, doctor_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = database.getConnection().prepareStatement(sql)) {
            statement.setInt(1, appointment.getAppointmentId());
            statement.setString(2, appointment.getDescription());
            statement.setString(3, appointment.getType());
            statement.setDate(4, Date.valueOf(appointment.getDate()));
            statement.setTime(5, Time.valueOf(appointment.getTime()));
            statement.setString(6, appointment.getStatus());
            statement.setString(7, patient.getCPRNo());
            statement.setString(8, doctor.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create appointment: " + e.getMessage(), e);
        }
    }

    @Override
    public synchronized Clinic getClinicByDoctorId(String doctorId) {
        String sql = """
        SELECT c.id, c.name, c.street, c.street_number, c.city_PO_code, city.city_name
        FROM clinic c
        INNER JOIN doctor d ON c.id = d.clinic_id
        INNER JOIN city ON c.city_PO_code = city.postal_code
        WHERE d.id = ?
        """;


        try (PreparedStatement statement = database.getConnection().prepareStatement(sql)) {
            statement.setString(1, doctorId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Clinic(
                        resultSet.getString("name"),
                        resultSet.getString("city_name"),
                        resultSet.getString("street"),
                        resultSet.getString("street_number")
                        );
                } else {
                    throw new RuntimeException("No clinic found for doctorId: " + doctorId);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch clinic for doctorId: " + doctorId, e);
        }
    }
    @Override
    public synchronized Doctor getDoctorById(String doctorId) {
        String sql = "SELECT * FROM Doctor WHERE id = ?";
        try (PreparedStatement statement = database.getConnection().prepareStatement(sql)) {
            statement.setString(1, doctorId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Doctor(
                        resultSet.getString("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("password"),
                        resultSet.getString("first_name"),
                        resultSet.getString("specialisation"),
                        getClinicByDoctorId(doctorId)
                    );
                } else {
                    throw new RuntimeException("No doctor found for doctorId: " + doctorId);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch doctor from SQL: " + e.getMessage(), e);
        }
    }

    @Override
    public synchronized Patient getPatientByCpr(String patientCpr) {
        String sql = "SELECT * FROM Patient WHERE CPR_number = ?";
        try (PreparedStatement statement = database.getConnection().prepareStatement(sql)) {
            statement.setString(1, patientCpr);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Patient(
                        resultSet.getString("CPR_number"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("email"),
                        resultSet.getString("password")
                    );
                } else {
                    throw new RuntimeException("No patient found for CPR number: " + patientCpr);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch patient from SQL: " + e.getMessage(), e);
        }
    }

    public synchronized void createUser(Patient patient) {
        String sql = "INSERT INTO patient (cpr_number, first_name, last_name, phone_number, email, password) VALUES (?, ?, ?, ?, ?, ?)";


            try (Connection conn = database.getConnection();
                PreparedStatement statement = conn.prepareStatement(sql)) {


                statement.setString(1, patient.getCPRNo());

                statement.setString(2, patient.getName());

                statement.setString(3, patient.getSurname());

                statement.setString(4, patient.getPhone());

                System.out.println(patient.getPhone());
                statement.setString(5, patient.getEmail());

                statement.setString(6, patient.getPassword());
                statement.executeUpdate();

            }
         catch (SQLException e) {

            throw new RuntimeException("Failed to create patient: " + e.getMessage(), e);
        }
    }

    public synchronized boolean loginUser(LoginDto request) {
        String sql = "SELECT * FROM patient WHERE CPR_number = ?";
        try (PreparedStatement statement = database.getConnection().prepareStatement(sql)) {
            statement.setString(1, request.getcpr());
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return true;
                } else {
                    throw new RuntimeException("Invalid credentials provided");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch patient from SQL: " + e.getMessage(), e);
        }
    }

    @Override
    public String loginDoctor(LoginDto request) {
        String sql = "SELECT * FROM doctor WHERE id = ? AND password =?";
        try (PreparedStatement statement = database.getConnection().prepareStatement(sql)) {
            statement.setString(1, request.getcpr());
            statement.setString(2, request.getPassword());
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return "LoggedIn";
                } else {
                    return "Nope";
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch patient from SQL: " + e.getMessage(), e);
        }
    }

    @Override
    public String changePassowrdDoctor(LoginDto request) {
        String sql = "UPDATE Doctor SET password = ? WHERE password = ?";
        try(PreparedStatement statement = database.getConnection().prepareStatement(sql)){
            statement.setString(1, request.getPassword());
            statement.setString(2, request.getcpr());
            statement.executeUpdate();
            return "PasswordChanged";
        }
        catch (SQLException e) {
            throw new RuntimeException("Failed to fetch doctor from SQL: " + e.getMessage(), e);
        }
    }
}
