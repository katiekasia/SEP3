package DTOs;

public class GetAppointmentsDto
{
  private int id;
  private String description;
  private String type;
  private String date;
  private String time;
  private String status;
  private String patientCpr;
  private String patientFirstName;
  private String patientLastName;
  private String patientEmail;
  private String patientPhone;

    // Getters
    public int getId() { return id; }
    public String getDescription() { return description; }
    public String getType() { return type; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public String getStatus() { return status; }
    public String getPatientCpr()
  {
    return patientCpr;
  }
    public String getPatientEmail()
  {
    return patientEmail;
  }
    public String getPatientFirstName()
  {
    return patientFirstName;
  }
    public String getPatientLastName()
  {
    return patientLastName;
  }
    public String getPatientPhone()
  {
    return patientPhone;
  }

  // Setters
    public void setId(int id) { this.id = id; }
    public void setDescription(String description) { this.description = description; }
    public void setType(String type) { this.type = type; }
    public void setDate(String date) { this.date = date; }
    public void setTime(String time) { this.time = time; }
    public void setStatus(String status) { this.status = status; }
    public void setPatientCpr(String patientCpr)
  {
    this.patientCpr = patientCpr;
  }
    public void setPatientEmail(String patientEmail)
  {
    this.patientEmail = patientEmail;
  }
    public void setPatientFirstName(String patientFirstName)
  {
    this.patientFirstName = patientFirstName;
  }
    public void setPatientLastName(String patientLastName)
  {
    this.patientLastName = patientLastName;
  }
    public void setPatientPhone(String patientPhone)
  {
    this.patientPhone = patientPhone;
  }
}

