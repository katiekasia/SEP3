package via.pro3.mainserver.service;


import io.grpc.stub.StreamObserver;
import loginPatient.grpc.LoginPatientGrpc;
import loginPatient.grpc.LoginRequest;
import via.pro3.mainserver.DTOs.LoginDto;
import via.pro3.mainserver.Model.Model;
import loginPatient.grpc.loginResponse;



public class LoginImpl extends LoginPatientGrpc.LoginPatientImplBase
{
    private final Model model;

    public LoginImpl(Model model)
    {
        this.model = model;
    }

    @Override
    public void loginPatient(LoginRequest request, StreamObserver<loginResponse> responseObserver)
    {
        try{
            LoginDto loginDto = new LoginDto(request.getCpr(), request.getPassword());


            loginResponse response = loginResponse.newBuilder()
                    .setConfirmation(model.loginPatient(loginDto))
                            .build();
            responseObserver.onNext(response);
        } catch (Exception e) {
            loginResponse loginResponse = loginPatient.grpc.loginResponse.newBuilder().setConfirmation("login failed")
                    .build();
        }
finally {
            responseObserver.onCompleted();
        }
    }

}
