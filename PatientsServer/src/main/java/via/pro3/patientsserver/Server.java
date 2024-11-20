package via.pro3.patientsserver;

import DTOs.CreateAppointmentDto;
import DTOs.LoginDto;
import DTOs.RegisterDto;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import loginPatient.grpc.LoginPatientGrpc;
import org.springframework.web.bind.annotation.*;
import createBooking.grpc.DBresponse;
import createBooking.grpc.PatientBookingGrpc;
import createBooking.grpc.CreateAppointment;
import registerPatient.grpc.RegisterPatientGrpc;
import registerPatient.grpc.RegisterRequest;
import registerPatient.grpc.Response;
import loginPatient.grpc.LoginPatientGrpc;
import loginPatient.grpc.LoginRequest;
import loginPatient.grpc.loginResponse;

@RestController
@RequestMapping("/Demo")
@CrossOrigin(origins = "*")
public class Server {
    private final PatientBookingGrpc.PatientBookingBlockingStub blockingStub;
    private final RegisterPatientGrpc.RegisterPatientBlockingStub registerBlockingStub;
    private final LoginPatientGrpc.LoginPatientBlockingStub loginBlockingStub;

    public Server() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
        blockingStub = PatientBookingGrpc.newBlockingStub(channel);
        registerBlockingStub = RegisterPatientGrpc.newBlockingStub(channel);
        loginBlockingStub = LoginPatientGrpc.newBlockingStub(channel);
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

    @PostMapping("/login")
    public LoginDto loginPatient(@RequestBody LoginDto loginDto) {
        try {
            LoginRequest request = LoginRequest.newBuilder()
                    .setCpr(loginDto.getCpr())
                    .setPassword(loginDto.getPassword())
                    .build();

            loginResponse response = loginBlockingStub.loginPatient(request);

            if (response.getConfirmation() == null){
                throw new RuntimeException("Patient login failed: " + response.getConfirmation());
            }
            System.out.println("Got here");

            return loginDto;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error login patient", e);
        }
    }
    @PostMapping("/register")
    public RegisterDto registerPatient(@RequestBody RegisterDto registerDto) {
    {
        try {
            System.out.println(registerDto.getName());
            System.out.println(registerDto.getSurname());
            System.out.println(registerDto.getEmail());
            System.out.println(registerDto.getPassword());
            System.out.println(registerDto.getPhone());
            System.out.println(registerDto.getCprNo());
            RegisterRequest request = RegisterRequest.newBuilder()
                    .setName(registerDto.getName())
                    .setSurname(registerDto.getSurname())
                    .setEmail(registerDto.getEmail())
                    .setPhone(registerDto.getPhone())
                    .setPassword(registerDto.getPassword())
                    .setCPRNo(registerDto.getCprNo())
                    .build();

            Response response = registerBlockingStub.registerPatient(request);

            if (response.getConfirmation() == null){
                throw new RuntimeException("Patient registration failed: " + response.getConfirmation());
            }
            System.out.println("Got here");

            return registerDto;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error registering patient", e);
        }
    }
}
    }
