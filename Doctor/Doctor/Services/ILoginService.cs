using Doctor.DTOs;

namespace Doctor.Services;

public interface ILoginService
{
    public Task<LoginDto> LoginServiceMethod(LoginDto loginDto);
    public Task<ResetPasswordDto> ResetPasswordServiceMethod(ResetPasswordDto resetPasswordDto);
    public Task<DoctorDto> getDoctorById(string id);
}