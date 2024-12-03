package via.pro3.patientsserver;

import Auth.PasswordHasher;
import DTOs.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import org.springframework.web.bind.annotation.*;
import patient.grpc.*;

@RestController
@RequestMapping("/Demo")
@CrossOrigin(origins = "*")
public class Server {
    private final PatientGrpc.PatientBlockingStub blockingStub;
    public Server() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
        blockingStub = PatientGrpc.newBlockingStub(channel);
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
    public ResponseDto  registerPatient(@RequestBody RegisterDto registerDto) {
        try {
            System.out.println(registerDto.getName());
            System.out.println(registerDto.getSurname());
            System.out.println(registerDto.getEmail());
            System.out.println(registerDto.getPassword());
            System.out.println(registerDto.getPhone());
            System.out.println(registerDto.getCprNo());

            String password = PasswordHasher.hash(registerDto.getPassword());
            RegisterRequest request = RegisterRequest.newBuilder()
                    .setName(registerDto.getName())
                    .setSurname(registerDto.getSurname())
                    .setEmail(registerDto.getEmail())
                    .setPhone(registerDto.getPhone())
                    .setPassword(password)
                    .setCPRNo(registerDto.getCprNo())
                    .build();

            DBresponse response = blockingStub.registerPatient(request);

            if (response.getConfirmation() == null){
                throw new RuntimeException("Patient registration failed: " + response.getConfirmation());
            }
            System.out.println("Got here");
            ResponseDto responseDto= new ResponseDto();
            responseDto.setResponse(response.getConfirmation());
            return responseDto;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error registering patient", e);
        }
    }

    @PostMapping("/login")
    public UserDto loginPatient(@RequestBody LoginDto loginDto) {
        try {


          PatientRequest request = PatientRequest.newBuilder()
                    .setCpr(loginDto.getcpr())
                    .build();

            LoginResponse response = blockingStub.loginPatient(request);

            if (PasswordHasher.validate(response.getPassword(), loginDto.getPassword()))
            {
              UserDto userDto = new UserDto();
              userDto.setName(response.getName());
              userDto.setEmail(response.getEmail());
              userDto.setPhone(response.getPhone());
              userDto.setSurname(response.getSurname());
              userDto.setCpr(response.getCpr());

              return userDto;
            }else {
              throw new RuntimeException("Invalid credentials");
            }
        } catch (StatusRuntimeException e) {
            e.printStackTrace();
            throw new RuntimeException("Error logging in", e);
        }catch (Exception e) {
          e.printStackTrace();
          throw new RuntimeException("Error logging in", e);
        }
    }
}
