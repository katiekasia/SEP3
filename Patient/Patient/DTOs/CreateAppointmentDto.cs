namespace Patient.DTOs;

public class CreateAppointmentDto
{
        public string type {get; set;}
        
        
        public string description { get; set; }
        public string status { get; set; }
        public string patientCpr { get; set; }
        public string doctorId { get; set; }
        
        public string date { get; set; }
        public string time { get; set; }
      
}