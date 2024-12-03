package via.pro3.doctorserver;

import DTOs.DoctorDto;
import DTOs.LoginDto;
import DTOs.ResetPasswordDto;
import DTOs.ResponseDto;
import doctor.grpc.*;
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
    @PostMapping("/resetPassword")
    public ResponseDto changePassword(@RequestBody ResetPasswordDto resetPasswordDto) {
        if (resetPasswordDto == null) {
            throw new IllegalArgumentException("Invalid reset password");
        }
        try{
            ChangePasswordRequest request = ChangePasswordRequest
                    .newBuilder()
                    .setId(resetPasswordDto.getId())
                    .setCurrentPassword(resetPasswordDto.getCurrentPassword())
                    .setNewPassword(resetPasswordDto.getNewPassword())
                    .build();

            LoginDoctorResponse response = blockingStub.changePassword(request);

            ResponseDto responseDto = new ResponseDto();
            responseDto.setResponse(response.getConfirmation());
            return responseDto;
        }
        catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Reset password failed: " + e.getMessage());
        }
    }

    @PostMapping("/getDoctorById")
    public DoctorDto getDoctorById(@RequestBody String id){
        if(id == null || id.isEmpty()){
            throw new IllegalArgumentException("Invalid doctor id");
        }
        try{
            GetDoctorByIdRequest request = GetDoctorByIdRequest.newBuilder()
                    .setId(id)
                    .build();

            GetDoctorByIdResponse response = blockingStub.getDoctorById(request);

            DoctorDto doctorDto = new DoctorDto();
            doctorDto.setFirstname(response.getFirstname());
            doctorDto.setLastname(response.getLastname());
            doctorDto.setSpecialisation(response.getSpecialisation());
            return doctorDto;
        }
        catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Get doctor failed: " + e.getMessage());
        }
    }
}
