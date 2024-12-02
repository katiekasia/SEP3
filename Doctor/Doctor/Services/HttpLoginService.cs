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
    
    public async Task<LoginDto> LoginServiceMethod(LoginDto loginDto, string endpoint)
    {
        try
        {
            HttpResponseMessage httpResponseMessage = await client.PostAsJsonAsync
                ($"http://localhost:8080/Doctor/{endpoint}", loginDto);
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
            Console.WriteLine(ex.Message);
            throw;
        }
    }
}