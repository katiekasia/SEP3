package via.pro3.mainserver.Model;

import via.pro3.mainserver.DTOs.*;

import java.util.List;

public interface Model
{
   String createAppointment(CreateAppointmentDto createAppointmentDto);
   Patient getPatientByCpr(String cpr);
   List<Patient> getPatientsByDoctorId(String doctorid);
  Doctor getDoctorById(String id);
  void registerPatient(RegisterDto registerDto);
  Doctor loginDoctor(LoginDto loginDto);
  Patient loginPatient(LoginDto loginDto);
  String changeDoctorPassword(ResetPasswordDto resetPasswordDto);

  List<GetPrescriptionsDto> getPrescriptionsByPatientCpr(String patientCpr);

  List<CityDto> getCities();
  List<Clinic> getClinicByCity(String code);
  List<Doctor> getDoctorByClinic(String id_clinic);


  String updatePatient(UpdatePatientDto updatePatientDto);

  List<Appointment> getDoctorAppointments(String id);
  Patient getPatientByAppointmentId(int appointmentId);
  void addPrescription(PrescriptionDto prescriptionDto);
  Appointment getAppointmentByAppointmentId(int appointmentId);

  void cancelAppointment(int appointmentId, String patientCpr);
  String cancelAppointment(int appointmentId);
  List<Appointment> getPatientAppointments(String cpr);
  String getDoctorByClinicName(String clinicName);
}
