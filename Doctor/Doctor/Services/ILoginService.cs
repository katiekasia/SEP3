using Doctor.DTOs;

namespace Doctor.Services;

public interface ILoginService
{
    public Task<LoginDto> LoginDoctor(LoginDto loginDto);
}