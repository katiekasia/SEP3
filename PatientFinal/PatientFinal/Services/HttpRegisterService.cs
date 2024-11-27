using System.Net.Http.Json;
using System.Text.Json;
using PatientFinal.DTOs;

namespace PatientFinal.Services
{
    public class HttpRegisterService : IRegisterService
    {
        private readonly HttpClient client;

        public HttpRegisterService()
        {
            this.client = client;
        }

        public async Task<RegisterDto> RegisterPatient(RegisterDto request)
        {
            try
            {
                HttpResponseMessage httpResponseMessage = await client.PostAsJsonAsync("api/Demo/register", request);
                string response = await httpResponseMessage.Content.ReadAsStringAsync();
                if (!httpResponseMessage.IsSuccessStatusCode)
                    throw new ApplicationException(response);

                return JsonSerializer.Deserialize<RegisterDto>(response, new JsonSerializerOptions
                {
                    PropertyNameCaseInsensitive = true
                });
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
                throw;
            }
        }
    }
}