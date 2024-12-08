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
        public string patientCpr { get; set; }
        public string patientFirstName { get; set; }
        public string patientLastName { get; set; }
        public string patientEmail { get; set; }
        public string patientPhone { get; set; }
    }
}