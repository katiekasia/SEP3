package via.pro3.patientsserver;

import DTOs.CreateAppointmentDto;
import DTOs.RegisterDto;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
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

    public Server() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
        blockingStub = PatientBookingGrpc.newBlockingStub(channel);
        registerBlockingStub = RegisterPatientGrpc.newBlockingStub(channel);
    }

  @PostMapping("/book")
  public CreateAppointmentDto bookAppointment(@RequestBody CreateAppointmentDto createAppointmentDto) {
    CreateAppointment request = CreateAppointment.newBuilder()
        .setDoctorId(createAppointmentDto.getDoctorId())
        .setStatus(createAppointmentDto.getStatus())
        .setDescription(createAppointmentDto.getDescription())
        .setType(createAppointmentDto.getType())
        .setPatientCpr(createAppointmentDto.getPatientCpr())
        .setAppointmentDate(createAppointmentDto.getAppointmentDateStr())
        .setAppointmentTime(createAppointmentDto.getAppointmentTimeStr())
        .build();

        DBresponse response = blockingStub.createAppointment(request);

        return createAppointmentDto;

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
}
