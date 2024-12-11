using Patient.DTOs;

namespace Patient.Services;

public interface IPrescriptionService
{
    public Task<List<GetPrescriptionsDto>> GetPrescriptionsByPatientCpr(string cpr, int page);
    Task<int> GetPrescriptionCount(string cpr);
}