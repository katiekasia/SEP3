package via.pro3.mainserver.service;

import io.grpc.stub.StreamObserver;
import loginDoctor.grpc.LoginDoctorGrpc;
import loginDoctor.grpc.LoginDoctorRequest;
import loginDoctor.grpc.LoginDoctorResponse;
import via.pro3.mainserver.DTOs.LoginDto;
import via.pro3.mainserver.Model.Model;

public class DoctorLoginImpl extends LoginDoctorGrpc.LoginDoctorImplBase {
    private final Model model;

    public DoctorLoginImpl(Model model) {
        this.model = model;
    }

    @Override
    public void loginDoctor(LoginDoctorRequest request, StreamObserver<LoginDoctorResponse> responseObserver){
        try{
            LoginDto loginDto = new LoginDto(request.getId(), request.getPassword());

            LoginDoctorResponse response = LoginDoctorResponse.newBuilder()
                    .setConfirmation(model.loginDoctor(loginDto))
                    .build();

            responseObserver.onNext(response);
        }
        catch (Exception e){
            e.printStackTrace();
            LoginDoctorResponse loginDoctorResponse = LoginDoctorResponse.newBuilder()
                    .setConfirmation("Login failed").build();
            responseObserver.onNext(loginDoctorResponse);
        }
        finally {
            responseObserver.onCompleted();
        }
    }
}
