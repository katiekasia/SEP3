using System.Net.Http.Json;
using System.Text.Json;
using Patient.DTOs;

namespace Patient.Services
{
    public class HttpRegisterService : IRegisterService
    {
        private readonly HttpClient client;
        private readonly string baseUrl = "http://localhost:8081";

        public HttpRegisterService(HttpClient client)
        {
            this.client = client;
        }

        public async Task<ResponseDto> RegisterPatient(RegisterDto request)
        {
            try
            {
                HttpResponseMessage httpResponseMessage = await client.PostAsJsonAsync($"{baseUrl}/Booking/register", request);
                string response = await httpResponseMessage.Content.ReadAsStringAsync();
                if (!httpResponseMessage.IsSuccessStatusCode)
                    throw new ApplicationException(response);

                return JsonSerializer.Deserialize<ResponseDto>(response, new JsonSerializerOptions
                {
                    PropertyNameCaseInsensitive = true
                });
            }
            catch (Exception ex)
            {
                
                throw ex;
            }
        }
    }
}