package via.pro3.mainserver.DTOs;

public class PrescriptionDto {

    public int id;
    public String diagnosis;
    public String medication;
    public String recommendations;
    public String date;
    public String time;
    public String patientcpr;
    public String doctorid;

    public PrescriptionDto(int id, String diagnosis, String medication, String recommendations, String date, String time, String patientcpr, String doctorid) {
        this.id = id;
        this.diagnosis = diagnosis;
        this.medication = medication;
        this.recommendations = recommendations;
        this.date = date;
        this.time = time;
        this.patientcpr = patientcpr;
        this.doctorid = doctorid;
    }

    public int getId() {
        return id;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getMedication() {
        return medication;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public String getDate() {
        return date;
    }


    public String getTime() {
        return time;
    }

    public String getPatientCpr() {
        return patientcpr;
    }


    public String getDoctorId() {
        return doctorid;
    }
}
