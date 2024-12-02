package via.pro3.mainserver.Model;

import via.pro3.mainserver.DTOs.CreateAppointmentDto;
import via.pro3.mainserver.DTOs.LoginDto;
import via.pro3.mainserver.DTOs.RegisterDto;
import via.pro3.mainserver.DTOs.UserDto;

public interface Model
{
   String createAppointment(CreateAppointmentDto createAppointmentDto);
   Patient getPatientByCpr(String cpr);
  Doctor getDoctorById(String id);
  void registerPatient(RegisterDto registerDto);
  String loginDoctor(LoginDto loginDto);
  UserDto loginPatient(LoginDto loginDto);


}
