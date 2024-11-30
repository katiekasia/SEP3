package via.pro3.patientsserver;

import DTOs.CreateAppointmentDto;
import DTOs.LoginDto;
import DTOs.RegisterDto;
import DTOs.ResponseDto;
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
  public ResponseDto bookAppointment(@RequestBody CreateAppointmentDto createAppointmentDto) {

    CreateAppointment request = CreateAppointment.newBuilder()
        .setType(createAppointmentDto.getType())
        .setDescription(createAppointmentDto.getDescription())
        .setStatus(createAppointmentDto.getStatus())
        .setPatientCpr(createAppointmentDto.getPatientCpr())
        .setDoctorId(createAppointmentDto.getDoctorId())
        .setAppointmentDate(createAppointmentDto.getDate())
        .setAppointmentTime(createAppointmentDto.getTime())
        .build();

        DBresponse response = blockingStub.createAppointment(request);
    ResponseDto responseDto= new ResponseDto();
    responseDto.setResponse(response.getConfirmation());
        return responseDto;

    }

    @PostMapping("/register")
    public RegisterDto registerPatient(@RequestBody RegisterDto registerDto) {
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

    @PostMapping("/login")
    public ResponseDto loginPatient(@RequestBody LoginDto loginDto) {
        try {
            LoginRequest request = LoginRequest.newBuilder()
                    .setCpr(loginDto.getcpr())
                    .setPassword(loginDto.getPassword())
                    .build();

            LoginResponse response = loginBlockingStub.loginPatient(request);

            if (response.getConfirmation() == null){
                throw new RuntimeException("Patient login failed: " + response.getConfirmation());
            }
            ResponseDto responseDto = new ResponseDto();
            responseDto.setResponse(response.getConfirmation());
          System.out.println(response.getConfirmation());
            return responseDto;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error logging in", e);
        }
    }


}
