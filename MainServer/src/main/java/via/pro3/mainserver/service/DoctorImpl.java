package via.pro3.mainserver.service;

import doctor.grpc.*;
import io.grpc.stub.StreamObserver;
import org.apache.juli.logging.Log;
import via.pro3.mainserver.DTOs.*;
import via.pro3.mainserver.Model.Model;
import via.pro3.mainserver.Model.Patient;

import java.util.ArrayList;
import java.util.List;

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
                    .setSpecialisation(model.getDoctorById(request.getId()).getSpecialisation())
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

    @Override
    public void getPatientsByDoctorId(GetPatientsRequest request, StreamObserver<GetPatientsResponse> responseObserver) {
        try {
            List<Patient> allPatients = model.getPatientsByDoctorId(request.getDoctorid());

            List<PatientDtoMessage> patientDtos = new ArrayList<>();
            for (Patient patient : allPatients) {
                System.out.println(patient.getCPRNo());
                System.out.println(patient.getName());
                System.out.println(patient.getSurname());
                System.out.println(patient.getEmail());
                System.out.println(patient.getPhone());
                PatientDtoMessage patientDto = PatientDtoMessage.newBuilder()
                        .setCpr(patient.getCPRNo())
                        .setFirstName(patient.getName())
                        .setLastName(patient.getSurname())
                        .setEmail(patient.getEmail())
                        .setPhoneNumber(patient.getPhone())
                        .build();

                patientDtos.add(patientDto);
            }

            GetPatientsResponse response = GetPatientsResponse.newBuilder()
                    .addAllPatients(patientDtos)
                    .build();

            responseObserver.onNext(response);
        } catch (Exception e) {
            e.printStackTrace();
            responseObserver.onError(new RuntimeException("Failed to fetch patients: " + e.getMessage()));
        } finally {
            responseObserver.onCompleted();
        }
    }

    @Override
    public void addPrescription(AddPrescriptionRequest request, StreamObserver<Response> responseObserver){
        try{
            PrescriptionDto prescriptionDto = new PrescriptionDto(
                    request.getId(), request.getDiagnosis(), request.getMedication(),
                    request.getRecommendations(), request.getDate(), request.getTime(),
                    request.getPatientcpr(), request.getDoctorid()
            );

            model.addPrescription(prescriptionDto);

            Response response = Response.newBuilder()
                    .setConfirmation("Success")
                    .build();
            responseObserver.onNext(response);
        }
        catch (Exception e){
            e.printStackTrace();
            Response response = Response.newBuilder().setConfirmation("Failed").build();
            responseObserver.onNext(response);
        }
        finally {
            responseObserver.onCompleted();
        }
    }
}
