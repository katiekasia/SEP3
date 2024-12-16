package via.pro3.mainserver.database;

import via.pro3.mainserver.DTOs.*;
import via.pro3.mainserver.Model.Appointment;
import via.pro3.mainserver.Model.Clinic;
import via.pro3.mainserver.Model.Doctor;
import via.pro3.mainserver.Model.Patient;
import via.pro3.mainserver.Model.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;
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
    public List<GetPrescriptionsDto> getPrescriptionsByPatientCpr(String patientCpr, int page)
    {
        int pageSize = 10;
        // Calculate offset
        int offset = (page - 1) * pageSize;
        // SQL query with LIMIT and OFFSET for pagination
        String sql = """
                
            SELECT p.id, p.diagnosis, p.medication, p.recommendations, p.date,
                                       p.time, p.patient_CPR, p.doctor_id, d.first_name AS doctor_name, d.last_name AS doctor_surname
                                FROM prescription p
                                INNER JOIN patient pat ON pat.CPR_number = p.patient_CPR
                                LEFT JOIN doctor d ON p.doctor_id = d.id
                                WHERE p.patient_CPR = ?
                                ORDER BY p.date DESC
                                LIMIT ? OFFSET ?;
                """;

        try (Connection connection = database.getConnection(); // Get connection from pool
            PreparedStatement statement = connection.prepareStatement(sql)) {

            List<GetPrescriptionsDto> prescriptions = new ArrayList<>();

            // Set query parameters
            statement.setString(1, patientCpr);
            statement.setInt(2, pageSize);  // Number of prescriptions per page
            statement.setInt(3, offset);    // Calculate the offset for the current page

            try (ResultSet resultSet = statement.executeQuery()) {
              while (resultSet.next()) {
                prescriptions.add(new GetPrescriptionsDto(
                    resultSet.getInt("id"),
                    resultSet.getString("diagnosis"),
                    resultSet.getString("medication"),
                    resultSet.getString("recommendations"),
                    resultSet.getString("date"),
                    resultSet.getString("time"),
                    resultSet.getString("patient_CPR"),
                    resultSet.getString("doctor_id"),
                    resultSet.getString("doctor_name"),   // Directly from JOIN
                    resultSet.getString("doctor_surname") // Directly from JOIN
                ));
                }
                return prescriptions;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch prescriptions: " + patientCpr, e);
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

            statement.setInt(1, request.getId());
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
                    return  getDoctorById(resultSet.getString("doctor_id"));

                }
                throw new RuntimeException("No doctor found for appointment: " + appointmentId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch doctor : " + e.getMessage(), e);
        }

    }

    @Override public Set<Integer> getPrescriptionIds()
    {
        Set<Integer> set = new HashSet<>();
        String sql = "SELECT id AS id FROM prescription";

        try (Connection connection = database.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql))
        {
            try (ResultSet resultSet = statement.executeQuery())
            {
                while (resultSet.next())
                {
               set.add(resultSet.getInt("id"));

                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(
                "Failed to fetch appointment id : " + e.getMessage(), e);
        }

        return set;
    }

    @Override public Set<Integer> getAppointmentIds()
    {
        Set<Integer> set = new HashSet<>();
        String sql = "SELECT id AS id FROM appointment";

        try (Connection connection = database.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql))
        {
            try (ResultSet resultSet = statement.executeQuery())
            {
                while (resultSet.next())
                {
                 set.add(resultSet.getInt("id"));
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(
                "Failed to fetch prescriptions id : " + e.getMessage(), e);
        }

        return set;
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
        String sql = "UPDATE doctor SET password = ? WHERE id = ?";
        try(PreparedStatement statement = database.getConnection().prepareStatement(sql)){
            statement.setString(1, request.getNewPassword());
            statement.setString(2, request.getId());
            statement.executeUpdate();
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

            statement.setString(1, doctorId);
            try (ResultSet rs = statement.executeQuery())
            {
                while (rs.next())
                {
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
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
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
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
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
          AND a.status IN ('Active', 'Cancelled')
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

                    appointments.add(appointment);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving appointments: " + e.getMessage(), e);
        }

        return appointments;
    }

    @Override public DaysDTO getDoctorsAvailibility(String doctorId)
    {
        List<DayDTO> days = new ArrayList<>();
        DaysDTO daysDTO = new DaysDTO();
        daysDTO.setDays(days);
        String sql = """
            SELECT
            a.date,
            a.time
            FROM appointment a 
            WHERE a.doctor_id = ?
            ORDER BY a.date DESC, a.time ASC""";
        try(Connection connection = database.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setString(1, doctorId);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    Date date = rs.getDate("date");
                    if (!daysDTO.alreadyHas(date)) {
                        DayDTO day = new DayDTO(date);
                        daysDTO.add(day);
                    }
                   DayDTO dto = daysDTO.getDay(date);
                    dto.check(rs.getTime("time"));
                }
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }

         return daysDTO;
    }

    @Override
    public int getAppointmentsCount(String cpr) {
        int count = 0;
        // SQL query to count appointments for the given CPR
        String sql = """
        SELECT COUNT(*)
        FROM (
            SELECT 1
            FROM appointment a
            WHERE a.patient_CPR = ?
              AND a.status = 'Active'
            ORDER BY a.date DESC, a.time ASC
            LIMIT 5
        ) AS limited_results
    """;

        try (Connection connection = database.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            // Set the CPR in the prepared statement
            statement.setString(1, cpr);

            // Execute the query and retrieve the count
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    count = rs.getInt(1); // Get the count from the query result
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Return the final count of appointments for the given CPR
        return count;
    }
    public int getPrescriptionCount(String cpr) {
        int count = 0;
        // SQL query to count prescriptions for the given CPR
        String sql = """
        SELECT COUNT(*)
        FROM prescription p
        WHERE p.patient_CPR = ?
    """;

        try (Connection connection = database.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            // Set the CPR in the prepared statement
            statement.setString(1, cpr);

            // Execute the query and retrieve the count
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {

                    count = rs.getInt(1); // Get the count from the query result
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Return the final count of appointments for the given CPR
        return count;
    }

    @Override public void updateAppointment(int appointmentId,
        String newStatus)
    {
        String sql = """
            UPDATE appointment
            SET status = ?
            WHERE id = ?
            """;

        try (Connection connection = database.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            // Set the parameters for the query
            statement.setString(1, newStatus);
            statement.setInt(2, appointmentId);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

            throw new RuntimeException("Error updating appointment status", e);
        }
    }
}
