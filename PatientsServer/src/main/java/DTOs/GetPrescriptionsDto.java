package DTOs;

public class GetPrescriptionsDto
{
  public int id;
  public String diagnosis;
  public String medication;
  public String recommendations;
  public String date;
  public String time;
  public String patientcpr;
  public String doctorid;
  public String doctorname;
  public String doctorsurname;

  public GetPrescriptionsDto(int id, String diagnosis, String medication, String recommendations, String date, String time, String patientcpr, String doctorid, String doctorname, String doctorsurname) {
    this.id = id;
    this.diagnosis = diagnosis;
    this.medication = medication;
    this.recommendations = recommendations;
    this.date = date;
    this.time = time;
    this.patientcpr = patientcpr;
    this.doctorid = doctorid;
    this.doctorname = doctorname;
    this.doctorsurname = doctorsurname;
  }

  public int getId() {
    return id;
  }

  public String getDiagnosis() {
    return diagnosis;
  }

  public String getMedication() {
    return medication;
  }

  public String getRecommendations() {
    return recommendations;
  }

  public String getDate() {
    return date;
  }


  public String getTime() {
    return time;
  }

  public String getPatientCpr() {
    return patientcpr;
  }


  public String getDoctorId() {
    return doctorid;
  }

  public String getDoctorname()
  {
    return doctorname;
  }

  public String getDoctorsurname()
  {
    return doctorsurname;
  }
}
