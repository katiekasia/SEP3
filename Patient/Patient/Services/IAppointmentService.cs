using Patient.DTOs;

namespace Patient.Services;

public interface IAppointmentService
{

    public Task<ResponseDto> CreateAppointment(CreateAppointmentDto request);
    Task<List<GetAppointmentsDto>> GetAppointments(string patientCpr);

    public Task<List<CityDto>> GetCities();
    public Task<List<ClinicDto>> GetClinicByCity(string code);
    
    public Task<List<DoctorDto>> GetDoctorsByClinic(string id_clinic);

    public Task<bool> CancelAppointment(int appointmentId, string patientCpr);

}