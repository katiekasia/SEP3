package via.pro3.mainserver.Model;

import DTOs.LoginDto;
import DTOs.RegisterDto;

public interface Model
{
    public void registerPatient(RegisterDto registerDto);
    public void loginPatient(LoginDto loginDto);
}
