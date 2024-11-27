using PatientFinal.DTOs;

namespace PatientFinal.Services;

public interface ILoginService
{
    public Task<LoginDto> LoginPatient(LoginDto request);

}