using Patient.DTOs;

namespace Patient.Services;

public interface IRegisterService
{
    public Task<ResponseDto> RegisterPatient(RegisterDto request);
}