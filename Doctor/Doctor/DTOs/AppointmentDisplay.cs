namespace Doctor.DTOs;

public class AppointmentDisplay
{
    public int Id { get; set; }
    public DateTime Date { get; set; }
    public TimeOnly Time { get; set; }
    public string type { get; set; }
    public string status { get; set; }
    
}