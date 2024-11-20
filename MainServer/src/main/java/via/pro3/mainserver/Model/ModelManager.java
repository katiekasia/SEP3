package via.pro3.mainserver.Model;

public class ModelManager implements Model
{
  private GeneratorInterface idGenerator;

  public ModelManager(){
    idGenerator = new IdGenerator();
  }
}
