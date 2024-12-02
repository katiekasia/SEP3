using Doctor.DTOs;

namespace Doctor.Services;

public interface ILoginService
{
    public Task<LoginDto> LoginServiceMethod(LoginDto loginDto, string endpoint);
}