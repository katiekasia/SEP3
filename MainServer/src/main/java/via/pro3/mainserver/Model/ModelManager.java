package via.pro3.mainserver.Model;

import via.pro3.mainserver.DTOs.CreateAppointmentDto;
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
    //TODO REMOVE PLACEHOLDER CLINIC
    Clinic clinic = new Clinic("PLACEHOLDER","S","S","S");
    Doctor doctor = getDoctorById(createAppointmentDto.getDoctorId());
    Patient patient = getPatientByCpr(createAppointmentDto.getPatientCpr());
    Appointment appointment = new Appointment(
        idGenerator.generateAppointmentId(), clinic,
        createAppointmentDto.getType(), dateAndTime,createAppointmentDto.getDescription(), createAppointmentDto.getStatus());
    doctor.addAppointment(appointment);
    eventRepository.createAppointment(appointment);
  }

  @Override public Patient getPatientByCpr(String cpr)
  {
    return null;
  }

  @Override public Doctor getDoctorById(String id)
  {
    return null;
  }


}
