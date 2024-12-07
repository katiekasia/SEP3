package via.pro3.mainserver.database;

import via.pro3.mainserver.DTOs.CityDto;
import via.pro3.mainserver.DTOs.DoctorDto;
import via.pro3.mainserver.DTOs.LoginDto;
import via.pro3.mainserver.DTOs.ResetPasswordDto;
import via.pro3.mainserver.Model.Appointment;
import via.pro3.mainserver.Model.Clinic;
import via.pro3.mainserver.Model.Doctor;
import via.pro3.mainserver.Model.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventRepository implements EventInterface {
    private final DatabaseInterface database;

    public EventRepository(DatabaseInterface database) {
        this.database = database;
    }

    @Override
    public void createAppointment(Appointment appointment, Doctor doctor, Patient patient) {
        String sql = "INSERT INTO Appointment (id, description, type, date, time, status, patient_CPR, doctor_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = database.getConnection(); // Get connection from pool
            PreparedStatement statement = connection.prepareStatement(sql)) {

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
    public Clinic getClinicByDoctorId(String doctorId) {
        String sql = """
        SELECT c.id, c.name, c.street, c.street_number, c.city_PO_code, city.city_name
        FROM clinic c
        INNER JOIN doctor d ON c.id = d.clinic_id
        INNER JOIN city ON c.city_PO_code = city.postal_code
        WHERE d.id = ?""";

        System.out.println("Fetching clinic for doctorId: " + doctorId); // Debugging log


        try (Connection connection = database.getConnection(); // Get connection from pool
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, doctorId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Clinic(
                        resultSet.getString("id"),
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
        // Remove any surrounding quotes
        doctorId = doctorId.trim().replaceAll("^\"|\"$", "");

        String sql = "SELECT * FROM doctor WHERE id = ?";
        try (PreparedStatement statement = database.getConnection().prepareStatement(sql)) {
            statement.setString(1, doctorId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Doctor(
                            resultSet.getString("id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                        resultSet.getString("phone_number"),
                            resultSet.getString("password"),
                            resultSet.getString("clinic_id"),
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
    public Patient getPatientByCpr(String patientCpr) {
        String sql = "SELECT * FROM Patient WHERE CPR_number = ?";

        try (Connection connection = database.getConnection(); // Get connection from pool
            PreparedStatement statement = connection.prepareStatement(sql)) {

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

    @Override
    public void createUser(Patient patient) {
        String sql = "INSERT INTO patient (cpr_number, first_name, last_name, phone_number, email, password) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = database.getConnection(); // Get connection from pool
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, patient.getCPRNo());
            statement.setString(2, patient.getName());
            statement.setString(3, patient.getSurname());
            statement.setString(4, patient.getPhone());
            statement.setString(5, patient.getEmail());
            statement.setString(6, patient.getPassword());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create patient: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean loginUser(LoginDto request) {
        String sql = "SELECT * FROM patient WHERE CPR_number = ?";

        try (Connection connection = database.getConnection(); // Get connection from pool
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, request.getcpr());

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next(); // Returns true if patient found
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch patient from SQL: " + e.getMessage(), e);
        }
    }

    @Override
    public String loginDoctor(LoginDto request) {
        String sql = "SELECT * FROM doctor WHERE id = ? AND password =?";

        try (Connection connection = database.getConnection(); // Get connection from pool
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, request.getcpr());
            statement.setString(2, request.getPassword());

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next() ? "LoggedIn" : "Nope";
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch doctor from SQL: " + e.getMessage(), e);
        }
    }

    @Override
    public String changePassowrdDoctor(ResetPasswordDto request) {
        System.out.println(request.getId());
        System.out.println(request.getCurrentPassword());
        System.out.println(request.getNewPassword());
        String sql = "UPDATE doctor SET password = ? WHERE password = ? AND id = ?";
        try(PreparedStatement statement = database.getConnection().prepareStatement(sql)){
            statement.setString(1, request.getNewPassword());
            statement.setString(2, request.getCurrentPassword());
            statement.setString(3, request.getId());
            statement.executeUpdate();
            System.out.println("Exectued");
            return "PasswordChanged";
        } catch (SQLException e) {
            throw new RuntimeException("Failed to change doctor password: " + e.getMessage(), e);
        }
    }


    @Override
    public List<Doctor> getDoctors() {
        String sql = "SELECT id, first_name, last_name, phone_number, specialisation, clinic_id FROM doctor";
        List<Doctor> doctors = new ArrayList<>();

        try (PreparedStatement statement = database.getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Doctor doctor = new Doctor(
                resultSet.getString("id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                    resultSet.getString("password"),
                    resultSet.getString("email"),
                resultSet.getString("phone_number"),
                resultSet.getString("specialisation"),
                getClinicByDoctorId(resultSet.getString("id")));
                doctors.add(doctor);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve doctors: " + e.getMessage(), e);
        }
        return doctors;


    }

    @Override
    public List<CityDto> getCities() {
        String sql = "SELECT postal_code, city_name " +
            "FROM city " +
            "GROUP BY postal_code, city_name " +
            "HAVING COUNT(postal_code) = 1";
        List<CityDto> cities = new ArrayList<>();

        try (PreparedStatement statement = database.getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()) {
           System.out.println("Database Cities");
            while (resultSet.next()) {
                CityDto city = new CityDto(
                    resultSet.getString("city_name"),
                    resultSet.getString("postal_code")
                );
                cities.add(city);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve cities: " + e.getMessage(), e);
        }
        return cities;
    }


    @Override
    public List<Clinic> getClinicByCity(String code) {
        String sql = "SELECT c.name, c.id, ci.city_name,  c.street, c.street_number " +
            "FROM clinic c " +
            "JOIN city ci ON c.city_PO_code = ci.postal_code " +
            "WHERE ci.postal_code = ?";

        List<Clinic> clinics = new ArrayList<>();

        try (PreparedStatement statement = database.getConnection().prepareStatement(sql);) {
            statement.setString(1, code);
            System.out.println("Database Clinics");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println("Clinic found");
                Clinic clinic = new Clinic(
                    resultSet.getString("id"),
                    resultSet.getString("name"),
                    resultSet.getString("city_name"),
                    resultSet.getString("street"),
                    resultSet.getString("street_number")
                );

                clinics.add(clinic);

            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve clinics: " + e.getMessage(), e);
        }
        return clinics;
    }

    @Override
    public List<Doctor> getDoctorsByClinic(String id_clinic) {
        String sql = "SELECT d.id, d.first_name, d.last_name, d.phone_number,  d.email, d.password, d.specialisation, d.clinic_id,  c.id "
            + "FROM doctor d "
            + "JOIN clinic c ON c.id = d.clinic_id "
            + "WHERE c.id = ?";

        List<Doctor> doctors = new ArrayList<>();

        try (PreparedStatement statement = database.getConnection().prepareStatement(sql);) {
            statement.setString(1, id_clinic);
            System.out.println("Database Doctors");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println("Doctor found");
                Doctor doctor = new Doctor(
                    resultSet.getString(1),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("phone_number"),
                    resultSet.getString("email"),
                    resultSet.getString("password"),
                    resultSet.getString("specialisation"),
                    getClinicByDoctorId(resultSet.getString(1))
                );

                doctors.add(doctor);

            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve clinics: " + e.getMessage(), e);
        }
        return doctors;
    }





}
