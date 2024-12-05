package via.pro3.doctorserver;

import Auth.PasswordHasher;
import DTOs.*;
import doctor.grpc.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@CrossOrigin(origins = "*") @RestController @RequestMapping("/Doctor")

public class Server
{
  private final DoctorGrpc.DoctorBlockingStub blockingStub;

  public Server()
  {
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
        .usePlaintext().build();

    blockingStub = DoctorGrpc.newBlockingStub(channel);
  }

  @PostMapping("/login") public DoctorDto loginDoctor(
      @RequestBody LoginDto loginDto)
  {
    if (loginDto == null || loginDto.getcpr() == null
        || loginDto.getPassword() == null)
    {
      throw new IllegalArgumentException("Invalid login credentials");
    }

    try
    {
      System.out.println("attempt");
      GetDoctorByIdRequest request = GetDoctorByIdRequest.newBuilder()
          .setId(loginDto.getcpr()).build();

      LoginDoctorResponse response = blockingStub.loginDoctor(request);
      System.out.println("response: " + response);
      if (PasswordHasher.validate(response.getPassword(), loginDto.getPassword()))
      {
        System.out.println("success");
        DoctorDto doctorDto = new DoctorDto(response.getName(),
            response.getSurname(), response.getSpecialisation(),
            response.getId());
        System.out.println("sent");
        return doctorDto;
      }
      else {
        throw new IllegalArgumentException("Invalid login credentials");
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RuntimeException("Login failed: " + e.getMessage());
    }
  }

  @PostMapping("/resetPassword") public ResponseDto changePassword(
      @RequestBody ResetPasswordDto resetPasswordDto)
  {
    if (resetPasswordDto == null)
    {
      throw new IllegalArgumentException("Invalid reset password");
    }

    try
    {
      String newPassword = PasswordHasher.hash(resetPasswordDto.getNewPassword());

      ChangePasswordRequest request = ChangePasswordRequest.newBuilder()
          .setId(resetPasswordDto.getId())
          .setNewPassword(newPassword)
          .build();

      UniResponse response = blockingStub.changePassword(request);

      ResponseDto responseDto = new ResponseDto();
      responseDto.setResponse(response.getInfo());
      return responseDto;
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RuntimeException("Reset password failed: " + e.getMessage());
    }
  }

  @PostMapping("/getDoctorById") public DoctorDto getDoctorById(
      @RequestBody String id)
  {
    if (id == null || id.isEmpty())
    {
      throw new IllegalArgumentException("Invalid doctor id");
    }
    try
    {
      GetDoctorByIdRequest request = GetDoctorByIdRequest.newBuilder().setId(id)
          .build();

      GetDoctorByIdResponse response = blockingStub.getDoctorById(request);

      DoctorDto doctorDto = new DoctorDto(response.getFirstname(),
          response.getLastname(), response.getSpecialisation(), "");
      return doctorDto;
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RuntimeException("Get doctor failed: " + e.getMessage());
    }
  }

  @GetMapping("/appointments")
  public ResponseDto getAppointments(@RequestParam String id){
    try
    {
      System.out.println("request");
      GetDoctorByIdRequest request = GetDoctorByIdRequest.newBuilder()
          .setId(id)
          .build();

      GetAppointmentsResponseD response = blockingStub.getAppointmentsByDoctorId(request);
      List<GetAppointmentsDto> appointmentsDtoList = new ArrayList<>();

      for(AppointmentInfoD info : response.getAppointmentsList()){
        GetAppointmentsDto dto = new GetAppointmentsDto();
        dto.setId(info.getId());
        dto.setDescription(info.getDescription());
        dto.setType(info.getType());
        dto.setDate(info.getDate());
        dto.setTime(info.getTime());
        dto.setStatus(info.getStatus());
        dto.setPatientCpr(info.getPatientCpr());
        dto.setPatientEmail(info.getPatientEmail());
        dto.setPatientFirstName(info.getPatientFirstName());
        dto.setPatientLastName(info.getPatientLastName());
        dto.setPatientPhone(info.getPatientPhone());

        System.out.println(dto.toString());
        appointmentsDtoList.add(dto);
      }

      System.out.println("SEENT");
      ResponseDto responseDto = new ResponseDto();
      responseDto.setAppointments(appointmentsDtoList);
      return responseDto;
    }catch (Exception e){
      e.printStackTrace();
      throw new RuntimeException("Error fetching appointments: " + e.getMessage());
    }
  }
}
