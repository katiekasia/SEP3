package via.pro3.mainserver.Model;

import via.pro3.mainserver.DTOs.CreateAppointmentDto;

public interface Model
{
   void createAppointment(CreateAppointmentDto createAppointmentDto);
   Patient getPatientByCpr(String cpr);
  Doctor getDoctorById(String id);

}
