using PatientFinal.DTOs;

namespace PatientFinal.Services;

public interface IRegisterService
{
    public Task<RegisterDto> RegisterPatient(RegisterDto request);
}