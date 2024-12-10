using PatientFinal.DTOs;

namespace PatientFinal.Services;

public interface IPrescriptionService
{
    public Task<List<GetPrescriptionsDto>> GetPrescriptionsByPatientCpr(string cpr);
}