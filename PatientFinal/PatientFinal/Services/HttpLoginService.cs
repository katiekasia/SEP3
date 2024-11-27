using System.Net.Http.Json;
using System.Text.Json;
using PatientFinal.DTOs;

namespace PatientFinal.Services
{
    public class HttpLoginService : ILoginService
    {
        private readonly HttpClient client;

        public HttpLoginService(HttpClient client)
        {
            this.client = client;
        }

        public async Task<ResponseDto> LoginPatient(LoginDto request)
        {
            try
            {
                HttpResponseMessage httpResponseMessage = await client.PostAsJsonAsync("http://localhost:8081/Demo/login", request);
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
                Console.WriteLine(ex.Message);
                throw;
            }
        }
    }
}