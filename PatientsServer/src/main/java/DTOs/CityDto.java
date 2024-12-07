package DTOs;

public class CityDto
{
  private String name;
  private String code;


  public CityDto(String name, String code) {
    this.name = name;
    this.code = code;
  }


  public String getName() {
    return name;
  }

  public String getCode()
  {
    return code;
  }

  public void setCode(String code)
  {
    this.code = code;
  }

  public void setName(String name)
  {
    this.name = name;
  }
}
