namespace Patient.DTOs
{
    public class PrescriptionDto
    {
        public int id { get; set; }
        public string diagnosis { get; set; }
        public string medication { get; set; }
        public string recommendations { get; set; }
        public string date { get; set; }
        public string time { get; set; }
        public string patientcpr { get; set; }
        public string doctorid { get; set; }

        public PrescriptionDto(int id, string diagnosis, string medication, string recommendations, string date, string time, string patientcpr, string doctorid)
        {
            this.id = id;
            this.diagnosis = diagnosis;
            this.medication = medication;
            this.recommendations = recommendations;
            this.date = date;
            this.time = time;
            this.patientcpr = patientcpr;
            this.doctorid = doctorid;
        }
    }
}