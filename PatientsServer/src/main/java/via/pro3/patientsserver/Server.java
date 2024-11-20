package via.pro3.patientsserver;

import DTOs.CreateAppointmentDto;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.web.bind.annotation.*;
import createBooking.grpc.DBresponse;
import createBooking.grpc.PatientBookingGrpc;
import createBooking.grpc.CreateAppointment;




@RestController
@RequestMapping("/Demo")
@CrossOrigin(origins = "*")
public class Server {
  private final PatientBookingGrpc.PatientBookingBlockingStub blockingStub;

  public Server() {
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
    blockingStub = PatientBookingGrpc.newBlockingStub(channel);
  }

  @PostMapping("/book")
  public CreateAppointmentDto bookAppointment(@RequestBody CreateAppointmentDto createAppointmentDto) {
    CreateAppointment request = CreateAppointment.newBuilder()
        .setCity(createAppointmentDto.getCity())
        .setStatus(createAppointmentDto.getStatus())
        .setDescription(createAppointmentDto.getDescription())
        .setSpecialization(createAppointmentDto.getSpecialization())
        .build();

    DBresponse response = blockingStub.createAppointment(request);

    return createAppointmentDto;

  }
}
