namespace Patient.DTOs;

public class CancelAppointmentDto
{
    public int AppointmentId { get; set; }
    public string PatientCpr { get; set; }
    public CancelAppointmentDto() { }

    public CancelAppointmentDto(int appointmentId, string patientCpr)
    {
        AppointmentId = appointmentId;
        PatientCpr = patientCpr;
    }
}
    
