package via.pro3.mainserver.Model;

import registerPatient.grpc.Response;
import via.pro3.mainserver.DTOs.CreateAppointmentDto;
import via.pro3.mainserver.DTOs.LoginDto;
import via.pro3.mainserver.DTOs.RegisterDto;
import via.pro3.mainserver.database.DatabaseInterface;
import via.pro3.mainserver.database.DatabaseSingleton;
import via.pro3.mainserver.database.EventInterface;
import via.pro3.mainserver.database.EventRepository;

public class ModelManager implements Model
{
  private GeneratorInterface idGenerator;
  private final EventInterface eventRepository;


  public ModelManager(){
    idGenerator = new IdGenerator();
    DatabaseInterface database = DatabaseSingleton.getInstance();
    this.eventRepository = new EventRepository(database);
  }



  @Override public void createAppointment(
      CreateAppointmentDto createAppointmentDto)
  {
    MyDateAndTime dateAndTime = new MyDateAndTime(createAppointmentDto.getAppointmentDate(), createAppointmentDto.getAppointmentTime());
    Clinic clinic = eventRepository.getClinicByDoctorId(createAppointmentDto.getDoctorId());
    Doctor doctor = eventRepository.getDoctorById(createAppointmentDto.getDoctorId());
    Patient patient = getPatientByCpr(createAppointmentDto.getPatientCpr());
    Appointment appointment = new Appointment(
        idGenerator.generateAppointmentId(), clinic,
        createAppointmentDto.getType(), dateAndTime,createAppointmentDto.getDescription(), createAppointmentDto.getStatus());
    doctor.addAppointment(appointment);
    patient.addAppointment(appointment);
    try
    {
      eventRepository.createAppointment(appointment, doctor, patient);
    }catch (Exception e){
      throw new RuntimeException(e.getMessage());
    }
  }

  @Override public Patient getPatientByCpr(String cpr)
  {
    return eventRepository.getPatientByCpr(cpr);
  }

  @Override public Doctor getDoctorById(String id)
  {
    return eventRepository.getDoctorById(id);
  }

  @Override
  public void registerPatient(RegisterDto registerDto) {
    Patient patient = new Patient(registerDto.getName(),
        registerDto.getSurname(),
        registerDto.getPassword(),
        registerDto.getCprNo(),
        registerDto.getPhone(),
        registerDto.getEmail());

    eventRepository.createUser(patient);

    Response response = Response.newBuilder()
        .setConfirmation("Patient registered successfully")
        .build();
  }

  @Override public String loginPatient(LoginDto loginDto)
  {
   return eventRepository.loginUser(loginDto.getCpr(), loginDto.getPassword());
  }
}