package via.pro3.mainserver.Model;

import patient.grpc.DBresponse;
import via.pro3.mainserver.DTOs.*;
import via.pro3.mainserver.database.DatabaseInterface;
import via.pro3.mainserver.database.DatabaseSingleton;
import via.pro3.mainserver.database.EventInterface;
import via.pro3.mainserver.database.EventRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public class ModelManager implements Model
{
  private GeneratorInterface idGenerator;
  private final EventInterface eventRepository;

  public ModelManager()
  {
    idGenerator = new IdGenerator();
    DatabaseInterface database = DatabaseSingleton.getInstance();
    this.eventRepository = new EventRepository(database);
  }

  @Override public String createAppointment(
      CreateAppointmentDto createAppointmentDto)
  {
    LocalDate date = LocalDate.parse(createAppointmentDto.getDate());
    LocalTime time = LocalTime.parse(createAppointmentDto.getTime());
    MyDateAndTime dateAndTime = new MyDateAndTime(date, time);
    Clinic clinic = eventRepository.getClinicByDoctorId(
        createAppointmentDto.getDoctorId());
    Doctor doctor = eventRepository.getDoctorById(
        createAppointmentDto.getDoctorId());
    Patient patient = getPatientByCpr(createAppointmentDto.getPatientCpr());

    Appointment appointment = new Appointment(
        idGenerator.generateAppointmentId(), clinic,
        createAppointmentDto.getType(), dateAndTime,
        createAppointmentDto.getDescription(),
        createAppointmentDto.getStatus());
    doctor.addAppointment(appointment);
    patient.addAppointment(appointment);
    try
    {
      eventRepository.createAppointment(appointment, doctor, patient);

    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    }
    return "Appointment created in " + appointment.getCity() + " at "
        + appointment.getDateAndTime().toString();
  }

  @Override public Patient getPatientByCpr(String cpr)
  {
    return eventRepository.getPatientByCpr(cpr);
  }

  @Override public Doctor getDoctorById(String id)
  {
    return eventRepository.getDoctorById(id);
  }

  @Override public void registerPatient(RegisterDto registerDto)
  {
    Patient patient = new Patient(registerDto.getCprNo(), registerDto.getName(),
        registerDto.getSurname(), registerDto.getPhone(),
        registerDto.getEmail(), registerDto.getPassword());

    try
    {
      eventRepository.createUser(patient);
      System.out.println("manager");
      DBresponse response = DBresponse.newBuilder()
          .setConfirmation("Patient registered successfully").build();
    }
    catch (Exception e)
    {
      throw new RuntimeException("Something went wrong");
    }

  }

  @Override public Patient loginPatient(LoginDto loginDto)
  {
    try
    {
      if (eventRepository.loginUser(loginDto))
      {
        Patient patient = getPatientByCpr(loginDto.getcpr());

        //if (PasswordHasher.validate(loginDto.getPassword(), patient.getPassword())){

        return patient;
        // }else {
        //   throw new RuntimeException("Invalid login credentials");
        //  }
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    }
    return null;
  }

  @Override public String changeDoctorPassword(
      ResetPasswordDto resetPasswordDto)
  {
    return eventRepository.changePassowrdDoctor(resetPasswordDto);
  }

  @Override public Doctor loginDoctor(LoginDto loginDto)
  {
    try
    {
      if (eventRepository.loginDoctor(loginDto))
      {
        Doctor doctor = getDoctorById(loginDto.getcpr());

        return doctor;
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    }
    return null;
  }
}
