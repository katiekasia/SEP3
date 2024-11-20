package via.pro3.mainserver.Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment
{
  private int id;
  private MyDateAndTime dateAndTime;
  private String description;
  private AppointmentState status;
  private String type;
  private Clinic clinic;

  public Appointment (int id, Clinic clinic,String type,
      MyDateAndTime dateAndTime, String description)
  {
    setId(id);
    setClinic(clinic);
    setType(type);
    setDateAndTime(dateAndTime);
    setDescription(description);
    setStatus(new ActiveAppointment());
  }
//GETTERS BELOW*************************
  public int getAppointmentId()
  {
    return id;
  }
  public LocalDate getDate()
  {
    return dateAndTime.getDate();
  }
  public String getType()
  {
    return type;
  }
  public String getCity()
  {
    return clinic.getCity();
  }
  public LocalTime getTime()
  {
    return dateAndTime.getTime();
  }
  public String getDescription()
  {
    return description;
  }
  public String getStatus()
  {
    return status.status();
  }
  public String getAdressString(){return clinic.getAddress();}
  public Clinic getClinic() {return clinic.copy();}
  public String getClinicName(){return clinic.getName();}
  public MyDateAndTime getDateAndTime() {return dateAndTime.copy();}

  public void cancel(){
    status.cancel(this);
}
public void expire(){
    status.expire(this);
}
  //SETTERS BELOW****************************88
  public void setId(int appointmentId)
  {
    this.id = appointmentId;
  }

  public void setDate(LocalDate date)
  {
    dateAndTime.setDate(date);
  }

  public void setType(String type)
  {
    this.type = type;
  }

  public void setDateAndTime(MyDateAndTime dateAndTime)
  {
    this.dateAndTime = dateAndTime.copy();
  }

  public void setClinic(Clinic clinic)
  {
    this.clinic = clinic.copy();
  }

  public void setTime(LocalTime time)
  {
    this.dateAndTime.setTime(time);
  }

  public void setDescription(String description)
  {
    this.description = description;
  }


  public void setStatus(AppointmentState status)
  {
    this.status = status;
  }

}

