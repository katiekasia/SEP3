package via.pro3.mainserver.Model;

import via.pro3.mainserver.DTOs.CreateAppointmentDto;
import via.pro3.mainserver.DTOs.LoginDto;
import via.pro3.mainserver.DTOs.RegisterDto;

public interface Model
{
   void createAppointment(CreateAppointmentDto createAppointmentDto);
   Patient getPatientByCpr(String cpr);
  Doctor getDoctorById(String id);
  void registerPatient(RegisterDto registerDto);
  void loginPatient(LoginDto loginDto);

}
