package via.pro3.mainserver.service;


import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import loginPatient.grpc.LoginPatientGrpc;
import loginPatient.grpc.LoginRequest;
import via.pro3.mainserver.DTOs.LoginDto;
import via.pro3.mainserver.DTOs.UserDto;
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

            UserDto userDto = model.loginPatient(loginDto);

            LoginResponse response = LoginResponse.newBuilder()
                .setName(userDto.getName())
                .setEmail(userDto.getEmail())
                .setPhone(userDto.getPhone())
                .setSurname(userDto.getSurname())
                .setCpr(userDto.getCpr())
                .build();

            responseObserver.onNext(response);
        } catch (Exception e) {
            e.printStackTrace();
            responseObserver.onError(
                Status.INTERNAL
                    .withDescription(e.getMessage())
                    .withCause(e)
                    .asRuntimeException()
            );
        }
finally {
            responseObserver.onCompleted();
        }
    }

}
