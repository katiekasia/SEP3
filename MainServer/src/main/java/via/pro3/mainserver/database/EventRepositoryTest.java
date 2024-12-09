package via.pro3.mainserver.database;

import via.pro3.mainserver.Model.Appointment;
import via.pro3.mainserver.Model.Clinic;
import via.pro3.mainserver.Model.Doctor;
import via.pro3.mainserver.Model.Patient;
import via.pro3.mainserver.Model.MyDateAndTime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class EventRepositoryTest {
  public static void main(String[] args) {
    DatabaseInterface database = DatabaseSingleton.getInstance();
    EventRepository repo = new EventRepository(database);

    try {
      String testCpr = "1234567889";
      String testDoctorId = "1";

      System.out.println("=== 1. Setting up test data ===");
      Doctor doctor = repo.getDoctorById(testDoctorId);
      Patient patient = repo.getPatientByCpr(testCpr);
      Clinic clinic = repo.getClinicByDoctorId(testDoctorId);


      System.out.println("\n=== 2. Creating test appointments ===");

      // Past appointment (should be expired)
      MyDateAndTime pastDate = new MyDateAndTime(
          LocalDate.now().minusDays(6),
          LocalTime.of(14, 30)
      );
      Appointment pastAppointment = new Appointment(
          9,
          clinic,
          "Past Checkup",
          pastDate,
          "ma doare-n pula",
          "Active"
      );

      // Future appointment (should remain active)
      MyDateAndTime futureDate = new MyDateAndTime(
          LocalDate.now().plusDays(7),
          LocalTime.of(10, 00)
      );
      Appointment futureAppointment = new Appointment(
          10,
          clinic,
          "Future Checkup",
          futureDate,
          "deam nu ma doare ",
          "Active"
      );
      MyDateAndTime futureDate1 = new MyDateAndTime(
          LocalDate.now().plusDays(7),
          LocalTime.of(10, 00)
      );
      Appointment futureAppointment1 = new Appointment(
          11,
          clinic,
          "Future Checkup",
          futureDate,
          "dsukaaaaae ",
          "Active"
      );
      MyDateAndTime futureDate2 = new MyDateAndTime(
          LocalDate.now().plusDays(5),
          LocalTime.of(07, 00)
      );
      Appointment futureAppointment2 = new Appointment(
          12,
          clinic,
          "Future Checkup",
          futureDate,
          "dsukaaaaae ",
          "Active"
      );


      System.out.println("Creating past appointment...");
      repo.createAppointment(pastAppointment, doctor, patient);
      System.out.println("Creating future appointment...");
      repo.createAppointment(futureAppointment, doctor, patient);
      System.out.println("Creating future appointment...");
      repo.createAppointment(futureAppointment1, doctor, patient);
      System.out.println("Creating future appointment...");
      repo.createAppointment(futureAppointment2, doctor, patient);
      System.out.println("✓ Test appointments created successfully!");

      // Get all appointments and verify expiration
      System.out.println("\n=== 3. Testing automatic expiration and listing appointments ===");
      List<Appointment> appointments = repo.getAppointmentsByPatientCpr(testCpr);

      System.out.println("\nAll appointments for patient " + testCpr + ":");
      int index = 1;
      for (Appointment apt : appointments) {
        System.out.println("\nAppointment " + index + ":");
        System.out.println("ID: " + apt.getAppointmentId());
        System.out.println("Type: " + apt.getType());
        System.out.println("Date: " + apt.getDate());
        System.out.println("Time: " + apt.getTime());
        System.out.println("Status: " + apt.getStatus());
        System.out.println("Description: " + apt.getDescription());
        if (apt.getDate().isBefore(LocalDate.now()) && apt.getStatus().equals("Expired")) {
          System.out.println("✓ Past appointment correctly marked as expired");
        }
        System.out.println("--------------------");
        index++;
      }

      // Test cancellation of an active appointment
      System.out.println("\n=== 4. Testing appointment cancellation ===");
      System.out.println("Looking for an active appointment to cancel...");

      Appointment appointmentToCancel = appointments.stream()
          .filter(apt -> apt.getStatus().equals("Active"))
          .findFirst()
          .orElse(null);

      if (appointmentToCancel != null) {
        System.out.println("\nFound active appointment to cancel:");
        System.out.println("ID: " + appointmentToCancel.getAppointmentId());
        System.out.println("Date: " + appointmentToCancel.getDate());
        System.out.println("Current Status: " + appointmentToCancel.getStatus());

        // Cancel the appointment
        System.out.println("\nCancelling appointment...");
        repo.cancelAppointment(appointmentToCancel.getAppointmentId(), testCpr);

        // Verify cancellation
        System.out.println("\nVerifying cancellation - Updated appointment list:");
        appointments = repo.getAppointmentsByPatientCpr(testCpr);
        for (Appointment apt : appointments) {
          if (apt.getAppointmentId() == appointmentToCancel.getAppointmentId()) {
            System.out.println("\nCancelled Appointment Status Check:");
            System.out.println("ID: " + apt.getAppointmentId());
            System.out.println("New Status: " + apt.getStatus());
            if (apt.getStatus().equals("Cancelled")) {
              System.out.println("✓ Appointment successfully cancelled");
            } else {
              System.out.println("✗ Appointment not cancelled properly");
            }
          }
        }
      } else {
        System.out.println("No active appointments found to cancel");
      }

    } catch (Exception e) {
      System.err.println("Test failed: " + e.getMessage());
      e.printStackTrace();
    } finally {
      DatabaseSingleton.getInstance().disconnect();
    }
  }
}