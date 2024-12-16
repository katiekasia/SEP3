package via.pro3.patientsserver;

import Auth.PasswordHasher;
import DTOs.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import patient.grpc.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController @RequestMapping("/Booking") @CrossOrigin(origins = "*") public class Server
{
  private final PatientGrpc.PatientBlockingStub blockingStub;
  private final JwtUtil jwtUtil;

  public Server(JwtUtil jwtUtil)
  {
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
        .usePlaintext().build();
    blockingStub = PatientGrpc.newBlockingStub(channel);
    this.jwtUtil = jwtUtil;
  }

  @PreAuthorize("hasRole('USER')")
  @GetMapping("/cities") public List<CityDto> getCities()
  {

    try
    {
      GetCities request = GetCities.newBuilder().build();
      CityListResponse response = blockingStub.getCities(request);
      List<CityDto> cityDtos = new ArrayList<>();

      for (CityRequest city : response.getCitiesList())
      {
        CityDto dto = new CityDto(city.getName(), city.getPostalcode());
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

  @PreAuthorize("hasRole('USER')")
  @GetMapping("/days") public List<DateDto> getDoctorsAvailability(
      @RequestParam String doctorId)
  {
    try
    {
      DoctorId request = DoctorId.newBuilder().setDoctorId(doctorId).build();

      AllDays response = blockingStub.getDoctorsAvailability(request);
      List<DateDto> days = new ArrayList<>();

      for (DayDto daysDto : response.getDaysList())
      {
        if (!daysDto.getIsFree())
        {
          DateDto dto = new DateDto();
          dto.setDate(daysDto.getDate());
          List<String> timesStrings = new ArrayList<>();
          for (String s : daysDto.getFreeHoursList())
          {
            timesStrings.add(s);
          }
          dto.setTimes(timesStrings);

          days.add(dto);
        }
      }

      return days;

    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RuntimeException("Error getting cities", e);
    }
  }

  @PreAuthorize("hasRole('USER')")
  @GetMapping("/alldays") public List<DateDto> GetDoctorsSchedule(
      @RequestParam String doctorId)
  {
    try
    {
      DoctorId request = DoctorId.newBuilder().setDoctorId(doctorId).build();

      AllDays response = blockingStub.getDoctorsAvailability(request);
      List<DateDto> days = new ArrayList<>();

      for (DayDto daysDto : response.getDaysList())
      {
        if (daysDto.getIsFree())
        {
          DateDto dto = new DateDto();
          dto.setDate(daysDto.getDate());
          List<String> timesStrings = new ArrayList<>();
          for (String s : daysDto.getFreeHoursList())
          {
            timesStrings.add(s);
          }
          dto.setTimes(timesStrings);

          days.add(dto);
        }
      }

      return days;

    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RuntimeException("Error getting cities", e);
    }
  }

  @PreAuthorize("hasRole('USER')")
  @GetMapping("/clinics") public List<ClinicDto> getClinicsByCity(
      @RequestParam String code)
  {
    try
    {

      CityRequest request = CityRequest.newBuilder().setName("")
          .setPostalcode(code).build();
      ClinicListResponse response = blockingStub.getClinics(request);
      List<ClinicDto> clinics = new ArrayList<>();

      for (Clinic clinic : response.getClinicsList())
      {
        ClinicDto dto = new ClinicDto(clinic.getId(), clinic.getName(),
            clinic.getAddress());
        clinics.add(dto);
      }

      return clinics;

    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RuntimeException("Error getting cities", e);
    }

  }

  @PreAuthorize("hasRole('USER')")
  @GetMapping("/doctors") public List<DoctorDto> getDoctorByClinic(
      @RequestParam String clinic_id)
  {
    try
    {
      Clinic request = Clinic.newBuilder().setName("").setId(clinic_id)
          .setAddress("").build();
      DoctorListResponse response = blockingStub.getDoctors(request);
      List<DoctorDto> doctors = new ArrayList<>();

      for (DoctorRequest doctor : response.getDoctorList())
      {
        DoctorDto dto = new DoctorDto(doctor.getId(), doctor.getFirstname(),
            doctor.getLastname(), doctor.getSpecialisation());
        doctors.add(dto);
      }

      return doctors;

    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RuntimeException("Error getting cities", e);
    }

  }

  @PreAuthorize("hasRole('USER')")
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

  @PostMapping("/register") public ResponseDto registerPatient(
      @RequestBody RegisterDto registerDto)
  {
    try
    {

      String password = PasswordHasher.hash(registerDto.getPassword());
      RegisterRequest request = RegisterRequest.newBuilder()
          .setName(registerDto.getName()).setSurname(registerDto.getSurname())
          .setEmail(registerDto.getEmail()).setPhone(registerDto.getPhone())
          .setPassword(password).setCPRNo(registerDto.getCprNo()).build();

      DBresponse response = blockingStub.registerPatient(request);

      if (response.getConfirmation() == null)
      {
        throw new RuntimeException(
            "Patient registration failed: " + response.getConfirmation());
      }
      ResponseDto responseDto = new ResponseDto();
      responseDto.setResponse(response.getConfirmation());
      return responseDto;
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RuntimeException("Error registering patient", e);
    }
  }

  @PostMapping("/login") public ResponseEntity<?> loginPatient(
      @RequestBody LoginDto loginDto)
  {
    try
    {

      PatientRequest request = PatientRequest.newBuilder()
          .setCpr(loginDto.getcpr()).build();

      LoginResponse response = blockingStub.loginPatient(request);

      if (PasswordHasher.validate(response.getPassword(),
          loginDto.getPassword()))
      {
        String jwtToken = jwtUtil.generateToken(loginDto.getcpr());


        UserDto userDto = new UserDto();
        userDto.setName(response.getName());
        userDto.setEmail(response.getEmail());
        userDto.setPhone(response.getPhone());
        userDto.setSurname(response.getSurname());
        userDto.setCpr(response.getCpr());

        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("token", jwtToken); // Add the token to the response
        responseBody.put("user", userDto);   // Add user details

        return ResponseEntity.ok(responseBody);
      }
      else
      {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
      }
    }
    catch (StatusRuntimeException e)
    {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error logging in");
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RuntimeException("Error logging in", e);
    }
  }

  @PreAuthorize("hasRole('USER')")
  @PostMapping("/update") public ResponseDto updatePatient(
      @RequestBody UpdatePatientDto updatePatientDto)
  {
    try
    {
      String newPassword = PasswordHasher.hash(
          updatePatientDto.getNewPassword());
      UpdateUserRequest request = UpdateUserRequest.newBuilder()
          .setCPR(updatePatientDto.getCPR())
          .setSurname(updatePatientDto.getSurname())
          .setPhone(updatePatientDto.getPhone())
          .setEmail(updatePatientDto.getEmail()).setNewPassword(newPassword)
          .build();

      DBresponse response = blockingStub.updateUser(request);

      if (response.getConfirmation() == null || response.getConfirmation()
          .isEmpty())
      {
        throw new RuntimeException(
            "Patient update failed: " + response.getConfirmation());
      }

      ResponseDto responseDto = new ResponseDto();
      responseDto.setResponse(response.getConfirmation());
      return responseDto;

    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RuntimeException("Error updating patient details", e);
    }

  }

  @PreAuthorize("hasRole('USER')")
  @PostMapping("/appointments/cancel") public ResponseDto cancelAppointment(
      @RequestBody CancelAppointmentDto cancelDto)
  {
    try
    {
      if (cancelDto == null || cancelDto.getPatientCpr() == null
          || cancelDto.getPatientCpr().trim().isEmpty())
      {
        return ResponseDto.createCancellationError("Invalid patient CPR");
      }

      // Create gRPC request
      CancelAppointmentRequest request = CancelAppointmentRequest.newBuilder()
          .setAppointmentId(cancelDto.getAppointmentId())
          .setPatientCpr(cancelDto.getPatientCpr()).build();

      // Call main server
      DBresponse response = blockingStub.cancelAppointment(request);

      // Check response
      if (response.getConfirmation() == null || response.getConfirmation()
          .isEmpty())
      {
        return ResponseDto.createCancellationError(
            "No confirmation received from server");
      }

      // Create success response
      return new ResponseDto(response.getConfirmation(), true);

    }
    catch (StatusRuntimeException e)
    {
      // Handle gRPC specific errors
      if (e.getStatus().getCode() == Status.Code.FAILED_PRECONDITION)
      {
        // Handle case where appointment cannot be cancelled
        return ResponseDto.createCancellationError(
            e.getStatus().getDescription());
      }
      return ResponseDto.createCancellationError(
          "Server error: " + e.getStatus().getDescription());
    }
    catch (Exception e)
    {
      // Handle general errors
      return ResponseDto.createCancellationError(e.getMessage());
    }
  }

  @PreAuthorize("hasRole('USER')")
  @GetMapping("/Prescriptions") public List<GetPrescriptionsDto> getPrescriptionsByPatientCpr(
      @RequestParam String cpr, @RequestParam int page)
  {
    try
    {
      RequestForAppointments request = RequestForAppointments.newBuilder()
          .setCpr(cpr).setPage(page).build();

      GetPrescriptionsResponse response = blockingStub.getPrescriptionsByPatientCpr(
          request);

      List<GetPrescriptionsDto> prescriptionDtos = new ArrayList<>();
      for (PrescriptionInfo prescription : response.getPrescriptionsList())
      {
        GetPrescriptionsDto dto = new GetPrescriptionsDto(prescription.getId(),
            prescription.getDiagnosis(), prescription.getMedication(),
            prescription.getRecommendations(), prescription.getDate(),
            prescription.getTime(), prescription.getPatientcpr(),
            prescription.getDoctorid(), prescription.getDoctorname(),
            prescription.getDoctorsurname());

        prescriptionDtos.add(dto);
      }

      return prescriptionDtos;
    }
    catch (StatusRuntimeException e)
    {
      throw new RuntimeException(
          "gRPC error: " + e.getStatus().getDescription(), e);
    }

  }

  @PreAuthorize("hasRole('USER')")
  @GetMapping("/countPres") public int getPrescriptionsCount(
      @RequestParam String cpr)
  {
    try
    {
      RequestForAppointments request = RequestForAppointments.newBuilder()
          .setCpr(cpr).build();

      CountReply response = blockingStub.getPrescriptionCount(request);

      return response.getCount();
    }
    catch (StatusRuntimeException e)
    {
      e.printStackTrace();
      throw new RuntimeException("Error counting", e);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RuntimeException("Error counting appointments", e);
    }
  }

  @PreAuthorize("hasRole('USER')")
  @GetMapping("/count") public int getAppointmentsCount(
      @RequestParam String cpr)
  {
    try
    {
      PatientRequest request = PatientRequest.newBuilder().setCpr(cpr).build();

      CountReply response = blockingStub.getAppointmentCount(request);

      return response.getCount();
    }
    catch (StatusRuntimeException e)
    {
      e.printStackTrace();
      throw new RuntimeException("Error counting", e);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RuntimeException("Error counting appointments", e);
    }
  }

  @PreAuthorize("hasRole('USER')")
  @GetMapping("/appointments") public ResponseDto getAppointments(
      @RequestParam String cpr)
  {
    try
    {
      PatientRequest request = PatientRequest.newBuilder().setCpr(cpr).build();

      GetAppointmentsResponse response = blockingStub.getAppointmentsByPatientCpr(
          request);
      List<GetAppointmentsDto> appointmentsList = new ArrayList<>();

      for (AppointmentInfo appointment : response.getAppointmentsList())
      {
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
      responseDto.setSuccess(true);
      return responseDto;

    }
    catch (StatusRuntimeException e)
    {
      e.printStackTrace();

      ResponseDto errorResponse = new ResponseDto();
      errorResponse.setSuccess(false);
      errorResponse.setResponse(
          "Error fetching appointments: " + e.getStatus().getDescription());
      return errorResponse;
    }
    catch (Exception e)
    {
      e.printStackTrace();

      ResponseDto errorResponse = new ResponseDto();
      errorResponse.setSuccess(false);
      errorResponse.setResponse(
          "Error fetching appointments: " + e.getMessage());
      return errorResponse;
    }
  }
}







