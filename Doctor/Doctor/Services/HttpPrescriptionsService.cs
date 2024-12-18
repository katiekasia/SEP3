using System.Net.Http;
using System.Net.Http.Json;
using System.Text.Json;
using Doctor.DTOs;
using PatientFinal.DTOs;

namespace Doctor.Services;

public class HttpPrescriptionsService : IPrescriptionsService
{
    private readonly HttpClient client;

    public HttpPrescriptionsService(HttpClient client)
    {
        this.client = client;
    }

    public async Task<List<PatientDto>> GetPatientsByDoctorId(string doctorid)
    {
        try
        {
            HttpResponseMessage httpResponseMessage = await client.GetAsync(
                $"http://localhost:8080/Doctor/AddPrescriptions/getPatients?doctorid={Uri.EscapeDataString(doctorid)}");
            var content = await httpResponseMessage.Content.ReadAsStringAsync();

            if (!httpResponseMessage.IsSuccessStatusCode)
                throw new ApplicationException(content);
            
            var patients = JsonSerializer.Deserialize<List<PatientDto>>(content, new JsonSerializerOptions
            {
                PropertyNameCaseInsensitive = true
            });

            return patients ?? new List<PatientDto>();
        }
        catch (Exception ex)
        {

            throw ex;
        }
    }

    public async Task<ResponseDto> AddPrescription(PrescriptionDto prescription)
    {
        try
        {
            HttpResponseMessage httpResponseMessage =
                await client.PostAsJsonAsync("http://localhost:8080/Doctor/AddPrescriptions/addPrescription",
                    prescription);
            var content = await httpResponseMessage.Content.ReadAsStringAsync();

            if (!httpResponseMessage.IsSuccessStatusCode)
                throw new ApplicationException(content);

            return JsonSerializer.Deserialize<ResponseDto>(content, new JsonSerializerOptions
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