package via.pro3.mainserver.service;

import io.grpc.stub.StreamObserver;
import patient.grpc.PatientBookingGrpc;
import patient.grpc.bookingRequest;
import patient.grpc.DBresponse;
import via.pro3.mainserver.DatabaseSingleton;
import via.pro3.mainserver.EventRepository;

public class PatientImpl extends PatientBookingGrpc.PatientBookingImplBase{
  private final EventRepository eventRepository;

  public PatientImpl()
  {
    DatabaseSingleton database = DatabaseSingleton.getInstance();
    this.eventRepository = new EventRepository(database);
  }

  @Override
  public void bookAppointment(bookingRequest request, StreamObserver<DBresponse> responseObserver)
  {
    String dateAndTime = request.getDateAndTime().toString();

    //
    String response = "Booking at: " + dateAndTime + " confirmed.";
    DBresponse reply = DBresponse.newBuilder().setConfirmation(response).build();

    System.out.println(response);
    responseObserver.onNext(reply);
    responseObserver.onCompleted();
  }

}

