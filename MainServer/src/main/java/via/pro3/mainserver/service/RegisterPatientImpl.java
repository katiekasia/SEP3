package via.pro3.mainserver.service;

import io.grpc.stub.StreamObserver;
import registerPatient.grpc.RegisterPatientGrpc;
import registerPatient.grpc.RegisterRequest;
import registerPatient.grpc.Response;
import via.pro3.mainserver.DTOs.RegisterDto;
import via.pro3.mainserver.Model.Model;
import via.pro3.mainserver.Model.Patient;
import via.pro3.mainserver.database.DatabaseInterface;
import via.pro3.mainserver.database.DatabaseSingleton;
import via.pro3.mainserver.database.EventInterface;
import via.pro3.mainserver.database.EventRepository;

public class RegisterPatientImpl extends RegisterPatientGrpc.RegisterPatientImplBase {
    private final Model model;

    public RegisterPatientImpl(Model model) {
        this.model = model;
    }

    @Override
    public void registerPatient(RegisterRequest request, StreamObserver<Response> responseObserver) {
        try {
            RegisterDto registerDto = new RegisterDto(request.getName(), request.getSurname(), request.getEmail(),
                request.getPhone(), request.getPassword(), request.getCPRNo());
            model.registerPatient(registerDto);
            responseObserver.onNext(Response.newBuilder().build());
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