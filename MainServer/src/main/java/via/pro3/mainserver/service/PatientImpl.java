package via.pro3.mainserver.service;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import patient.grpc.*;

import via.pro3.mainserver.DTOs.CreateAppointmentDto;
import via.pro3.mainserver.DTOs.LoginDto;
import via.pro3.mainserver.DTOs.RegisterDto;
import via.pro3.mainserver.DTOs.UserDto;
import via.pro3.mainserver.Model.*;
import via.pro3.mainserver.Model.Patient;

public class PatientImpl extends PatientGrpc.PatientImplBase {
    private final Model model;

    public PatientImpl(Model model) {
        this.model = model;
    }

    @Override
    public void createAppointment(patient.grpc.CreateAppointment request, StreamObserver<DBresponse> responseObserver) {
        try {

            CreateAppointmentDto newAppointment = new CreateAppointmentDto(request.getType(),
                    request.getDescription(), request.getStatus(), request.getPatientCpr(), request.getDoctorId(),
                    request.getAppointmentDate(), request.getAppointmentTime());


            DBresponse response = DBresponse.newBuilder()
                    .setConfirmation(model.createAppointment(newAppointment))
                    .build();

            // Send the response to the client
            responseObserver.onNext(response);

        } catch (Exception e) {
            responseObserver.onError(e);
            e.printStackTrace();
        } finally {
            responseObserver.onCompleted();
        }
    }

    @Override
    public void loginPatient(PatientRequest request, StreamObserver<LoginResponse> responseObserver) {
        try {
            LoginDto loginDto = new LoginDto(request.getCpr(), null);

            Patient patient = model.loginPatient(loginDto);

            LoginResponse response = LoginResponse.newBuilder()
                    .setName(patient.getName())
                    .setEmail(patient.getEmail())
                    .setPhone(patient.getPhone())
                    .setSurname(patient.getSurname())
                    .setCpr(patient.getCPRNo())
                    //.setPassword(patient.getPassword())
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
        } finally {
            responseObserver.onCompleted();
        }
    }
    @Override
    public void registerPatient(RegisterRequest request, StreamObserver<DBresponse> responseObserver) {
        try {
            RegisterDto registerDto = new RegisterDto(request.getName(), request.getSurname(), request.getEmail(),
                    request.getPhone(), request.getPassword(), request.getCPRNo());
            model.registerPatient(registerDto);
            responseObserver.onNext(DBresponse.newBuilder().build());
        } catch (Exception e) {
            DBresponse errorResponse = DBresponse.newBuilder()
                    .setConfirmation("Registration failed: " + e.getMessage())
                    .build();

            responseObserver.onNext(errorResponse);
        }
        finally {
            responseObserver.onCompleted();
        }
    }
}

