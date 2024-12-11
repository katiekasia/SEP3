using Patient.DTOs;

namespace Patient.Services;

public interface IUpdateService
{
    public Task<UpdatePatientDto> UpdatePatient (UpdatePatientDto request);

}