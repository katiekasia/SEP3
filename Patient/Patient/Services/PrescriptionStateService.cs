using Patient.DTOs;

namespace Patient.Services;

public class PrescriptionStateService : IPrescriptionStateService
{
    private bool _isInitialized;

    // This is a singleton, so this state will persist across pages as long as the app is running.
    public bool IsInitialized => _isInitialized;
    public List<GetPrescriptionsDto> _prescriptions;

    public PrescriptionStateService()
    {
        _prescriptions = new List<GetPrescriptionsDto>();
        _isInitialized = false;  
    }

    public List<GetPrescriptionsDto> Prescriptions => _prescriptions;

    // Method to initialize appointments
    public void SetPrescriptions(List<GetPrescriptionsDto> prescriptions)
    {
        this._prescriptions = prescriptions;
        _isInitialized = true; // Set state as initialized
    }
    

    // Optional: Clear all appointments (if needed)
    public void ClearPrescriptions()
    {
        _prescriptions.Clear();
        _isInitialized = false;  // Reset state
    }
}