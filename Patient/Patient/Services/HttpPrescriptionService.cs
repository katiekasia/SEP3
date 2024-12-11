using System.Text.Json;
using Patient.DTOs;

namespace Patient.Services;

public class HttpPrescriptionService : IPrescriptionService
{
    private readonly HttpClient client;
    private readonly string baseUrl = "http://localhost:8081";

    public HttpPrescriptionService(HttpClient client)
    {
        this.client = client;
    }
    public async Task<int> GetPrescriptionCount(string cpr)
    {
        try
        {
            var httpResponse = await client.GetAsync($"{baseUrl}/Booking/count?cpr={cpr}");
            var response = await httpResponse.Content.ReadAsStringAsync();
               
            if (!httpResponse.IsSuccessStatusCode)
                throw new Exception(response);

            return JsonSerializer.Deserialize<int>(response,
                new JsonSerializerOptions
                    { PropertyNameCaseInsensitive = true });
        }
        catch (Exception ex)
        {
            
            throw ex;
        }
    }
    public async Task<List<GetPrescriptionsDto>> GetPrescriptionsByPatientCpr(string patientCpr, int page)
    {
        try
        {
            var httpResponse =
                await client.GetAsync($"{baseUrl}/Booking/Prescriptions?cpr={patientCpr}&page={page}");
            var response = await httpResponse.Content.ReadAsStringAsync();

            if (!httpResponse.IsSuccessStatusCode)
                throw new Exception(response);

            return JsonSerializer.Deserialize<List<GetPrescriptionsDto>>(response,
                new JsonSerializerOptions
                    { PropertyNameCaseInsensitive = true });
        }
        catch (Exception e)
        {
          
            throw e;
        }
    }
    
}