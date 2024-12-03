using PatientFinal.DTOs;

namespace PatientFinal.Services;

public interface IRegisterService
{
    public Task<ResponseDto> RegisterPatient(RegisterDto request);
}