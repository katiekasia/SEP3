package via.pro3.mainserver.DTOs;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CreateAppointmentDto
{

  private String type;
  private String description;
  private String status;
  private String patientCPR;
  private String doctorId;
  private String  appointmentDate;
  private String  appointmentTime;

  public CreateAppointmentDto(String type, String description, String status,
      String patientCR, String doctorId, String  appointmentDate, String appointmentTime)
  {

    setType(type);
    setDescription(description);
    setStatus(status);
    setPatientCPR(patientCR);
    setDoctorId(doctorId);
    setAppointmentDate(appointmentDate);
    setAppointmentTime(appointmentTime);
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
    return patientCPR;
  }

  public LocalDate getAppointmentDate()
  {
    return LocalDate.parse(appointmentDate) ;
  }

  public LocalTime getAppointmentTime()
  {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm");
    return LocalTime.parse(appointmentTime, formatter) ;
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

  public void setPatientCPR(String patientCPR)
  {
    this.patientCPR = patientCPR;
  }

  public void setDoctorId(String doctorId)
  {
    this.doctorId = doctorId;
  }

  public void setAppointmentDate(String appointmentDate)
  {
    this.appointmentDate = appointmentDate;
  }

  public void setAppointmentTime(String appointmentTime)
  {

    this.appointmentTime = appointmentTime;
  }
}
