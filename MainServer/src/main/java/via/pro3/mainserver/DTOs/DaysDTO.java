package via.pro3.mainserver.DTOs;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class DaysDTO
{
  private List<DayDTO> days;

  public void setDays(List<DayDTO> days)
  {
    this.days = days;
  }

  public List<DayDTO> getDays()
  {
    return days;
  }
  public void add(DayDTO day){
    days.add(day);
  }
  public boolean alreadyHas(Date date){
    for (DayDTO day : days){
      if (day.getDate().equals(date)){
        return true;
      }
    }
    return false;
  }

  public DayDTO getDay(Date date)
  {
    for (DayDTO day : days){
      if (day.getDate().equals(date)){
        return day;
      }
    }
    return null;
  }
}
