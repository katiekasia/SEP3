package via.pro3.mainserver.service;

import io.grpc.stub.StreamObserver;
import patient.grpc.*;
import via.pro3.mainserver.Model.Model;
import via.pro3.mainserver.Model.ModelManager;
import via.pro3.mainserver.database.DatabaseInterface;
import via.pro3.mainserver.database.DatabaseSingleton;

public class PatientImplTest {
  public static void main(String[] args) {
    DatabaseInterface database = DatabaseSingleton.getInstance();
    Model model = new ModelManager();
    PatientImpl patientService = new PatientImpl(model);

    // Test getAppointmentsByPatientCpr
    testGetAppointments(patientService);

    // Test login
    //testLogin(patientService);

    // Test registration
   // testRegistration(patientService);

    // Test create appointment
    //testCreateAppointment(patientService);
  }

  private static void testGetAppointments(PatientImpl service) {
    System.out.println("Testing getAppointmentsByPatientCpr...");
    GetAppointmentsRequest request = GetAppointmentsRequest.newBuilder()
        .setPatientCpr("1234567890") // Use existing CPR
        .build();

    service.getAppointmentsByPatientCpr(request, new StreamObserver<GetAppointmentsResponse>() {
      @Override
      public void onNext(GetAppointmentsResponse response) {
        System.out.println("Found " + response.getAppointmentsList().size() + " appointments");
        for (AppointmentInfo appointment : response.getAppointmentsList()) {
          System.out.println("ID: " + appointment.getId());
          System.out.println("Doctor: " + appointment.getDoctorFirstName() + " " + appointment.getDoctorLastName());
          System.out.println("Date: " + appointment.getDate());
          System.out.println("-------------");
        }
      }

      @Override
      public void onError(Throwable t) {
        System.err.println("Error: " + t.getMessage());
      }

      @Override
      public void onCompleted() {
        System.out.println("Request completed\n");
      }
    });
  }

 /* private static void testLogin(PatientImpl service) {
    System.out.println("Testing loginPatient...");
    PatientRequest request = PatientRequest.newBuilder()
        .setCpr("1234567890") // Use existing CPR
        .build();

    service.loginPatient(request, new StreamObserver<LoginResponse>() {
      @Override
      public void onNext(LoginResponse response) {
        System.out.println("Login successful for: " + response.getName() + " " + response.getSurname());
      }

      @Override
      public void onError(Throwable t) {
        System.err.println("Login error: " + t.getMessage());
      }

      @Override
      public void onCompleted() {
        System.out.println("Login request completed\n");
      }
    });
  }

  /*private static void testCreateAppointment(PatientImpl service) {
    System.out.println("Testing createAppointment...");
    CreateAppointment request = CreateAppointment.newBuilder()
        .setType("Regular checkup")
        .setDescription("Annual checkup")
        .setStatus("Active")
        .setPatientCpr("1234567890") // Use existing CPR
        .setDoctorId("1") // Use existing doctor ID
        .setAppointmentDate("2024-12-10")
        .setAppointmentTime("10:00")
        .build();

    service.createAppointment(request, new StreamObserver<DBresponse>() {
      @Override
      public void onNext(DBresponse response) {
        System.out.println("Appointment created: " + response.getConfirmation());
      }

      @Override
      public void onError(Throwable t) {
        System.err.println("Creation error: " + t.getMessage());
      }

      @Override
      public void onCompleted() {
        System.out.println("Creation request completed\n");
      }
    });
  }*/

  /*private static void testRegistration(PatientImpl service) {
    System.out.println("Testing registerPatient...");
    RegisterRequest request = RegisterRequest.newBuilder()
        .setName("John")
        .setSurname("Doe")
        .setEmail("john.doe@email.com")
        .setPhone("12345678")
        .setPassword("password123")
        .setCPRNo("9876543210")
        .build();

    service.registerPatient(request, new StreamObserver<DBresponse>() {
      @Override
      public void onNext(DBresponse response) {
        System.out.println("Registration result: " + response.getConfirmation());
      }

      @Override
      public void onError(Throwable t) {
        System.err.println("Registration error: " + t.getMessage());
      }

      @Override
      public void onCompleted() {
        System.out.println("Registration request completed\n");
      }
    });
  }*/
}