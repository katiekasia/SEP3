package via.pro3.mainserver.service;

import doctor.grpc.*;
import io.grpc.stub.StreamObserver;
import org.apache.juli.logging.Log;
import via.pro3.mainserver.DTOs.DoctorDto;
import via.pro3.mainserver.DTOs.LoginDto;
import via.pro3.mainserver.DTOs.ResetPasswordDto;
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

    @Override
    public void changePassword(ChangePasswordRequest request, StreamObserver<LoginDoctorResponse> responseObserver){
        try{
            ResetPasswordDto resetPasswordDto = new ResetPasswordDto(
                    request.getId(), request.getCurrentPassword(), request.getNewPassword()
            );
            LoginDoctorResponse response = LoginDoctorResponse.newBuilder()
                    .setConfirmation(model.changeDoctorPassword(resetPasswordDto))
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

    @Override
    public void getDoctorById(GetDoctorByIdRequest request, StreamObserver<GetDoctorByIdResponse> responseObserver){
        try{
            GetDoctorByIdResponse response = GetDoctorByIdResponse.newBuilder()
                    .setFirstname(model.getDoctorById(request.getId()).getName())
                    .setLastname(model.getDoctorById(request.getId()).getSurname())
                    .setSpecialisation(model.getDoctorById(request.getId()).getSpecialization())
                    .build();
            responseObserver.onNext(response);
        }
        catch (Exception e){
            e.printStackTrace();
            responseObserver.onNext(null);
        }
        finally {
            responseObserver.onCompleted();
        }
    }
}
