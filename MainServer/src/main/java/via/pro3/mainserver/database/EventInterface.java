package via.pro3.mainserver.database;

import via.pro3.mainserver.DTOs.*;
import via.pro3.mainserver.Model.*;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface EventInterface
{
  void createAppointment(Appointment appointment, Doctor doctor, Patient patient);

  void createUser(Patient patient);
  Doctor getDoctorById(String id);
  Patient getPatientByCpr(String cpr);
  List<Patient> getPatientsByDoctorId(String doctorid);
  Clinic getClinicByDoctorId(String id);
  boolean loginDoctor(LoginDto request);
  String changePassowrdDoctor(ResetPasswordDto request);
  boolean loginUser(LoginDto request);

  List<GetPrescriptionsDto> getPrescriptionsByPatientCpr(String patientCpr);
  List<Doctor> getDoctors();
  List<CityDto> getCities();
  List<Clinic> getClinicByCity(String code);
  List<Doctor> getDoctorsByClinic(String id_clinic);
  List<Appointment> getAppointmentsByPatientCpr(String patientCpr);
  List<Appointment> getAppointmentsByDoctorId(String doctorId);
  String getDoctorByClinicName(String clinicName);
  Patient getPatientByAppointmentId(int appointmentId);
  String updateUser(UpdatePatientDto request);
  void addPrescription(PrescriptionDto request);
  String cancelAppointment(int appointmentId);
  Appointment getAppointmentByAppointmentId(int appointmentId);
  Doctor getDoctorByAppointmentId(int appointmentId);
  int getPrescriptionCount();
  int getAppointmentCount();

  void updateAppointmentStatus(int appointmentId, String newStatus);
  void cancelAppointment(int appointmentId, String patientCpr);
}
