package via.pro3.patientsserver;

import Auth.PasswordHasher;
import DTOs.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import org.springframework.web.bind.annotation.*;
import patient.grpc.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Demo")
@CrossOrigin(origins = "*")
public class Server {
    private final PatientGrpc.PatientBlockingStub blockingStub;
    public Server() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
        blockingStub = PatientGrpc.newBlockingStub(channel);
import java.util.ArrayList;
import java.util.List;

@RestController @RequestMapping("/Demo") @CrossOrigin(origins = "*") public class Server
{
  private final PatientGrpc.PatientBlockingStub blockingStub;

  public Server()
  {
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
        .usePlaintext().build();
    blockingStub = PatientGrpc.newBlockingStub(channel);
  }
  @CrossOrigin(origins = "*")

  @GetMapping("/cities") public List<CityDto> getCities()
  {

    try
    {
      GetCities request = GetCities.newBuilder().build();
      CityListResponse response = blockingStub.getCities(request);
      List<CityDto> cityDtos = new ArrayList<>();

      for (CityRequest city : response.getCitiesList()){
        CityDto dto = new CityDto(
            city.getName(),
            city.getPostalcode()
        );
        cityDtos.add(dto);
      }

      return cityDtos;

    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RuntimeException("Error getting cities", e);
    }

  }

  @GetMapping("/clinics") public List<ClinicDto> getClinicsByCity(@RequestParam String code)
  {
    System.out.println(code);
    try
    {
      System.out.println("CALLED clinic");
      CityRequest request = CityRequest.newBuilder()
          .setName("")
          .setPostalcode(code)
          .build();
      ClinicListResponse response = blockingStub.getClinics(request);
      List<ClinicDto> clinics = new ArrayList<>();

      for(Clinic clinic : response.getClinicsList()){
        ClinicDto dto = new ClinicDto(
            clinic.getId(),
            clinic.getName(),
            clinic.getAddress()
        );
        System.out.println("CLINIC PACKED");
        clinics.add(dto);
      }

      System.out.println("clinic sent");
      return clinics;

    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RuntimeException("Error getting cities", e);
    }

  }

  @GetMapping("/doctors") public List<DoctorDto> getDoctorByClinic(@RequestParam String clinic_id)
  {
    System.out.println(clinic_id);
    try
    {
      System.out.println("CALLED doctor");
      Clinic request = Clinic.newBuilder()
          .setName("")
          .setId(clinic_id)
          .setAddress("")
          .build();
      DoctorListResponse response = blockingStub.getDoctors(request);
      List<DoctorDto> doctors = new ArrayList<>();

      for(DoctorRequest doctor : response.getDoctorList()){
        DoctorDto dto = new DoctorDto(
            doctor.getId(),
            doctor.getFirstname(),
            doctor.getLastname(),
            doctor.getSpecialisation()
        );
       System.out.println("DOCTOR PACKED");
        doctors.add(dto);
      }

      System.out.println("doctor sent");
      return doctors;

    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RuntimeException("Error getting cities", e);
    }

  }

  @PostMapping("/book") public ResponseDto bookAppointment(
      @RequestBody CreateAppointmentDto createAppointmentDto)
  {

    CreateAppointment request = CreateAppointment.newBuilder()
        .setType(createAppointmentDto.getType())
        .setDescription(createAppointmentDto.getDescription())
        .setStatus(createAppointmentDto.getStatus())
        .setPatientCpr(createAppointmentDto.getPatientCpr())
        .setDoctorId(createAppointmentDto.getDoctorId())
        .setAppointmentDate(createAppointmentDto.getDate())
        .setAppointmentTime(createAppointmentDto.getTime()).build();

    DBresponse response = blockingStub.createAppointment(request);
    ResponseDto responseDto = new ResponseDto();
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
  @GetMapping("/appointments")
  public ResponseDto getAppointments(@RequestParam String cpr) {
    try {
      PatientRequest request = PatientRequest.newBuilder()
          .setCpr(cpr)
          .build();

      GetAppointmentsResponse response = blockingStub.getAppointmentsByPatientCpr(request);
      List<GetAppointmentsDto> appointmentsList = new ArrayList<>();

      for (AppointmentInfo appointment : response.getAppointmentsList()) {
        GetAppointmentsDto dto = new GetAppointmentsDto();
        dto.setId(appointment.getId());
        dto.setDescription(appointment.getDescription());
        dto.setType(appointment.getType());
        dto.setDate(appointment.getDate());
        dto.setTime(appointment.getTime());
        dto.setStatus(appointment.getStatus());
        dto.setDoctorId(appointment.getDoctorId());
        dto.setDoctorFirstName(appointment.getDoctorFirstName());
        dto.setDoctorLastName(appointment.getDoctorLastName());
        dto.setDoctorSpecialization(appointment.getDoctorSpecialization());
        dto.setClinicName(appointment.getClinicName());
        dto.setClinicStreet(appointment.getClinicStreet());
        dto.setClinicStreetNumber(appointment.getClinicStreetNumber());
        dto.setClinicCity(appointment.getClinicCity());

        appointmentsList.add(dto);
      }

      ResponseDto responseDto = new ResponseDto();
      responseDto.setAppointments(appointmentsList);
      return responseDto;
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException("Error fetching appointments: ", e);
    }
  }

    @PostMapping("/update")
    public ResponseDto updatePatient(@RequestBody UpdatePatientDto updatePatientDto) {
        try {
            String newPassword = PasswordHasher.hash(updatePatientDto.getNewPassword());
            UpdateUserRequest request = UpdateUserRequest.newBuilder()
                    .setCPR(updatePatientDto.getCPR())
                    .setSurname(updatePatientDto.getSurname())
                    .setPhone(updatePatientDto.getPhone())
                    .setEmail(updatePatientDto.getEmail())
                    .setNewPassword(newPassword)
                    .build();

            DBresponse response = blockingStub.updateUser(request);

            if (response.getConfirmation() == null || response.getConfirmation().isEmpty()) {
                throw new RuntimeException("Patient update failed: " + response.getConfirmation());
            }

            ResponseDto responseDto = new ResponseDto();
            responseDto.setResponse(response.getConfirmation());
            return responseDto;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating patient details", e);
        }

    }   
}
