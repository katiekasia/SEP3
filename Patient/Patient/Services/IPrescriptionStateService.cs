using Patient.DTOs;

namespace Patient.Services;

public interface IPrescriptionStateService
{
    bool IsInitialized { get; }
    List<GetPrescriptionsDto> Prescriptions { get; }

    void SetPrescriptions(List<GetPrescriptionsDto> prescriptions);
    void ClearPrescriptions();
}