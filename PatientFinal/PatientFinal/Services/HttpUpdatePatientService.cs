using System.Net.Http.Json;
using System.Text.Json;
using PatientFinal.DTOs;

namespace PatientFinal.Services
{
    public class HttpUpdatePatientService : IUpdateService
    {
        private readonly HttpClient client;

        public HttpUpdatePatientService(HttpClient client)
        {
            this.client = client;
        }
      
        public async Task<UpdatePatientDto> UpdatePatient(UpdatePatientDto updatePatientDto)
        {
            try
            {
                HttpResponseMessage httpResponseMessage = await client.PostAsJsonAsync
                    ($"http://localhost:8081/Demo/update", updatePatientDto);
           
                string response = await httpResponseMessage.Content.ReadAsStringAsync();
                if (!httpResponseMessage.IsSuccessStatusCode)
                    throw new ApplicationException(response);
            
                return JsonSerializer.Deserialize<UpdatePatientDto>(response, new JsonSerializerOptions
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
}