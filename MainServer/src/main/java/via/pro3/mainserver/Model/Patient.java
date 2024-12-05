package via.pro3.mainserver.Model;

import java.util.HashMap;
import java.util.Map;

public class Patient {
    private String name;
    private String surname;
    private String password;
    private String CPRNo;
    private String phone;
    private String email;
    private Map<Integer,Appointment> appointments;

    public Patient(String CPRNo, String name, String surname, String phone, String email, String password) {
        this.CPRNo = CPRNo;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.phone = phone;
        this.email = email;
        appointments = new HashMap<Integer, Appointment>();
    }
    public Patient(){}
    public void addAppointment(Appointment appointment){
        appointments.put(appointment.getAppointmentId(), appointment);
    }
    public void removeAppointmentById(int id)
    {
        appointments.remove(id);
    }
    //GETTERS BELOW**************************
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public String getCPRNo() {
        return CPRNo;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Appointment getAppointmentById(int id){
        return appointments.get(id);
    }
    public Map<Integer, Appointment> getAppointments(){
        return appointments;
    }
    //SETTERS BELOW*********************************


    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCPRNo(String CPRNo) {
        this.CPRNo = CPRNo;
    }
    public void setAppointments(Map<Integer,Appointment> appointments)
    {
        this.appointments = appointments;
    }
}
