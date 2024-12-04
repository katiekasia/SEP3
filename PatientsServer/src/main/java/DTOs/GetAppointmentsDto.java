package DTOs;

import java.util.List;

public class GetAppointmentsDto
{
  private int id;
  private String description;
  private String type;
  private String date;
  private String time;
  private String status;
  private String doctorId;
  private String doctorFirstName;
  private String doctorLastName;
  private String doctorSpecialization;
  private String clinicName;
  private String clinicStreet;
  private String clinicStreetNumber;
  private String clinicCity;
    // Getters
    public int getId() { return id; }
    public String getDescription() { return description; }
    public String getType() { return type; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public String getStatus() { return status; }
    public String getDoctorId() { return doctorId; }
    public String getDoctorFirstName() { return doctorFirstName; }
    public String getDoctorLastName() { return doctorLastName; }
    public String getDoctorSpecialization() { return doctorSpecialization; }
    public String getClinicName() { return clinicName; }
    public String getClinicStreet() { return clinicStreet; }
    public String getClinicStreetNumber() { return clinicStreetNumber; }
    public String getClinicCity() { return clinicCity; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setDescription(String description) { this.description = description; }
    public void setType(String type) { this.type = type; }
    public void setDate(String date) { this.date = date; }
    public void setTime(String time) { this.time = time; }
    public void setStatus(String status) { this.status = status; }
    public void setDoctorId(String doctorId) { this.doctorId = doctorId; }
    public void setDoctorFirstName(String doctorFirstName) { this.doctorFirstName = doctorFirstName; }
    public void setDoctorLastName(String doctorLastName) { this.doctorLastName = doctorLastName; }
    public void setDoctorSpecialization(String doctorSpecialization) { this.doctorSpecialization = doctorSpecialization; }
    public void setClinicName(String clinicName) { this.clinicName = clinicName; }
    public void setClinicStreet(String clinicStreet) { this.clinicStreet = clinicStreet; }
    public void setClinicStreetNumber(String clinicStreetNumber) { this.clinicStreetNumber = clinicStreetNumber; }
    public void setClinicCity(String clinicCity) { this.clinicCity = clinicCity; }
  }

