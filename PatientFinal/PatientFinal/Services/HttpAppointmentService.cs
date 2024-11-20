using PatientFinal.DTOs;
using System.Net.Http.Json;
using System.Text.Json;

namespace PatientFinal.Services
{
    public class HttpAppointmentService : IAppointmentService
    {
        private readonly HttpClient client;

        public HttpAppointmentService()
        {
            this.client = client;
        }

        public async Task<CreateAppointmentDto> CreateAppointment(CreateAppointmentDto createAppointmentDto)
        {
            try
            {
                HttpResponseMessage httpResponse = await client.PostAsJsonAsync("api/Demo/book", createAppointmentDto);
                string response = await httpResponse.Content.ReadAsStringAsync();
                if (!httpResponse.IsSuccessStatusCode)
                    throw new Exception(response);

                return JsonSerializer.Deserialize<CreateAppointmentDto>(response, new JsonSerializerOptions
                    {
                        PropertyNameCaseInsensitive = true
                    });
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error occurred: {ex.Message}");
                throw;
            }
        }
    }
}