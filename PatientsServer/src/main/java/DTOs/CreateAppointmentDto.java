package DTOs;

public class CreateAppointmentDto
{

  private String type;
  private String description;
  private String status;
  private String patientCpr;
  private String doctorId;
  private String  date;
  private String  time;

  public CreateAppointmentDto(String type, String description, String status,
      String patientCpr, String doctorId, String  appointmentDate, String appointmentTime)
  {

    setType(type);
    setDescription(description);
    setStatus(status);
    setPatientCPR(patientCpr);
    setDoctorId(doctorId);
    setDate(appointmentDate);
    setTime(appointmentTime);
  }
//GETTERS BELOW*****************
  public String getType()
  {
    return type;
  }

  public String getDescription()
  {
    return description;
  }

  public String getStatus()
  {
    return status;
  }

  public String getDoctorId()
  {
    return doctorId;
  }

  public String getPatientCpr()
  {
    return patientCpr;
  }

  public String getDate()
  {
    return date ;
  }

  public String getTime()
  {
    return time ;
  }

  //SETTERS BELOW*************************
  public void setType(String type)
  {
    this.type = type;
  }
  public void setDescription(String description)
  {
    this.description = description;
  }

  public void setStatus(String status)
  {
    this.status = status;
  }

  public void setPatientCPR(String patientCpr)
  {
    this.patientCpr = patientCpr;
  }

  public void setDoctorId(String doctorId)
  {
    this.doctorId = doctorId;
  }

  public void setDate(String appointmentDate)
  {
    this.date = appointmentDate;
  }

  public void setTime(String appointmentTime)
  {

    this.time = appointmentTime;
  }
}
