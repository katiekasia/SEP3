namespace PatientFinal.DTOs;

public class ResponseDto
{
    public string response { get; set; }
    public List<GetAppointmentsDto> Appointments { get; set; } = new List<GetAppointmentsDto>();
}