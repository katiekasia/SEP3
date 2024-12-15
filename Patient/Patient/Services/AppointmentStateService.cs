using Patient.DTOs;

namespace Patient.Services;

public class AppointmentStateService : IAppointmentStateService
{
    private List<GetAppointmentsDto> _appointments;
    private bool _isInitialized;

    // This is a singleton, so this state will persist across pages as long as the app is running.
    public bool IsInitialized => _isInitialized;

    public AppointmentStateService()
    {
        _appointments = new List<GetAppointmentsDto>();
        _isInitialized = false;  
    }

    public List<GetAppointmentsDto> Appointments => _appointments;

    // Method to initialize appointments
    public void SetAppointments(List<GetAppointmentsDto> appointments)
    {
        _appointments = appointments;
        _isInitialized = true; // Set state as initialized
    }
    

    // Optional: Clear all appointments (if needed)
    public void ClearAppointments()
    {
        _appointments.Clear();
        _isInitialized = false;  // Reset state
    }
}