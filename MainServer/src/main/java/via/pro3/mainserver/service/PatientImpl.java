package via.pro3.mainserver.service;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import patient.grpc.*;

import via.pro3.mainserver.DTOs.CreateAppointmentDto;
import via.pro3.mainserver.DTOs.LoginDto;
import via.pro3.mainserver.DTOs.RegisterDto;
import via.pro3.mainserver.DTOs.UpdatePatientDto;
import via.pro3.mainserver.DTOs.*;
import via.pro3.mainserver.Model.*;
import via.pro3.mainserver.Model.Clinic;
import via.pro3.mainserver.Model.Doctor;
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

            System.out.println(patient.getPassword());
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
    public void registerPatient(RegisterRequest request, StreamObserver<DBresponse> responseObserver)
    {
        try
        {
            RegisterDto registerDto = new RegisterDto(request.getName(),
                request.getSurname(), request.getEmail(), request.getPhone(),
                request.getPassword(), request.getCPRNo());
            System.out.println("impl is here");

            model.registerPatient(registerDto);

            responseObserver.onNext(DBresponse.newBuilder().build());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            DBresponse errorResponse = DBresponse.newBuilder()
                .setConfirmation("Registration failed: " + e.getMessage())
                .build();

            responseObserver.onNext(errorResponse);
        }
        finally
        {
            responseObserver.onCompleted();
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


    @Override
    public void getCities(GetCities request, StreamObserver<CityListResponse> responseObserver) {
        try {
            System.out.println("impl is here");
            List<CityDto> cities = model.getCities();

            CityListResponse.Builder responseBuilder = CityListResponse.newBuilder();

            for (CityDto city : cities) {
                CityRequest info = CityRequest.newBuilder()
                    .setName(city.getCity())
                    .setPostalcode(city.getCode())
                    .build();

                responseBuilder.addCities(info);
            }
            responseObserver.onNext(responseBuilder.build());
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
    public void getClinics(CityRequest request, StreamObserver<ClinicListResponse> responseObserver) {
        try {
            System.out.println("impl code");
            List<Clinic> clinics = model.getClinicByCity(request.getPostalcode());
            ClinicListResponse.Builder responseBuilder = ClinicListResponse.newBuilder();
            for (Clinic clinic : clinics) {
                patient.grpc.Clinic info = patient.grpc.Clinic.newBuilder()
                    .setId(clinic.getId())
                    .setName(clinic.getName())
                    .setAddress(clinic.getAddress()).build();
                responseBuilder.addClinics(info);
            }
            responseObserver.onNext(responseBuilder.build());
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
    public void getDoctors(patient.grpc.Clinic request, StreamObserver<DoctorListResponse> responseObserver) {
        try {
            System.out.println("PATEINTIMPL DOCTOR");
            List<Doctor> doctors = model.getDoctorByClinic(request.getId());
            DoctorListResponse.Builder responseBuilder = DoctorListResponse.newBuilder();
            for (Doctor doctor : doctors) {
                patient.grpc.DoctorRequest info = patient.grpc.DoctorRequest.newBuilder()
                    .setId(doctor.getId())
                    .setFirstname(doctor.getName())
                    .setLastname(doctor.getSurname())
                    .setSpecialisation(doctor.getSpecialization())
                    .build();
                System.out.println("specialization" + doctor.getSpecialization());
                responseBuilder.addDoctor(info);
            }
            responseObserver.onNext(responseBuilder.build());
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
    public void cancelAppointment(CancelAppointmentRequest request, StreamObserver<DBresponse> responseObserver) {
        try {

            model.cancelAppointment(request.getAppointmentId(), request.getPatientCpr());

            DBresponse response = DBresponse.newBuilder()
                .setConfirmation("Appointment cancelled successfully")
                .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (IllegalStateException e) {

            responseObserver.onError(Status.FAILED_PRECONDITION
                .withDescription(e.getMessage())
                .asRuntimeException());
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL
                .withDescription("Error cancelling appointment: " + e.getMessage())
                .asRuntimeException());
        }
    }


    @Override
    public void getAppointmentsByPatientCpr(PatientRequest request, StreamObserver<GetAppointmentsResponse> responseObserver) {
        try {
            List<Appointment> appointments = model.getPatientAppointments(request.getCpr());
            GetAppointmentsResponse.Builder responseBuilder = GetAppointmentsResponse.newBuilder();

            for (Appointment appointment : appointments) {
                Clinic clinic = appointment.getClinic();
                Doctor doctor = model.getDoctorById(model.getDoctorByClinicName(clinic.getName()));

                AppointmentInfo appointmentInfo = AppointmentInfo.newBuilder()
                    .setId(appointment.getAppointmentId())
                    .setStatus(appointment.getStatus())
                    .setDescription(appointment.getDescription())
                    .setType(appointment.getType())
                    .setDate(appointment.getDate().toString())
                    .setTime(appointment.getTime().toString())
                    .setDoctorId(doctor.getId())
                    .setDoctorFirstName(doctor.getName())
                    .setDoctorLastName(doctor.getSurname())
                    .setDoctorSpecialization(doctor.getSpecialization())
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
                .asRuntimeException());
        }
    }



}


