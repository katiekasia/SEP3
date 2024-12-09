namespace PatientFinal.DTOs;

public class ResponseDto
{
    public string response { get; set; }
    public List<GetAppointmentsDto> Appointments { get; set; } = new List<GetAppointmentsDto>();
    public bool Success { get; set; }
    public static ResponseDto CreateCancellationSuccess()
    {
        return new ResponseDto 
        { 
            response = "Appointment cancelled successfully",
            Success = true 
        };
    }
    public static ResponseDto CreateCancellationError(string errorMessage)
    {
        return new ResponseDto 
        { 
            response = $"Failed to cancel appointment: {errorMessage}",
            Success = false 
        };
    }
    
}