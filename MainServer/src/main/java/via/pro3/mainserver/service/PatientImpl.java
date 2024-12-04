package via.pro3.mainserver.service;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import patient.grpc.*;

import via.pro3.mainserver.DTOs.CreateAppointmentDto;
import via.pro3.mainserver.DTOs.LoginDto;
import via.pro3.mainserver.DTOs.RegisterDto;
import via.pro3.mainserver.DTOs.UpdatePatientDto;
import via.pro3.mainserver.Model.*;
import via.pro3.mainserver.Model.Patient;
import via.pro3.mainserver.database.EventRepository;

import java.util.List;

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
                    .setPassword(patient.getPassword())
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
            System.out.println("impl is here");

            model.registerPatient(registerDto);

            responseObserver.onNext(DBresponse.newBuilder().build());
        } catch (Exception e) {
            e.printStackTrace();
            DBresponse errorResponse = DBresponse.newBuilder()
                    .setConfirmation("Registration failed: " + e.getMessage())
                    .build();

            responseObserver.onNext(errorResponse);
        }
        finally {
            responseObserver.onCompleted();
        }
    }

        @Override
        public void getAppointmentsByPatientCpr(GetAppointmentsRequest request, StreamObserver<GetAppointmentsResponse> responseObserver) {
            try {
                List<Appointment> appointments = model.getPatientAppointments(request.getPatientCpr());
                GetAppointmentsResponse.Builder responseBuilder = GetAppointmentsResponse.newBuilder();

                for (Appointment appointment : appointments) {
                    Clinic clinic = appointment.getClinic();
                    Doctor doctor = model.getDoctorById(model.getDoctorByClinicName(clinic.getName()));

                    AppointmentInfo appointmentInfo = AppointmentInfo.newBuilder()
                        .setId(appointment.getAppointmentId())
                        .setDescription(appointment.getDescription())
                        .setType(appointment.getType())
                        .setDate(appointment.getDate().toString())
                        .setTime(appointment.getTime().toString())
                        .setStatus(appointment.getStatus())
                        .setDoctorId(doctor.getId())
                        .setDoctorFirstName(doctor.getName())
                        .setDoctorLastName(doctor.getSurname())
                        .setDoctorSpecialization(doctor.getSpecialisation())
                        .setClinicName(clinic.getName())
                        .setClinicStreet(clinic.getStreet())
                        .setClinicStreetNumber(clinic.getStreetNo())
                        .setClinicCity(clinic.getCity())
                        .build();

                    responseBuilder.addAppointments(appointmentInfo);
                }

                responseObserver.onNext(responseBuilder.build());
                responseObserver.onCompleted();
            } catch (Exception e) {
                responseObserver.onError(Status.INTERNAL
                    .withDescription("Error fetching appointments: " + e.getMessage())
                    .withCause(e)
                    .asRuntimeException());
            }
        }


    @Override
    public void updateUser(UpdateUserRequest request, StreamObserver<DBresponse> responseObserver) {
        try {
            UpdatePatientDto updatePatientDto = new UpdatePatientDto(
                    request.getCPR(),
                    request.getSurname(),
                    request.getPhone(),
                    request.getEmail(),
                    request.getOldPassword(),
                    request.getNewPassword()
            );

            String result = model.updatePatient(updatePatientDto);

            DBresponse response = DBresponse.newBuilder()
                    .setConfirmation(result)
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

}


