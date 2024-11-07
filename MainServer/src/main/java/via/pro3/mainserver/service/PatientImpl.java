package via.pro3.mainserver.service;

import com.google.type.DateTime;
import io.grpc.stub.StreamObserver;
import patient.grpc.PatientBookingGrpc;
import patient.grpc.bookingRequest;
import patient.grpc.DBresponse;
import via.pro3.mainserver.database.DatabaseInterface;
import via.pro3.mainserver.database.DatabaseSingleton;
import via.pro3.mainserver.database.EventInterface;
import via.pro3.mainserver.database.EventRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PatientImpl extends PatientBookingGrpc.PatientBookingImplBase{
  private final EventInterface eventRepository;

  public PatientImpl()
  {
    DatabaseInterface database = DatabaseSingleton.getInstance();
    this.eventRepository = new EventRepository(database);
  }

  @Override
  public void bookAppointment(bookingRequest request, StreamObserver<DBresponse> responseObserver)
  {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy h:mm:ss a");
    String dateString = request.getDateAndTime();
    LocalDateTime dateAndTime = LocalDateTime.parse(dateString, formatter);

    eventRepository.createAppointment(dateAndTime);

    String response = "Booking at: " + dateAndTime + " confirmed.";
    DBresponse reply = DBresponse.newBuilder().setConfirmation(response).build();

    System.out.println(response);
    responseObserver.onNext(reply);
    responseObserver.onCompleted();
  }

}

