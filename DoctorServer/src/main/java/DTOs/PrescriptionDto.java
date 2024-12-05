package DTOs;

public class PrescriptionDto {

    public String id;
    public String diagnosis;
    public String medication;
    public String recommendations;
    public String date;
    public String time;
    public String patientcpr;
    public String doctorid;

    public String getId() {
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
