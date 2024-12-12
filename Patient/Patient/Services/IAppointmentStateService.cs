using Patient.DTOs;

namespace Patient.Services;

public interface IAppointmentStateService
{
    bool IsInitialized { get; }
    List<GetAppointmentsDto> Appointments { get; }

    void SetAppointments(List<GetAppointmentsDto> appointments);
    void ClearAppointments();
}