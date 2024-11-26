package via.pro3.mainserver.database;

import via.pro3.mainserver.Model.Appointment;
import via.pro3.mainserver.Model.Clinic;
import via.pro3.mainserver.Model.Doctor;
import via.pro3.mainserver.Model.Patient;

import java.sql.*;
import java.util.UUID;

public class EventRepository implements EventInterface {
    private final DatabaseInterface database;

    public EventRepository(DatabaseInterface database) {
        this.database = database;
    }

    @Override
    public synchronized void createAppointment(Appointment appointment, Doctor doctor, Patient patient) {
        String sql = "INSERT INTO Appointment (appointmentID, date, time, city, status, description,type, CPR_number, Doctor_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = database.getConnection().prepareStatement(sql)) {
            statement.setInt(1, appointment.getAppointmentId());
            statement.setDate(2, Date.valueOf(appointment.getDate()));
            statement.setTime(3, Time.valueOf(appointment.getTime()));
            statement.setString(4, appointment.getCity());
            statement.setString(5, appointment.getStatus());
            statement.setString(6, appointment.getDescription());
            statement.setString(7, appointment.getType());
            statement.setString(8, patient.getCPRNo());
            statement.setString(9, doctor.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create appointment: " + e.getMessage(), e);
        }
    }

    @Override
    public synchronized Clinic getClinicByDoctorId(String doctorId)
    {
        String sql = "SELECT * FROM Clinic WHERE doctorID = ?";
        try(PreparedStatement statement = database.getConnection()
            .prepareStatement(sql))
        {
            statement.setString(1,doctorId);
            try(ResultSet resultSet = statement.executeQuery())
            {
                if(resultSet.next())
                {
                    return new Clinic(
                        resultSet.getString("name"),
                        resultSet.getString("city"),
                        resultSet.getString("address"),
                        //TO DO IS TO ADD A NUMBER FOR ADDRESS INTO DATABASE
                        resultSet.getString("address")
                    );
                }
                else {
                    throw new RuntimeException("No clinic found");
                }
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException("Failed to fetch doctor from SQL");
        }
    }


    @Override
    public synchronized Doctor getDoctorById(String doctorId)
    {
        String sql = "SELET * FROM Doctor WHERE = doctorID=?";
        try(PreparedStatement statement = database.getConnection()
            .prepareStatement(sql))
        {
            statement.setString(1,doctorId);


            try(ResultSet resultSet = statement.executeQuery())
            {
                if(resultSet.next())
                {
                    return new Doctor(
                        resultSet.getString("doctorID"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("password"),
                        //TO DO IS TO SET THE CORRECT EMAIL INTO DATABASE
                        resultSet.getString("firstName"),
                        resultSet.getString("specialization"),
                        getClinicByDoctorId(doctorId)

                    );
                }
                else {
                    throw new RuntimeException("No doctor found");
                }
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException("Failed to fetch doctor from SQL");
        }
    }

    @Override
    public synchronized Patient getPatientByCpr(String patientCpr)
    {
        String sql = "SELET * FROM Patient WHERE CPR_number=?";
        try(PreparedStatement statement = database.getConnection().prepareStatement(sql))
        {
            statement.setString(1, patientCpr);
            try (ResultSet resultSet = statement.executeQuery())
            {
                if(resultSet.next())
                {
                    return new Patient(
                        resultSet.getString("CPR_number"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("email"),
                        resultSet.getString("password")
                    );
                }
                else {
                    throw new RuntimeException("No patient found");
                }
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException("Failed to fetch patient from SQL");
        }
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

    public synchronized String loginUser(String cprnumber, String password)
    {
        String sql = "SELET * FROM Patient WHERE password=? and CPR_number=?";
        try(PreparedStatement statement = database.getConnection().prepareStatement(sql))
        {
            statement.setString(1, password);
            statement.setString(2, cprnumber);
            try (ResultSet resultSet = statement.executeQuery())
            {
                if(resultSet.next())
                {
                    return "Patient logged in successfully";
                }
                else {
                    throw new RuntimeException("No credentials found");
                }
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException("Failed to fetch patient from SQL");
        }
    }
}