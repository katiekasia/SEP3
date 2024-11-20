package via.pro3.mainserver.service;

import io.grpc.stub.StreamObserver;
import registerPatient.grpc.RegisterPatientGrpc;
import registerPatient.grpc.RegisterRequest;
import registerPatient.grpc.Response;
import via.pro3.mainserver.Model.Patient;
import via.pro3.mainserver.database.DatabaseInterface;
import via.pro3.mainserver.database.DatabaseSingleton;
import via.pro3.mainserver.database.EventInterface;
import via.pro3.mainserver.database.EventRepository;

public class RegisterPatientImpl extends RegisterPatientGrpc.RegisterPatientImplBase {
    private final EventInterface eventRepository;

    public RegisterPatientImpl() {
        DatabaseInterface database = DatabaseSingleton.getInstance();
        this.eventRepository = new EventRepository(database);
    }

    @Override
    public void registerPatient(RegisterRequest request, StreamObserver<Response> responseObserver) {
        try {
            Patient patient = new Patient(request.getName(),
                    request.getSurname(),
                    request.getPassword(),
                    request.getCPRNo(),
                    request.getPhone(),
                    request.getEmail());

            eventRepository.createUser(patient);

            Response response = Response.newBuilder()
                    .setConfirmation("Patient registered successfully")
                    .build();

            responseObserver.onNext(response);
        } catch (Exception e) {
            Response errorResponse = Response.newBuilder()
                    .setConfirmation("Registration failed: " + e.getMessage())
                    .build();

            responseObserver.onNext(errorResponse);
        }
        finally {
            responseObserver.onCompleted();
        }
    }
}