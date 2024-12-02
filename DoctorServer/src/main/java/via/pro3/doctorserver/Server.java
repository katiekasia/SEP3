package via.pro3.doctorserver;

import DTOs.LoginDto;
import DTOs.ResponseDto;
import doctor.grpc.DoctorGrpc;
import doctor.grpc.LoginDoctorRequest;
import doctor.grpc.LoginDoctorResponse;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Doctor")

public class Server {
    private final DoctorGrpc.DoctorBlockingStub blockingStub;

    public Server() {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        blockingStub = DoctorGrpc.newBlockingStub(channel);
    }

    @PostMapping("/login")
    public ResponseDto loginDoctor(@RequestBody LoginDto loginDto) {
        if (loginDto == null || loginDto.getcpr() == null || loginDto.getPassword() == null) {
            throw new IllegalArgumentException("Invalid login credentials");
        }

        try {
            LoginDoctorRequest request = LoginDoctorRequest.newBuilder()
                    .setId(loginDto.getcpr())
                    .setPassword(loginDto.getPassword())
                    .build();

            LoginDoctorResponse response = blockingStub.loginDoctor(request);

            ResponseDto responseDto = new ResponseDto();
            responseDto.setResponse(response.getConfirmation());

            return responseDto;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Login failed: " + e.getMessage());
        }
    }
}
