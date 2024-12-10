using System.Net.Http.Json;
using System.Text.Json;
using Doctor.DTOs;
using PatientFinal.DTOs;
using PatientFinal.Services;

namespace Doctor.Services;

public class HttpPrescriptionGetService : IPrescriptionGetService
{
    private readonly HttpClient client;
    private readonly string baseUrl = "http://localhost:8080";

    public HttpPrescriptionGetService(HttpClient client)
    {
        this.client = client;
    }
    
    public async Task<List<GetPrescriptionsDto>> GetPrescriptionsByPatientCpr(string patientCpr)
    {
        try
        {
            var httpResponse =
                await client.GetAsync($"{baseUrl}/Doctor/Prescriptions?cpr={patientCpr}");
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