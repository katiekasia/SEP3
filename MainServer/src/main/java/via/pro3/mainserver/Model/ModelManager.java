package via.pro3.mainserver.Model;

import via.pro3.mainserver.database.EventRepository;

public class ModelManager implements Model
{

  private GeneratorInterface idGenerator;
  private EventRepository eventRepository;

  public ModelManager()
  {
    idGenerator = new IdGenerator();
  }






}
