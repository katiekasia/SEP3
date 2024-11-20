package via.pro3.mainserver.service;

import io.grpc.stub.StreamObserver;
import createBooking.grpc.CreateAppointment;
import createBooking.grpc.PatientBookingGrpc;
import createBooking.grpc.DBresponse;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import via.pro3.mainserver.DTOs.CreateAppointmentDto;
import via.pro3.mainserver.Model.*;
import via.pro3.mainserver.database.DatabaseInterface;
import via.pro3.mainserver.database.DatabaseSingleton;
import via.pro3.mainserver.database.EventInterface;
import via.pro3.mainserver.database.EventRepository;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

public class PatientImpl extends PatientBookingGrpc.PatientBookingImplBase {
    private final Model model;

  public PatientImpl(Model model)
  {
    this.model = model;
  }

  @Override public void createAppointment(CreateAppointment request, StreamObserver<DBresponse> responseObserver) {
      try {
        CreateAppointmentDto newAppointment = new CreateAppointmentDto(request.getType(),
            request.getDescription(), request.getStatus(),request.getPatientCpr(),request.getDoctorId(),
            request.getAppointmentDate(), request.getAppointmentTime());
        model.createAppointment(newAppointment);
      } catch (Exception e) {
          responseObserver.onError(e);
      } finally {
          responseObserver.onCompleted();
      }
  }
}

