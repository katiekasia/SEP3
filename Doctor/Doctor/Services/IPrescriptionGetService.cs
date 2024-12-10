using PatientFinal.DTOs;

namespace PatientFinal.Services;

public interface IPrescriptionGetService
{
    public Task<List<GetPrescriptionsDto>> GetPrescriptionsByPatientCpr(string cpr);
}