using PatientFinal.DTOs;

namespace PatientFinal.Services;

public interface ILoginService
{
    public Task<ResponseDto> LoginPatient(LoginDto request);

}