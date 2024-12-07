package DTOs;

import java.util.List;

public class CityListDto
{
  private List<CityDto> Cities;

  public List<CityDto> getCities()
  {
    return Cities;
  }

  public void setCities(List<CityDto> cities)
  {
    Cities = cities;
  }
}
