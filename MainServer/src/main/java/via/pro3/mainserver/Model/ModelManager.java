package via.pro3.mainserver.Model;

import DTOs.LoginDto;
import DTOs.RegisterDto;
import registerPatient.grpc.Response;
import via.pro3.mainserver.database.DatabaseInterface;
import via.pro3.mainserver.database.DatabaseSingleton;
import via.pro3.mainserver.database.EventRepository;

public class ModelManager implements Model
{
  private GeneratorInterface idGenerator;
  private EventRepository eventRepository;
  public ModelManager(){
    idGenerator = new IdGenerator();
    DatabaseInterface database = DatabaseSingleton.getInstance();
    this.eventRepository = new EventRepository(database);
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

  @Override
  public void loginPatient(LoginDto loginDto) {
    
  }
}
