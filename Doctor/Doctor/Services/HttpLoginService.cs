using System.Net.Http.Json;
using System.Text.Json;
using Doctor.DTOs;

namespace Doctor.Services;

public class HttpLoginService: ILoginService
{
    private readonly HttpClient client;

    public HttpLoginService(HttpClient client)
    {
        this.client = client;
    }
    
    public async Task<LoginDto> LoginServiceMethod(LoginDto loginDto)
    {
        try
        {
            HttpResponseMessage httpResponseMessage = await client.PostAsJsonAsync
                ($"http://localhost:8080/Doctor/login", loginDto);
            string response = await httpResponseMessage.Content.ReadAsStringAsync();
            if (!httpResponseMessage.IsSuccessStatusCode)
                throw new ApplicationException(response);
            
            return JsonSerializer.Deserialize<LoginDto>(response, new JsonSerializerOptions
            {
                PropertyNameCaseInsensitive = true
            })!; 
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }

    public async Task<ResetPasswordDto> ResetPasswordServiceMethod(ResetPasswordDto resetPasswordDto)
    {
        try
        {
            HttpResponseMessage httpResponseMessage = await client.PostAsJsonAsync
                ($"http://localhost:8080/Doctor/resetPassword", resetPasswordDto);
            string response = await httpResponseMessage.Content.ReadAsStringAsync();
            if (!httpResponseMessage.IsSuccessStatusCode)
                throw new ApplicationException(response);
            
            return JsonSerializer.Deserialize<ResetPasswordDto>(response, new JsonSerializerOptions
            {
                PropertyNameCaseInsensitive = true
            })!; 
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }

    public async Task<DoctorDto> getDoctorById(string id)
    {
        try
        {
            HttpResponseMessage httpResponseMessage = await client.PostAsJsonAsync
                ($"http://localhost:8080/Doctor/getDoctorById", id);
            string response = await httpResponseMessage.Content.ReadAsStringAsync();
            if (!httpResponseMessage.IsSuccessStatusCode)
                throw new ApplicationException(response);
            
            return JsonSerializer.Deserialize<DoctorDto>(response, new JsonSerializerOptions
            {
                PropertyNameCaseInsensitive = true
            })!;
        }
        catch (Exception ex)
        {

            throw ex;
        }
    }
}