using PatientFinal.DTOs;

namespace PatientFinal.Services;

public interface IAppointmentService
{

    public Task<CreateAppointmentDto> CreateAppointment(CreateAppointmentDto request);
}