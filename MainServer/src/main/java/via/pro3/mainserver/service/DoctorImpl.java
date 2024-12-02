package via.pro3.mainserver.service;

import doctor.grpc.DoctorGrpc;
import doctor.grpc.LoginDoctorRequest;
import doctor.grpc.LoginDoctorResponse;
import io.grpc.stub.StreamObserver;
import via.pro3.mainserver.DTOs.LoginDto;
import via.pro3.mainserver.Model.Model;

public class DoctorImpl extends DoctorGrpc.DoctorImplBase {
    private final Model model;

    public DoctorImpl(Model model) {
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
                    .setConfirmation("Failed").build();
            responseObserver.onNext(loginDoctorResponse);
        }
        finally {
            responseObserver.onCompleted();
        }
    }
}
