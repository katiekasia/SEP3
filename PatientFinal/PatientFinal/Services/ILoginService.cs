using PatientFinal.DTOs;

namespace PatientFinal.Services;

public interface ILoginService
{
    public Task<UserDto> LoginPatient(LoginDto request);

}