namespace Doctor.DTOs;

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
}