using System.Net.Http.Json;
using System.Text.Json;
using Patient.DTOs;

namespace Patient.Services
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

        public async Task<List<DateDto>> GetDoctorAvailability(string doctorId)
        {
            try
            {
                var httpResponse = await client.GetAsync($"{baseUrl}/Demo/days?doctorId={doctorId}");
                var response = await httpResponse.Content.ReadAsStringAsync();

                if (!httpResponse.IsSuccessStatusCode)
                {
                    throw new Exception($"Failed to get appointments: {response}");
                }

                List<DateDto> dates =
                    JsonSerializer.Deserialize<List<DateDto>>(response,
                        new JsonSerializerOptions
                            { PropertyNameCaseInsensitive = true });

                return dates;
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error retrieving appointments: {ex.Message}");
                throw;
            }
        }

        public async Task<List<DateDto>> GetDoctorsSchedule(string doctorId)
        {
            try
            {
                var httpResponse =
                    await client.GetAsync(
                        $"{baseUrl}/Demo/alldays?doctorId={doctorId}");
                var response = await httpResponse.Content.ReadAsStringAsync();

                if (!httpResponse.IsSuccessStatusCode)
                {
                    throw new Exception(
                        $"Failed to get appointments: {response}");
                }

                List<DateDto> dates =
                    JsonSerializer.Deserialize<List<DateDto>>(response,
                        new JsonSerializerOptions
                            { PropertyNameCaseInsensitive = true });

                return dates;
            }
            catch (Exception ex)
            {
                Console.WriteLine(
                    $"Error retrieving appointments: {ex.Message}");
                throw;
            }
        }

        public async Task<List<GetAppointmentsDto>> GetAppointments(string patientCpr)
    {
        try
        {
            var httpResponse = await client.GetAsync($"{baseUrl}/Demo/appointments?cpr={patientCpr}");
            var response = await httpResponse.Content.ReadAsStringAsync();

            if (!httpResponse.IsSuccessStatusCode)
            {
                throw new Exception($"Failed to get appointments: {response}");
            }

            var responseDto = JsonSerializer.Deserialize<ResponseDto>(
                response,
                new JsonSerializerOptions { PropertyNameCaseInsensitive = true }
            );

            if (!responseDto.Success)
            {
                throw new Exception(responseDto.response ?? "Unknown error occurred");
            }

            return responseDto.Appointments ??
                   new List<GetAppointmentsDto>();
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error retrieving appointments: {ex.Message}");
            throw;
        }
    }

    public async Task<bool> CancelAppointment(int appointmentId, string patientCpr)
    {
        try
        {
            var cancelRequest = new CancelAppointmentDto(appointmentId, patientCpr);

            var httpResponse = await client.PostAsJsonAsync(
                $"{baseUrl}/Demo/appointments/cancel",
                cancelRequest
            );

            var response = await httpResponse.Content.ReadAsStringAsync();

            if (!httpResponse.IsSuccessStatusCode)
            {
                throw new Exception($"Failed to cancel appointment: {response}");
            }

            var responseDto = JsonSerializer.Deserialize<ResponseDto>(
                response,
                new JsonSerializerOptions { PropertyNameCaseInsensitive = true }
            );

            return responseDto.Success;
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error cancelling appointment: {ex.Message}");
            throw;
        }
    }
        public async Task<List<CityDto>> GetCities()
        {
            try
            {
                HttpResponseMessage httpResponse =
                    await client.GetAsync("http://localhost:8081/Demo/cities");
                string response =
                    await httpResponse.Content.ReadAsStringAsync();

                if (!httpResponse.IsSuccessStatusCode)
                    throw new Exception("Failed to fetch cities: " + response);

                if (string.IsNullOrEmpty(response))
                {
                    throw new Exception("Empty response received for cities.");
                }

                List<CityDto> cities =
                    JsonSerializer.Deserialize<List<CityDto>>(response,
                        new JsonSerializerOptions
                            { PropertyNameCaseInsensitive = true });

                if (cities == null)
                    throw new Exception("No cities data available.");
                Console.WriteLine(response);

                return cities;
            }
            catch (Exception ex)
            {
                Console.WriteLine(
                    $"Error occurred while fetching cities: {ex.Message}");
                throw;
            }
        }

        public async Task<List<ClinicDto>> GetClinicByCity(string code)
        {
            try
            {
                HttpResponseMessage httpResponse =
                    await client.GetAsync(
                        $"http://localhost:8081/Demo/clinics?code={code}");
                string response =
                    await httpResponse.Content.ReadAsStringAsync();
                Console.WriteLine("I called");

                if (!httpResponse.IsSuccessStatusCode)
                    throw new Exception("Failed to fetch cities: " + response);

                if (string.IsNullOrEmpty(response))
                {
                    throw new Exception("Empty response received for cities.");
                }

                List<ClinicDto> clinics =
                    JsonSerializer.Deserialize<List<ClinicDto>>(response,
                        new JsonSerializerOptions
                            { PropertyNameCaseInsensitive = true });

                if (clinics == null)
                    throw new Exception("No cities data available.");

                return clinics;
            }
            catch (Exception ex)
            {
                Console.WriteLine(
                    $"Error occurred while fetching cities: {ex.Message}");
                throw;
            }
        }
        
        
        public async Task<List<DoctorDto>> GetDoctorsByClinic(string clinic_id)
        {
            try
            { 
                HttpResponseMessage httpResponse = await client.GetAsync($"http://localhost:8081/Demo/doctors?clinic_id={clinic_id}");
                string response = await httpResponse.Content.ReadAsStringAsync();
                Console.WriteLine("I called");

                if (!httpResponse.IsSuccessStatusCode)
                    throw new Exception("Failed to fetch doctors: " + response);
                
                if (string.IsNullOrEmpty(response))
                {
                    throw new Exception("Empty response received for doctors.");
                }
                
                List<DoctorDto> doctors = JsonSerializer.Deserialize<List<DoctorDto>>(response, 
                    new JsonSerializerOptions { PropertyNameCaseInsensitive = true });

                if (doctors == null)
                    throw new Exception("No cities data available.");
                
                return doctors;
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error occurred while fetching cities: {ex.Message}");

                throw;
            }
        }
        
       
    }


}