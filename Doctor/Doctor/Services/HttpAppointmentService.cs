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

            throw ex;
        }
    }

    public async Task<GetAppointmentsDto> GetAppointmentsDetails(string appointmentId)
    {
        try
        {
            var httpResponse =
                await http.GetAsync(
                    $"{baseUrl}/Doctor/appointment?appointmentId={appointmentId}");
            var response = await httpResponse.Content.ReadAsStringAsync();


            if (!httpResponse.IsSuccessStatusCode)
                throw new Exception(
                    $"Failed to get appointments: {response}");

            GetAppointmentsDto display = JsonSerializer.Deserialize<GetAppointmentsDto>(
                response,
                new JsonSerializerOptions
                {
                    PropertyNameCaseInsensitive = true
                }); 
            
            return display;
        }
        catch (Exception ex)
        {

            throw ex;
        }
    }

    public async Task<ResponseDto> cancelAppointment(int appointmentId)
    {
        try
        {
            var httpResponse =
                await http.PutAsync(
                    $"{baseUrl}/Doctor/cancelAppointment?appointmentId={appointmentId}", null);
            var response = await httpResponse.Content.ReadAsStringAsync();

            if (!httpResponse.IsSuccessStatusCode)
                throw new Exception(
                    $"Failed to get appointments: {response}");

            return JsonSerializer.Deserialize<ResponseDto>(response, new JsonSerializerOptions
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