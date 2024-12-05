using Doctor.DTOs;

namespace Doctor.Services;

public interface IPrescriptionsService
{
    public Task<List<PatientDto>> GetPatientsByDoctorId(string doctorid);
    public Task<ResponseDto> AddPrescription(PrescriptionDto prescription);
}