using System.Text.Json;
using Doctor.DTOs;
using PatientFinal.DTOs;

namespace Doctor.Services;

public class HttpAppointmentService : IAppointmentService
{
    private readonly HttpClient http;
    private readonly string baseUrl = "http://localhost:8080";

    public HttpAppointmentService(HttpClient http)
    {
        this.http = http;
    }
    
    public async Task<List<AppointmentDisplay>> GetAppointments(string doctorId)
    {
        try
        {
            var httpResponse =
                await http.GetAsync(
                    $"{baseUrl}/Doctor/appointments?id={doctorId}");
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

            List<AppointmentDisplay> displays = new List<AppointmentDisplay>();
            foreach (var appointment in responseDto.Appointments)
            {
                AppointmentDisplay display = new AppointmentDisplay()
                {
                    Id = appointment.Id,
                    Date = DateTime.Parse(appointment.Date),
                    Time = TimeOnly.Parse(appointment.Time),
                    status = appointment.Status,
                    type = appointment.Type
                };
                displays.Add(display);
            }
            return displays;
        }
        catch (Exception ex)
        {
            Console.WriteLine(
                $"Error retrieving appointments: {ex.Message}");
            throw;
        }
    }
}