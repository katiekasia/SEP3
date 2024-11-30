package via.pro3.doctorserver;

import DTOs.LoginDto;
import DTOs.ResponseDto;
import loginDoctor.grpc.LoginDoctorGrpc;
import loginDoctor.grpc.LoginDoctorRequest;
import loginDoctor.grpc.LoginDoctorResponse;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Doctor")

public class Server {
    private final LoginDoctorGrpc.LoginDoctorBlockingStub loginDoctorBlockingStub;

    public Server() {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        loginDoctorBlockingStub = LoginDoctorGrpc.newBlockingStub(channel);
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

            LoginDoctorResponse response = loginDoctorBlockingStub.loginDoctor(request);

            ResponseDto responseDto = new ResponseDto();
            responseDto.setResponse(response.getConfirmation());

            return responseDto;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Login failed: " + e.getMessage());
        }
    }
}
