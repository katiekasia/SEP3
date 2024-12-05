package via.pro3.mainserver.database;

import via.pro3.mainserver.Model.Appointment;
import via.pro3.mainserver.Model.Clinic;
import via.pro3.mainserver.Model.Doctor;
import via.pro3.mainserver.Model.Patient;

import java.util.List;

public class EventRepositoryTest {
  public static void main(String[] args) {
    DatabaseInterface database = DatabaseSingleton.getInstance();
    EventRepository repo = new EventRepository(database);

    try {
      // Test getPatientByCpr
      System.out.println("Testing getPatientByCpr...");
      String testCpr = "1234567890"; // Replace with existing CPR
      Patient patient = repo.getPatientByCpr(testCpr);
      System.out.println("Found patient: " + patient.getName() + " " + patient.getSurname());

      // Test getDoctorById
      System.out.println("\nTesting getDoctorById...");
      String testDoctorId = "1"; // Replace with existing doctor ID
      Doctor doctor = repo.getDoctorById(testDoctorId);
      System.out.println("Found doctor: " + doctor.getName() + " " + doctor.getSurname());

      // Test getClinicByDoctorId
      System.out.println("\nTesting getClinicByDoctorId...");
      Clinic clinic = repo.getClinicByDoctorId(testDoctorId);
      System.out.println("Found clinic: " + clinic.getName() + " in " + clinic.getCity());

      // Test getAppointmentsByPatientCpr
      System.out.println("\nTesting getAppointmentsByPatientCpr...");
      List<Appointment> appointments = repo.getAppointmentsByPatientCpr(testCpr);
      System.out.println("Found " + appointments.size() + " appointments:");
      for (Appointment appointment : appointments) {
        System.out.println("ID: " + appointment.getAppointmentId());
        System.out.println("Type: " + appointment.getType());
        System.out.println("Date: " + appointment.getDate());
        System.out.println("Time: " + appointment.getTime());
        System.out.println("Status: " + appointment.getStatus());
        System.out.println("Clinic: " + appointment.getClinic().getName());
        System.out.println("--------------------");
      }

    } catch (Exception e) {
      System.err.println("Test failed: " + e.getMessage());
      e.printStackTrace();
    }
  }
}
