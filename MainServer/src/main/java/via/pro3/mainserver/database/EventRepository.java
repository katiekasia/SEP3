package via.pro3.mainserver.database;

import via.pro3.mainserver.DTOs.CityDto;
import via.pro3.mainserver.DTOs.DoctorDto;
import via.pro3.mainserver.DTOs.LoginDto;
import via.pro3.mainserver.DTOs.PrescriptionDto;
import via.pro3.mainserver.DTOs.ResetPasswordDto;
import via.pro3.mainserver.DTOs.UpdatePatientDto;
import via.pro3.mainserver.Model.Appointment;
import via.pro3.mainserver.Model.Clinic;
import via.pro3.mainserver.Model.Doctor;
import via.pro3.mainserver.Model.Patient;
import via.pro3.mainserver.Model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
                            resultSet.getString("email"),
                            resultSet.getString("password"),
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

        try (Connection connection = database.getConnection();
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
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch patient from SQL: " + e.getMessage(), e);
        }
    }


    @Override
    public List<Patient> getPatientsByDoctorId(String doctorId) {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT DISTINCT p.* FROM patient p " +
                "JOIN appointment a ON p.cpr_number = a.patient_cpr " +
                "WHERE a.doctor_id = ?";

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, doctorId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Patient patient = new Patient();
                    patient.setName(resultSet.getString("first_name"));
                    patient.setSurname(resultSet.getString("last_name"));
                    patient.setCPRNo(resultSet.getString("cpr_number"));
                    patient.setEmail(resultSet.getString("email"));
                    patient.setPhone(resultSet.getString("phone_number"));

                    patients.add(patient);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch patients for doctor", e);
        }
        return patients;
    }

    @Override
    public void createUser(Patient patient) {
        String sql = "INSERT INTO patient (cpr_number, first_name, last_name, phone_number, email, password) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, patient.getCPRNo());
            statement.setString(2, patient.getName());
            statement.setString(3, patient.getSurname());
            statement.setString(4, patient.getPhone());
            statement.setString(5, patient.getEmail());
            statement.setString(6, patient.getPassword());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch patient from SQL: " + e.getMessage(), e);
        }
    }

    @Override
    public void addPrescription(PrescriptionDto request) {
        String sql = "INSERT INTO prescription (id, diagnosis, medication, recommendations, date, time, patient_CPR, doctor_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDateTime dateTime = LocalDateTime.parse(request.getDate(), formatter);

            statement.setString(1, request.getId());
            statement.setString(2, request.getDiagnosis());
            statement.setString(3, request.getMedication());
            statement.setString(4, request.getRecommendations());
            statement.setDate(5, Date.valueOf(dateTime.toLocalDate()));
            statement.setTime(6, Time.valueOf(dateTime.toLocalTime()));
            statement.setString(7, request.getPatientCpr());
            statement.setString(8, request.getDoctorId());
            statement.executeUpdate();
        } catch (DateTimeParseException | SQLException e) {
            throw new RuntimeException("Failed to create prescription: " + e.getMessage(), e);
        }
    }

    @Override public Appointment getAppointmentByAppointmentId(int appointmentId)
    {
        String sql = "SELECT * FROM appointment WHERE id = ?";
        System.out.println(appointmentId);
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setInt(1, appointmentId);

            try (ResultSet rs = statement.executeQuery())
            {
                if (rs.next())
                {

                    Clinic clinic = getClinicByDoctorId(
                            rs.getString("doctor_id"));

                    Appointment appointment = new Appointment(rs.getInt("id"),
                            clinic, rs.getString("type"),
                            new MyDateAndTime(rs.getDate("date").toLocalDate(),
                                    rs.getTime("time").toLocalTime()),
                            rs.getString("description"), rs.getString("status"));
                    return appointment;
                }
            }

        }
        catch (SQLException e)
        {
            throw new RuntimeException(
                    "Failed to fetch doctor from SQL: " + e.getMessage(), e);
        }
        return null;
    }

    @Override public Doctor getDoctorByAppointmentId(int appointmentId)
    {
        String sql = """
        SELECT d.id AS doctor_id
        FROM doctor d
        INNER JOIN appointment a ON d.id = a.doctor_id
        WHERE a.id = ?
        LIMIT 1""";

        try (Connection connection = database.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, appointmentId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    System.out.println("patient success");
                    return  getDoctorById(resultSet.getString("doctor_id"));

                }
                throw new RuntimeException("No doctor found for appointment: " + appointmentId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch doctor : " + e.getMessage(), e);
        }
    }

    @Override
    public String cancelAppointment(int appointmentId) {
        String sql = "UPDATE appointment SET status = 'Cancelled' WHERE id = ?";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, appointmentId);
            statement.executeUpdate();
            return "Appointment cancelled";
        } catch (SQLException e) {
            throw new RuntimeException("Failed to cancel appointment: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean loginDoctor(LoginDto request) {
        String sql = "SELECT * FROM doctor WHERE id = ?";

        try (Connection connection = database.getConnection(); // Get connection from pool
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, request.getcpr());

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch doctor from SQL: " + e.getMessage(), e);
        }
    }

    @Override
    public String changePassowrdDoctor(ResetPasswordDto request) {
        System.out.println(request.getId());
        System.out.println(request.getNewPassword());
        String sql = "UPDATE doctor SET password = ? WHERE id = ?";
        try(PreparedStatement statement = database.getConnection().prepareStatement(sql)){
            statement.setString(1, request.getNewPassword());
            statement.setString(2, request.getId());
            statement.executeUpdate();
            System.out.println("Exectued");
            return "PasswordChanged";
        } catch (SQLException e) {
            throw new RuntimeException("Failed to change doctor password: " + e.getMessage(), e);
        }
    }
//    @Override
//    public List<Appointment> getAppointmentsByPatientCpr(String patientCpr) {
//        List<Appointment> appointments = new ArrayList<>();
//        String sql = """
//        SELECT
//            a.id,
//            a.description,
//            a.type,
//            a.date,
//            a.time,
//            a.status,
//            d.id AS doctor_id,
//            d.first_name AS doctor_first_name,
//            d.last_name AS doctor_last_name,
//            d.specialisation AS doctor_specialisation,
//            c.name AS clinic_name,
//            c.street AS clinic_street,
//            c.street_number AS clinic_street_number,
//            c.id AS clinic_id,
//            city.city_name AS clinic_city
//        FROM appointment a
//        INNER JOIN doctor d ON a.doctor_id = d.id
//        INNER JOIN clinic c ON d.clinic_id = c.id
//        INNER JOIN city ON c.city_PO_code = city.postal_code
//        WHERE a.patient_CPR = ?
//        ORDER BY a.date DESC, a.time ASC
//    """;
//
//        try (Connection connection = database.getConnection();
//            PreparedStatement statement = connection.prepareStatement(sql)) {
//
//            statement.setString(1, patientCpr);
//
//            try (ResultSet rs = statement.executeQuery()) {
//                while (rs.next()) {
//                    Clinic clinic = new Clinic(
//                        rs.getString("clinic_id"),
//                        rs.getString("clinic_name"),
//                        rs.getString("clinic_city"),
//                        rs.getString("clinic_street"),
//                        rs.getString("clinic_street_number")
//                    );
//
//                    Doctor doctor = new Doctor(
//                        rs.getString("doctor_id"),
//                        rs.getString("doctor_first_name"),
//                        rs.getString("doctor_last_name"),
//                        null, // password not needed
//                        null, // email not needed
//                        null,
//                        rs.getString("doctor_specialisation"),
//                        clinic
//                    );
//
//                    MyDateAndTime dateAndTime = new MyDateAndTime(
//                        rs.getDate("date").toLocalDate(),
//                        rs.getTime("time").toLocalTime()
//                    );
//
//                    Appointment appointment = new Appointment(
//                        rs.getInt("id"),
//                        clinic,
//                        rs.getString("type"),
//                        dateAndTime,
//                        rs.getString("description"),
//                        rs.getString("status")
//                    );
//
//                    appointments.add(appointment);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Error retrieving appointments: " + e.getMessage(), e);
//        }
//        return appointments;
//    }

    @Override public List<Appointment> getAppointmentsByDoctorId(
            String doctorId)
    {
        List<Appointment> appointments = new ArrayList<>();
        String sql = """
                SELECT
                a.id,
                a.description,
                a.type,
                a.date,
                a.time,
                a.status,
                p.CPR_number AS cpr,
                p.first_name AS patient_first_name,
                p.last_name AS patient_last_name,
                p.phone_number AS patient_phone,
                p.email AS patient_email, 
                c.name AS clinic_name,
                c.street AS clinic_street,
                c.street_number AS clinic_street_number,
                c.id AS clinic_id,
                city.city_name AS clinic_city
            FROM appointment a
            INNER JOIN patient p ON a.patient_CPR = p.CPR_number
            INNER JOIN doctor d ON a.doctor_id = d.id
            INNER JOIN clinic c ON d.clinic_id = c.id
            INNER JOIN city ON c.city_PO_code = city.postal_code
            WHERE a.doctor_id = ?
            ORDER BY a.date DESC, a.time ASC;
            """;

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            System.out.println("DATABASE called");

            statement.setString(1, doctorId);
            try (ResultSet rs = statement.executeQuery())
            {
                System.out.println("DATABASE executed");
                while (rs.next())
                {
                    System.out.println("found");
                    Clinic clinic = new Clinic(
                            rs.getString("clinic_id"),
                            rs.getString("clinic_name"),
                            rs.getString("clinic_city"), rs.getString("clinic_street"),
                            rs.getString("clinic_street_number"));

                    Patient patient = new Patient(rs.getString("cpr"),
                            rs.getString("patient_first_name"),
                            rs.getString("patient_last_name"), rs.getString("patient_phone"),
                            rs.getString("patient_email"),null // password not needed
                    );

                    MyDateAndTime dateAndTime = new MyDateAndTime(
                            rs.getDate("date").toLocalDate(),
                            rs.getTime("time").toLocalTime());

                    Appointment appointment = new Appointment(rs.getInt("id"), clinic,
                            rs.getString("type"), dateAndTime, rs.getString("description"),
                            rs.getString("status"));

                    appointments.add(appointment);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error retrieving appointments: " + e.getMessage(), e);
        }
        return appointments;
    }

    @Override
    public String getDoctorByClinicName(String clinicName) {
        String sql = """
        SELECT d.id 
        FROM doctor d
        INNER JOIN clinic c ON d.clinic_id = c.id
        WHERE c.name = ?
        LIMIT 1""";

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, clinicName);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("id");
                }
                throw new RuntimeException("No doctor found for clinic: " + clinicName);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch doctor ID: " + e.getMessage(), e);
        }
    }

    @Override
    public String updateUser(UpdatePatientDto request) {
        String updateSql = "UPDATE patient SET last_name = ?, phone_number = ?, email = ?, password = ? WHERE CPR_number = ?";

        try (Connection connection = database.getConnection();
             PreparedStatement updateStmt = connection.prepareStatement(updateSql)) {

            updateStmt.setString(1, request.getSurname());
            updateStmt.setString(2, request.getPhone());
            updateStmt.setString(3, request.getEmail());
            updateStmt.setString(4, request.getNewPassword());
            updateStmt.setString(5, request.getCPR());

            int rowsAffected = updateStmt.executeUpdate();
            return rowsAffected > 0 ? "User details updated successfully!" : "Failed to update user details!";
        } catch (SQLException e) {
            throw new RuntimeException("Error updating user details: " + e.getMessage(), e);
        }
    }

    @Override public Patient getPatientByAppointmentId(int appointmentId)
    {
        String sql = """
        SELECT p.CPR_number AS cpr
        FROM patient p
        INNER JOIN appointment a ON p.CPR_number = a.patient_CPR
        WHERE a.id = ?
        LIMIT 1""";

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, appointmentId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    System.out.println("patient success");
                    return  getPatientByCpr(resultSet.getString("cpr"));

                }
                throw new RuntimeException("No patient found for appointment: " + appointmentId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch patient : " + e.getMessage(), e);
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


    public void updateAppointmentStatus(int appointmentId, String newStatus) {
        String sql = "UPDATE appointment SET status = ? WHERE id = ?";

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, newStatus);
            statement.setInt(2, appointmentId);  // Changed to setInt
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Failed to update appointment status: " + e.getMessage(), e);
        }
    }
    public void cancelAppointment(int appointmentId, String patientCpr) {
        // Get all appointments for the patient
        List<Appointment> appointments = getAppointmentsByPatientCpr(patientCpr);

        // Find the specific appointment
        Appointment appointmentToCancel = appointments.stream()
                .filter(apt -> apt.getAppointmentId() == appointmentId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        // Check if appointment can be cancelled
        if (!appointmentToCancel.getStatus().equals("Active")) {
            throw new IllegalStateException("Only active appointments can be cancelled");
        }

        String sql = "UPDATE appointment SET status = 'Cancelled' WHERE id = ?";

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Cancel the appointment in memory
            appointmentToCancel.cancel();

            // Update the database using integer ID
            statement.setInt(1, appointmentId);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 0) {
                throw new RuntimeException("Failed to update appointment status in database");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Failed to cancel appointment: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Appointment> getAppointmentsByPatientCpr(String patientCpr) {
        List<Appointment> appointments = new ArrayList<>();
        String sql = """
        SELECT 
            a.id, 
            a.description, 
            a.type, 
            a.date, 
            a.time, 
            a.status,
            d.id AS doctor_id,
            d.first_name AS doctor_first_name,
            d.last_name AS doctor_last_name,
            d.specialisation AS doctor_specialisation,
            c.name AS clinic_name, 
            c.street AS clinic_street, 
            c.street_number AS clinic_street_number,
            c.id AS clinic_id,
            city.city_name AS clinic_city
        FROM appointment a
        INNER JOIN doctor d ON a.doctor_id = d.id
        INNER JOIN clinic c ON d.clinic_id = c.id
        INNER JOIN city ON c.city_PO_code = city.postal_code
        WHERE a.patient_CPR = ?
        ORDER BY a.date DESC, a.time ASC
    """;

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, patientCpr);

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    Clinic clinic = new Clinic(
                            rs.getString("clinic_id"),
                            rs.getString("clinic_name"),
                            rs.getString("clinic_city"),
                            rs.getString("clinic_street"),
                            rs.getString("clinic_street_number")
                    );

                    MyDateAndTime dateAndTime = new MyDateAndTime(
                            rs.getDate("date").toLocalDate(),
                            rs.getTime("time").toLocalTime()
                    );

                    int appointmentId = rs.getInt("id");

                    Appointment appointment = new Appointment(
                            appointmentId,
                            clinic,
                            rs.getString("type"),
                            dateAndTime,
                            rs.getString("description"),
                            rs.getString("status")
                    );
                    LocalDateTime appointmentDateTime = LocalDateTime.of(
                            appointment.getDate(),
                            appointment.getTime()
                    );
                    LocalDateTime now = LocalDateTime.now();

                    if (appointmentDateTime.isBefore(now) && appointment.getStatus().equals("Active")) {
                        appointment.expire();
                        updateAppointmentStatus(appointment.getAppointmentId(), "Expired");
                    }

                    appointments.add(appointment);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving appointments: " + e.getMessage(), e);
        }
        return appointments;
    }
}
