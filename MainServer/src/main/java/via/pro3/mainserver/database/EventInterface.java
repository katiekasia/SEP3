package via.pro3.mainserver.database;

import via.pro3.mainserver.DTOs.LoginDto;
import via.pro3.mainserver.DTOs.PrescriptionDto;
import via.pro3.mainserver.DTOs.ResetPasswordDto;
import via.pro3.mainserver.Model.Appointment;
import via.pro3.mainserver.Model.Clinic;
import via.pro3.mainserver.Model.Doctor;
import via.pro3.mainserver.Model.Patient;

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
  String loginDoctor(LoginDto request);
  String changePassowrdDoctor(ResetPasswordDto request);
  boolean loginUser(LoginDto request);
  void addPrescription(PrescriptionDto request);
}
