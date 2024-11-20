package via.pro3.mainserver.service;

import io.grpc.stub.StreamObserver;
import createBooking.grpc.CreateAppointment;
import createBooking.grpc.PatientBookingGrpc;
import createBooking.grpc.DBresponse;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import via.pro3.mainserver.Model.Appointment;
import via.pro3.mainserver.database.DatabaseInterface;
import via.pro3.mainserver.database.DatabaseSingleton;
import via.pro3.mainserver.database.EventInterface;
import via.pro3.mainserver.database.EventRepository;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Random;

public class PatientImpl extends PatientBookingGrpc.PatientBookingImplBase {
    private final EventInterface eventRepository;

  public PatientImpl()
  {
    DatabaseInterface database = DatabaseSingleton.getInstance();
    this.eventRepository = new EventRepository(database);
  }

  @Override public void createAppointment(CreateAppointment request, StreamObserver<DBresponse> responseObserver) {
    try {
      System.out.println("method start");

      int appointmentId = new Random().nextInt(100000);  // Replace with a more consistent ID generator if needed
      LocalDate date = LocalDate.parse("2004-12-02");  // Example date
      Time time = Time.valueOf("12:12:12");
      String city = request.getCity();
      String status = request.getStatus();
      String description = request.getDescription();
      String specialization = request.getSpecialization();
      String cprNumber = "12345";
      String doctorId = "1";
      Appointment appointment = new Appointment(appointmentId, city, specialization, date,time,description,status,cprNumber,doctorId);
      System.out.println("appointment made");

      eventRepository.createAppointment(appointment);

      String responseMessage = "Booking in: " + city + " confirmed.";
      DBresponse reply = DBresponse.newBuilder().setConfirmation(responseMessage).build();
      responseObserver.onNext(reply);
    } catch (Exception e) {
      responseObserver.onError(e);
    } finally {
      responseObserver.onCompleted();
    }

}

