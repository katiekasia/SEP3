package via.pro3.mainserver.service;

import io.grpc.stub.StreamObserver;
import patient.grpc.Patient;
import patient.grpc.PatientProtoGrpc;
import patient.grpc.dataRequest;
import patient.grpc.DBresponse;
import via.pro3.mainserver.DatabaseSingleton;
import via.pro3.mainserver.EventRepository;

public class PatientImpl extends PatientProtoGrpc.PatientProtoImplBase{
  private final EventRepository eventRepository;

  public PatientImpl()
  {
    DatabaseSingleton database = DatabaseSingleton.getInstance();
    this.eventRepository = new EventRepository(database);
  }

  @Override
  public void fetchData(dataRequest request, StreamObserver<DBresponse> responseObserver)
  {
    String name = request.getEmail().toString();

    //
    String greeting = "Hello " + name + "!";
    DBresponse reply = DBresponse.newBuilder().setEmail(greeting).setPassword("1").setUserid("1").build();

    responseObserver.onNext(reply);
    responseObserver.onCompleted();
  }

}

