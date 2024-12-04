using PatientFinal.DTOs;

namespace PatientFinal.Services;

public interface IUpdateService
{
    public Task<UpdatePatientDto> UpdatePatient (UpdatePatientDto request);

}