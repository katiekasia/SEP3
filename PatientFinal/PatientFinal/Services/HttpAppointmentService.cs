using PatientFinal.DTOs;
using System.Net.Http.Json;
using System.Text.Json;

namespace PatientFinal.Services
{
    public class HttpAppointmentService : IAppointmentService
    {
        private readonly HttpClient client;
        private readonly string baseUrl = "http://localhost:8081";

        public HttpAppointmentService(HttpClient client)
        {
            this.client = client;
        }

        public async Task<ResponseDto> CreateAppointment(
            CreateAppointmentDto createAppointmentDto)
        {
            try
            {
                var httpResponse =
                    await client.PostAsJsonAsync($"{baseUrl}/Demo/book",
                        createAppointmentDto);
                var response = await httpResponse.Content.ReadAsStringAsync();

                if (!httpResponse.IsSuccessStatusCode)
                    throw new Exception(response);

                return JsonSerializer.Deserialize<ResponseDto>(response,
                    new JsonSerializerOptions
                        { PropertyNameCaseInsensitive = true });
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error creating appointment: {ex.Message}");
                throw;
            }
        }

        public async Task<List<GetAppointmentsDto>> GetAppointments(
            string patientCpr)
        {
            try
            {
                var httpResponse =
                    await client.GetAsync(
                        $"{baseUrl}/Demo/appointments?cpr={patientCpr}");
                var response = await httpResponse.Content.ReadAsStringAsync();
                Console.WriteLine($"Raw response: {response}");

                if (!httpResponse.IsSuccessStatusCode)
                    throw new Exception(
                        $"Failed to get appointments: {response}");

                var responseDto = JsonSerializer.Deserialize<ResponseDto>(
                    response,
                    new JsonSerializerOptions
                    {
                        PropertyNameCaseInsensitive = true
                    });

                return responseDto?.Appointments ??
                       new List<GetAppointmentsDto>();
            }
            catch (Exception ex)
            {
                Console.WriteLine(
                    $"Error retrieving appointments: {ex.Message}");
                throw;
            }
        }
    }


}