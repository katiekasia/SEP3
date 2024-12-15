using Doctor.DTOs;
using PatientFinal.DTOs;

namespace Doctor.Services;

public interface IAppointmentService
{
    Task<List<AppointmentDisplay>> GetAppointments(string doctorId);
    Task<GetAppointmentsDto> GetAppointmentsDetails(string appointmentId);
    Task<ResponseDto> cancelAppointment(int appointmentId);
}