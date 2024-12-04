using PatientFinal.DTOs;

namespace PatientFinal.Services;

public interface IAppointmentService
{

    public Task<ResponseDto> CreateAppointment(CreateAppointmentDto request);
    Task<List<GetAppointmentsDto>> GetAppointments(string patientCpr);
}