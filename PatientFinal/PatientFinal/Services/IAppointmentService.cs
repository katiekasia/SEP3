using PatientFinal.DTOs;

namespace PatientFinal.Services;

public interface IAppointmentService
{

    public Task<ResponseDto> CreateAppointment(CreateAppointmentDto request);
}