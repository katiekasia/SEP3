package via.pro3.mainserver.Model;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment
{
  private int appointmentId;
  private String city;
  private String specialization;
  private LocalDate date;
  private Time time;
  private String description;
  private String status;
  private String patientCPR;
  private String doctorId;

  public Appointment (int appointmentId, String city,String specialization,
      LocalDate date, Time time, String description, String status,
      String patientCPR, String doctorId)
  {
    this.appointmentId = appointmentId;
    this.city = city;
    this.specialization = specialization;
    this.date = date;
    this.time = time;
    this.description = description;
    this.status = status;
    this.patientCPR = patientCPR;
    this.doctorId = doctorId;
  }

  public int getAppointmentId()
  {
    return appointmentId;
  }

  public void setAppointmentId(int appointmentId)
  {
    this.appointmentId = appointmentId;
  }
  //DATE
  public LocalDate getDate()
  {
    return date;
  }

  public void setDate(LocalDate date)
  {
    this.date = date;
  }
  //SPECIALIZATION

  public String getSpecialization()
  {
    return specialization;
  }
  public void setSpecialization(String specialization)
  {
    this.specialization = specialization;
  }

  //CITY
  public String getCity()
  {
    return city;
  }
  public void setCity()
  {
    this.city = city;
  }
  //TIME

  public Time getTime()
  {
    return time;
  }

  public void setTime(Time time)
  {
    this.time = time;
  }
  //DESCRIPTION

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  //STATUS

  public String getStatus()
  {
    return status;
  }

  public void setStatus(String status)
  {
    this.status = status;
  }
  //DOCTOR ID

  public String getDoctorId()
  {
    return doctorId;
  }
  //PATIENT ID
  public String getPatientCPR()
  {
    return patientCPR;
  }


}

