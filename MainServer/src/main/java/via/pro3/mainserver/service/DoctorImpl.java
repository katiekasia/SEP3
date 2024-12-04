package via.pro3.mainserver.service;

import doctor.grpc.*;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.apache.juli.logging.Log;
import patient.grpc.AppointmentInfo;
import patient.grpc.GetAppointmentsResponse;
import patient.grpc.PatientRequest;
import via.pro3.mainserver.DTOs.DoctorDto;
import via.pro3.mainserver.DTOs.LoginDto;
import via.pro3.mainserver.DTOs.ResetPasswordDto;
import via.pro3.mainserver.Model.*;

import java.util.List;

public class DoctorImpl extends DoctorGrpc.DoctorImplBase
{
  private final Model model;

  public DoctorImpl(Model model)
  {
    this.model = model;
  }

  @Override public void loginDoctor(GetDoctorByIdRequest request,
      StreamObserver<LoginDoctorResponse> responseObserver)
  {
    try
    {
      LoginDto loginDto = new LoginDto(request.getId(), null);

      Doctor doctor = model.loginDoctor(loginDto);
      LoginDoctorResponse response = LoginDoctorResponse.newBuilder()
          .setId(doctor.getId()).setName(doctor.getName())
          .setSurname(doctor.getSurname())
          .setSpecialisation(doctor.getSpecialisation())
          .setPassword(doctor.getPassword())
          .build();

      responseObserver.onNext(response);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      responseObserver.onError(
          Status.INTERNAL.withDescription(e.getMessage()).withCause(e)
              .asRuntimeException());
    }
    finally
    {
      responseObserver.onCompleted();
    }
  }

  @Override public void changePassword(ChangePasswordRequest request,
      StreamObserver<UniResponse> responseObserver)
  {
    try
    {
      ResetPasswordDto resetPasswordDto = new ResetPasswordDto(request.getId(),
          request.getNewPassword());
      UniResponse response = UniResponse.newBuilder()
          .setInfo(model.changeDoctorPassword(resetPasswordDto))
          .build();
      responseObserver.onNext(response);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      UniResponse loginDoctorResponse = UniResponse.newBuilder()
          .setInfo("Failed").build();
      responseObserver.onNext(loginDoctorResponse);
    }
    finally
    {
      responseObserver.onCompleted();
    }
  }

  @Override public void getDoctorById(GetDoctorByIdRequest request,
      StreamObserver<GetDoctorByIdResponse> responseObserver)
  {
    try
    {
      GetDoctorByIdResponse response = GetDoctorByIdResponse.newBuilder()
          .setFirstname(model.getDoctorById(request.getId()).getName())
          .setLastname(model.getDoctorById(request.getId()).getSurname())
          .setSpecialisation(
              model.getDoctorById(request.getId()).getSpecialisation()).build();
      responseObserver.onNext(response);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      responseObserver.onNext(null);
    }
    finally
    {
      responseObserver.onCompleted();
    }
  }

  @Override public void getAppointmentsByDoctorId(GetDoctorByIdRequest request, StreamObserver<GetAppointmentsResponseD> responseObserver) {
    try {
      List<Appointment> appointments = model.getDoctorAppointments(request.getId());
      GetAppointmentsResponseD.Builder responseBuilder = GetAppointmentsResponseD.newBuilder();

      System.out.println("IMPL called");
      for (Appointment appointment : appointments) {
        System.out.println("CREATED IMPL");
        Patient patient = model.getPatientByAppointmentId(appointment.getAppointmentId());

        AppointmentInfoD appointmentInfo = AppointmentInfoD.newBuilder()
            .setId(appointment.getAppointmentId())
            .setDescription(appointment.getDescription())
            .setType(appointment.getType())
            .setDate(appointment.getDate().toString())
            .setTime(appointment.getTime().toString())
            .setStatus(appointment.getStatus())
            .setPatientCpr(patient.getCPRNo())
            .setPatientFirstName(patient.getName())
            .setPatientLastName(patient.getSurname())
            .setPatientEmail(patient.getEmail())
            .setPatientPhone(patient.getPhone())
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
}
