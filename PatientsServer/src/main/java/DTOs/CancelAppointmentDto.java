package DTOs;

public class CancelAppointmentDto {
  private int appointmentId;
  private String patientCpr;

  //  no-args constructor for JSON deserialization
  public CancelAppointmentDto() {
  }


  public CancelAppointmentDto(int appointmentId, String patientCpr) {
    this.appointmentId = appointmentId;
    this.patientCpr = patientCpr;
  }


  public int getAppointmentId() {
    return appointmentId;
  }

  public void setAppointmentId(int appointmentId) {
    this.appointmentId = appointmentId;
  }

  public String getPatientCpr() {
    return patientCpr;
  }

  public void setPatientCpr(String patientCpr) {
    this.patientCpr = patientCpr;
  }
}