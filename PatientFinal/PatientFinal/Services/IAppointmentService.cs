using PatientFinal.DTOs;

namespace PatientFinal.Services;

public interface IAppointmentService
{

    public Task<ResponseDto> CreateAppointment(CreateAppointmentDto request);
    public Task<List<CityDto>> GetCities();
    public Task<List<ClinicDto>> GetClinicByCity(string code);
    
    public Task<List<DoctorDto>> GetDoctorsByClinic(string id_clinic);
}