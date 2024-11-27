package via.pro3.mainserver.service;


import io.grpc.stub.StreamObserver;
import loginPatient.grpc.LoginPatientGrpc;
import loginPatient.grpc.LoginRequest;
import via.pro3.mainserver.DTOs.LoginDto;
import via.pro3.mainserver.Model.Model;
import loginPatient.grpc.LoginResponse;



public class LoginImpl extends LoginPatientGrpc.LoginPatientImplBase
{
    private final Model model;

    public LoginImpl(Model model)
    {
        this.model = model;
    }

    @Override
    public void loginPatient(LoginRequest request, StreamObserver<LoginResponse> responseObserver)
    {
        try{
            LoginDto loginDto = new LoginDto(request.getCpr(), request.getPassword());
            System.out.println(loginDto.getcpr() + " in impl");

            LoginResponse response = LoginResponse.newBuilder()
                    .setConfirmation(model.loginPatient(loginDto))
                            .build();
            responseObserver.onNext(response);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
            LoginResponse loginResponse = LoginResponse.newBuilder().setConfirmation("login failed")
                    .build();
            responseObserver.onNext(loginResponse);
        }
finally {
            responseObserver.onCompleted();
        }
    }

}
