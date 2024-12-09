namespace PatientFinal.DTOs
{

    public class GetAppointmentsDto
    {
        public int Id { get; set; }
        public string Description { get; set; }
        public string Type { get; set; }
        public string Date { get; set; }
        public string Time { get; set; }
        public string Status { get; set; }
        public string DoctorId { get; set; }
        public string DoctorFirstName { get; set; }
        public string DoctorLastName { get; set; }
        public string DoctorSpecialization { get; set; }
        public string ClinicName { get; set; }
        public string ClinicStreet { get; set; }
        public string ClinicStreetNumber { get; set; }
        public string ClinicCity { get; set; }
        public bool CanBeCancelled => Status == "Active";
        
    }
}