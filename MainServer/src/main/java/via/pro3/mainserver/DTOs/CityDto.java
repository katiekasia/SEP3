package via.pro3.mainserver.DTOs;

public class CityDto
{
  private String name;
  private String code;


  public CityDto(String city, String code) {
    this.name = city;
    this.code = code;
  }


  public String getCity() {
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
