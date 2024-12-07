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
  private String phone;
  private String specialization;
  private Map<Integer,Appointment> appointments;
  private Clinic clinic;

  public Doctor(String  id, String name, String surname,String phone, String email, String password, String specialization,Clinic clinic)
  {
    setId(id);
    setName(name);
    setSurname(surname);
    setPassword(password);
    setEmail(email);
    setPhone(phone);
    setSpecialization(specialization);
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

  public String getPhone() {return phone;}

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

  public String getSpecialization()
  {
    return specialization;
  }
  public Map<Integer, Appointment> getAppointments(){
    return appointments;
  }
  @Override public String toString(){
  return getId() + getName() + " " + getSurname() + " " + getSpecialization();
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

  public void setPhone(String phone)
  {
    this.phone = phone;
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

  public void setSpecialization(String specialization)
  {
    this.specialization = specialization;
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
