package DTOs;

import java.util.List;

public class DateDto
{
  private List<String> times;
  private String date;

  public void setDate(String date)
  {
    this.date = date;
  }

  public String getDate()
  {
    return date;
  }

  public List<String> getTimes()
  {
    return times;
  }

  public void setTimes(List<String> times)
  {
    this.times = times;
  }
}
