package via.pro3.mainserver.Model;

import java.util.HashMap;
import java.util.Map;

public class Doctor
{
  private String name;
  private String surname;
  private String password;
  private String email;
  private String id;
  private String specialisation;
  private Map<Integer,Appointment> appointments;
  private Clinic clinic;

  public Doctor(String  id, String name, String surname, String password, String email,  String specialisation,Clinic clinic)
  {
    setName(name);
    setSurname(surname);
    setPassword(password);
    setEmail(email);
    setId(id);
    setSpecialisation(specialisation);
    setClinic(clinic);
    appointments = new HashMap<Integer, Appointment>();
  }


public void addAppointment(Appointment appointment){
    appointments.put(appointment.getAppointmentId(), appointment);
}
  public void removeAppointmentById(int id)
  {
    appointments.remove(id);
  }


//GETTERS BELOW**************************
public Appointment getAppointmentById(int id){
  return appointments.get(id);
}

  public String getEmail()
  {
    return email;
  }

  public Clinic getClinic(){
    return clinic;
  }

  public String getId()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }

  public String getPassword()
  {
    return password;
  }

  public String getSurname()
  {
    return surname;
  }

  public String getSpecialisation()
  {
    return specialisation;
  }
  public Map<Integer, Appointment> getAppointments(){
    return appointments;
  }
  @Override public String toString(){
  return getId() + getName() + " " + getSurname() + " " + getSpecialisation();
  }
//SETTERS BELOW*********************************

  public void setName(String name)
  {
    this.name = name;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public void setClinic(Clinic clinic)
  {
    this.clinic = clinic;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public void setSpecialisation(String specialisation)
  {
    this.specialisation = specialisation;
  }

  public void setSurname(String surname)
  {
    this.surname = surname;
  }

  public void setAppointments(Map<Integer,Appointment> appointments)
  {
    this.appointments = appointments;
  }
}
