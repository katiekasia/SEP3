package via.pro3.doctorserver;

import example.grpc.ProtoGrpc;
import example.grpc.loginResponse;
import example.grpc.loginRequest;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/doctorname")

public class Server {

    private ProtoGrpc.ProtoBlockingStub blockingStub;

    public Server() {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        blockingStub = ProtoGrpc.newBlockingStub(channel);
    }

    @GetMapping("/name/password")
    public String getDoctorName(@RequestParam String name, @RequestParam String password) {
        System.out.println("Client connected at: " + LocalDateTime.now());

        loginRequest request = loginRequest.newBuilder()
                .setEmail(name)
                .setPassword(password)
                .build();

        loginResponse response = blockingStub.loginDoctor(request);
        return "Hello, " + response.getEmail();
    }
}
