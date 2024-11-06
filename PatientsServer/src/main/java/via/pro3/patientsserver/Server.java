package via.pro3.patientsserver;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.web.bind.annotation.*;
import patient.grpc.DBresponse;
import patient.grpc.PatientBookingGrpc;
import patient.grpc.bookingRequest;

import java.time.LocalDateTime;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/BookingPage")
public class Server
{
  private PatientBookingGrpc.PatientBookingBlockingStub blockingStub;
  public Server(){
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();

    blockingStub = PatientBookingGrpc.newBlockingStub(channel);
  }

  @GetMapping("/book")
  public String BookAppointment(@RequestParam String  dateAndTime)
  {
    System.out.println("Client connected at: " + LocalDateTime.now());

    bookingRequest request = bookingRequest.newBuilder().setDateAndTime(dateAndTime).build();

    DBresponse response = blockingStub.bookAppointment(request);

    return "Data: " + response.toString();}
}
