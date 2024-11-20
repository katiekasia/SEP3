package via.pro3.mainserver.DTOs;


public class CreateAppointmentDto
{

  private String city;
 private String specialization;
  private String description;
  private String status;
  //private String patientCPR;
 // private String doctorId;

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

  public void setCity(String city) {
    this.city = city;
  }

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

//  public String getDoctorId()
//  {
//    return doctorId;
//  }
//  //PATIENT ID
//  public String getPatientCpr()
//  {
//    return patientCPR;
//  }
//
//
//  public String getPatientCPR() {
//    return patientCPR;
//  }
//
//  public void setPatientCPR(String patientCPR) {
//    this.patientCPR = patientCPR;
//  }
//
//
//  public void setDoctorId(String doctorId) {
//    this.doctorId = doctorId;
//  }


}
