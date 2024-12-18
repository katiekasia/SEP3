package via.pro3.mainserver.Model;

public class Prescription
{
  private int id;
  private String diagnosis;
  private String medication;
  private String recommendations;
  private Doctor doctor;
  private MyDateAndTime dateAndTime;

  public Prescription(int id, String diagnosis, String medication,String recommendations, Doctor doctor,MyDateAndTime dateAndTime){
    setId(id);
    setDiagnosis(diagnosis);
    setMedication(medication);
    setRecommendations(recommendations);
    setDoctor(doctor);
    setDateAndTime(dateAndTime);
  }
//GETTERS BELOW*******************


  public MyDateAndTime getDateAndTime()
  {
    return dateAndTime != null ? dateAndTime.copy() : null;
  }
  public Doctor getDoctor()
  {
    return doctor;
  }
  public String getDiagnosis()
  {
    return diagnosis;
  }

  public String getRecommendations()
  {
    return recommendations;
  }

  public String getMedication()
  {
    return medication;
  }

  public int getId()
  {
    return id;
  }

//SETTERS BELOW***********************************

  public void setId(int id) {
    this.id = id;
  }

  public void setDateAndTime(MyDateAndTime dateAndTime) {
    this.dateAndTime = dateAndTime.copy();
  }

  public void setDiagnosis(String diagnosis) {
    if (diagnosis == null) {
      diagnosis = "";
    }
    this.diagnosis = diagnosis;
  }

  public void setMedication(String medication) {
    this.medication = medication;
  }

  public void setRecommendations(String recommendations) {
    if (recommendations == null) recommendations = "";
    this.recommendations = recommendations;
  }

  public void setDoctor(Doctor doctor)
  {
    this.doctor = doctor;
  }
}
