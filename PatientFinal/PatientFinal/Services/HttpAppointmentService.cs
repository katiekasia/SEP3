using PatientFinal.DTOs;
using System.Net.Http.Json;
using System.Text.Json;

namespace PatientFinal.Services
{
    public class HttpAppointmentService : IAppointmentService
    {
        private readonly HttpClient client;

        public HttpAppointmentService(HttpClient client)
        {
            this.client = client;
        }

      
        public async Task<ResponseDto> CreateAppointment(
            CreateAppointmentDto createAppointmentDto)
        {
            try
            {
                HttpResponseMessage httpResponse =
                    await client.PostAsJsonAsync("http://localhost:8081/Demo/book",
                        createAppointmentDto);
                string response =
                    await httpResponse.Content.ReadAsStringAsync();
                if (!httpResponse.IsSuccessStatusCode)
                    throw new Exception(response);
                Console.WriteLine(response);
                return JsonSerializer.Deserialize<ResponseDto>(response,
                    new JsonSerializerOptions { PropertyNameCaseInsensitive = true });

            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error occurred: {ex.Message}");
                throw;
            }
        }
        
    }
}