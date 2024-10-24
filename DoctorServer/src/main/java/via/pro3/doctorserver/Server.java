package via.pro3.doctorserver;
import example.grpc.GreeterGrpc;
import example.grpc.HelloReply;
import example.grpc.HelloRequest;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/doctorname")

public class Server {
  private GreeterGrpc.GreeterBlockingStub blockingStub;
  public Server() {
    ManagedChannel channel = ManagedChannelBuilder
            .forAddress("localhost", 9090)
            .usePlaintext()
            .build();

    blockingStub = GreeterGrpc.newBlockingStub(channel);
  }

  @GetMapping("/name")
  public String getDoctorName(@RequestParam String name) {
    System.out.println("Client connected at: " + LocalDateTime.now() + " - Received name: " + name);
    HelloRequest request = HelloRequest.newBuilder()
            .setName(name)
            .build();

    HelloReply response = blockingStub.sayHello(request);
    return "Hello, " + response.getMessage();
  }
}
