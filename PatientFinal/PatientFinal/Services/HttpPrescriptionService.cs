using System.Net.Http.Json;
using System.Text.Json;
using PatientFinal.DTOs;

namespace PatientFinal.Services;

public class HttpPrescriptionService : IPrescriptionService
{
    private readonly HttpClient client;
    private readonly string baseUrl = "http://localhost:8081";

    public HttpPrescriptionService(HttpClient client)
    {
        this.client = client;
    }
    
    public async Task<List<GetPrescriptionsDto>> GetPrescriptionsByPatientCpr(string patientCpr)
    {
        try
        {
            var httpResponse =
                await client.GetAsync($"{baseUrl}/Demo/Prescriptions?cpr={patientCpr}");
            var response = await httpResponse.Content.ReadAsStringAsync();

            if (!httpResponse.IsSuccessStatusCode)
                throw new Exception(response);

            return JsonSerializer.Deserialize<List<GetPrescriptionsDto>>(response,
                new JsonSerializerOptions
                    { PropertyNameCaseInsensitive = true });
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            throw;
        }
    }
}