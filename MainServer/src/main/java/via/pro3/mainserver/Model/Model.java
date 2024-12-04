package via.pro3.mainserver.Model;

import via.pro3.mainserver.DTOs.*;

import java.util.List;

public interface Model
{
   String createAppointment(CreateAppointmentDto createAppointmentDto);
   Patient getPatientByCpr(String cpr);
  Doctor getDoctorById(String id);
  void registerPatient(RegisterDto registerDto);
  Doctor loginDoctor(LoginDto loginDto);
  Patient loginPatient(LoginDto loginDto);
  String changeDoctorPassword(ResetPasswordDto resetPasswordDto);
  List<Appointment> getPatientAppointments(String cpr);
  String getDoctorByClinicName(String clinicName);
  String updatePatient(UpdatePatientDto updatePatientDto);

  List<Appointment> getDoctorAppointments(String id);
  Patient getPatientByAppointmentId(int appointmentId);


}
