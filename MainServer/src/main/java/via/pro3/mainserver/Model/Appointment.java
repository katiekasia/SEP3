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
      MyDateAndTime dateAndTime, String description, String status)
  {
    setId(id);
    setClinic(clinic);
    setType(type);
    setDateAndTime(dateAndTime);
    setDescription(description);
    if (status.equals("Active")){
    setStatus(new ActiveAppointment());}
    else if (status.equals("Cancelled"))
    {
      setStatus(new CancelledAppointment());
    }else {
      setStatus(new ExpiredAppointment());
    }
  }

  public void cancel(){
    status.cancel(this);
  }
  public void expire(){
    if (LocalDate.now().isAfter(dateAndTime.getDate())){
      status.expire(this);
    }
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

