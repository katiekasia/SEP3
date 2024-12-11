using Patient.DTOs;

namespace Patient.Services;

public interface ILoginService
{
    public Task<UserDto> LoginPatient(LoginDto request);

}