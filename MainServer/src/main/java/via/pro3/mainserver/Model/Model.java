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
  String loginDoctor(LoginDto loginDto);
  Patient loginPatient(LoginDto loginDto);
  String changeDoctorPassword(ResetPasswordDto resetPasswordDto);
  void addPrescription(PrescriptionDto prescriptionDto);


}
