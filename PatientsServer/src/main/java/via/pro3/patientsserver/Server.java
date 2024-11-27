package via.pro3.patientsserver;

import DTOs.CreateAppointmentDto;
import DTOs.LoginDto;
import DTOs.RegisterDto;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import loginPatient.grpc.LoginPatientGrpc;
import loginPatient.grpc.LoginRequest;
import loginPatient.grpc.LoginResponse;
import org.springframework.web.bind.annotation.*;
import createBooking.grpc.DBresponse;
import createBooking.grpc.PatientBookingGrpc;
import createBooking.grpc.CreateAppointment;
import registerPatient.grpc.RegisterPatientGrpc;
import registerPatient.grpc.RegisterRequest;
import registerPatient.grpc.Response;

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
        System.out.println("here");
        CreateAppointment request = CreateAppointment.newBuilder()
                .setDoctorId(createAppointmentDto.getDoctorId())
                .setStatus(createAppointmentDto.getStatus())
                .setDescription(createAppointmentDto.getDescription())
                .setType(createAppointmentDto.getType())
                .setPatientCpr(createAppointmentDto.getPatientCpr())
                .setAppointmentDate(createAppointmentDto.getDate())
                .setAppointmentTime(createAppointmentDto.getTime())
                .build();
        System.out.println("before res");
        DBresponse response = blockingStub.createAppointment(request);
        System.out.println("sent");

        return createAppointmentDto;

    }

    @PostMapping("/register")
    public RegisterDto registerPatient(@RequestBody RegisterDto registerDto) {
        try {
            RegisterRequest request = RegisterRequest.newBuilder()
                    .setName(registerDto.getName())
                    .setSurname(registerDto.getSurname())
                    .setEmail(registerDto.getEmail())
                    .setPhone(registerDto.getPhone())
                    .setPassword(registerDto.getPassword())
                    .setCPRNo(registerDto.getCprNo())
                    .build();

            Response response = registerBlockingStub.registerPatient(request);

            if (response.getConfirmation() == null) {
                throw new RuntimeException("Patient registration failed: " + response.getConfirmation());
            }
            System.out.println("Got here");

            return registerDto;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error registering patient", e);
        }
    }

    @PostMapping("/login")
    public String loginPatient(@RequestBody LoginDto loginDto) {
        System.out.println(loginDto.getcpr());
        System.out.println(loginDto.getPassword());
        try {
            LoginRequest request = LoginRequest.newBuilder()
                    .setCpr(loginDto.getcpr())
                    .setPassword(loginDto.getPassword())
                    .build();

            LoginResponse response = loginBlockingStub.loginPatient(request);

            if (response.getConfirmation() == null) {
                throw new RuntimeException("Patient login failed: " + response.getConfirmation());
            }

            System.out.println(response.getConfirmation());
            return response.getConfirmation();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error logging in", e);
        }
    }
}
