using System.Runtime.InteropServices.JavaScript;

namespace PatientFinal.DTOs;

public class CreateAppointmentDto
{
        
        public string appoitmentDate { get; set; }
        public string appoitmentTime { get; set; }
       public string Specialization { get; set; }
       public string City { get; set; }
        public string Status { get; set; }
        public string Description { get; set; }
        public string PatientCpr { get; set; }
        public string DoctorId { get; set; }
}