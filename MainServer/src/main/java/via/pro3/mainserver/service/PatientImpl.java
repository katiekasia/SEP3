package via.pro3.mainserver.service;

import io.grpc.stub.StreamObserver;
import createBooking.grpc.CreateAppointment;
import createBooking.grpc.PatientBookingGrpc;
import createBooking.grpc.DBresponse;
import via.pro3.mainserver.DTOs.CreateAppointmentDto;
import via.pro3.mainserver.Model.*;

public class PatientImpl extends PatientBookingGrpc.PatientBookingImplBase {
    private final Model model;

  public PatientImpl(Model model)
  {
    this.model = model;
  }

  @Override public void createAppointment(CreateAppointment request, StreamObserver<DBresponse> responseObserver) {
      try {
        System.out.println("rec");
        CreateAppointmentDto newAppointment = new CreateAppointmentDto(request.getType(),
            request.getDescription(), request.getStatus(),request.getPatientCpr(),request.getDoctorId(),
            request.getAppointmentDate(), request.getAppointmentTime());
        model.createAppointment(newAppointment);
      } catch (Exception e) {
          responseObserver.onError(e);
          e.printStackTrace();
      } finally {
          responseObserver.onCompleted();
      }
  }
}

