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
                    await client.PostAsJsonAsync(
                        "http://localhost:8081/Demo/book",
                        createAppointmentDto);
                string response =
                    await httpResponse.Content.ReadAsStringAsync();
                if (!httpResponse.IsSuccessStatusCode)
                    throw new Exception(response);
                Console.WriteLine(response);
                return JsonSerializer.Deserialize<ResponseDto>(response,
                    new JsonSerializerOptions
                        { PropertyNameCaseInsensitive = true });

            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error occurred: {ex.Message}");
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