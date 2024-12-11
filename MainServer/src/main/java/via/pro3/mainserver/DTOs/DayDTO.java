package via.pro3.mainserver.DTOs;

import java.sql.Date;
import java.sql.Time;

public class DayDTO {
  private Date date;
  private final Time[] times = {
      new Time(8, 0, 0),
      new Time(8, 15, 0),
      new Time(8, 30, 0),
      new Time(9, 0, 0),
      new Time(9, 15, 0),
      new Time(9, 30, 0),
      new Time(9, 45, 0),
      new Time(10, 0, 0),
      new Time(10, 15, 0),
      new Time(10, 30, 0),
      new Time(10, 45, 0),
      new Time(11, 0, 0),
      new Time(11, 15, 0),
      new Time(11, 30, 0),
      new Time(11, 45, 0),
      new Time(12, 0, 0),
      new Time(12, 15, 0),
      new Time(12, 30, 0),
      new Time(12, 45, 0),
      new Time(13, 0, 0),
      new Time(13, 15, 0),
      new Time(13, 30, 0),
      new Time(13, 45, 0),
      new Time(14, 0, 0),
      new Time(14, 15, 0),
      new Time(14, 30, 0),
      new Time(14, 45, 0),
      new Time(15, 0, 0),
      new Time(15, 15, 0),
      new Time(15, 30, 0),
      new Time(15, 45, 0),
  };

  public DayDTO(Date date)
  {
    this.date = date;
  }

  public Date getDate()
  {
    return date;
  }

  public void setDate(Date date)
  {
    this.date = date;
  }

  public Time[] getTimes()
  {
    return times;
  }
  public void check(Time time){
    for (int i = 0; i < times.length; i++)
    {
      if (times[i] != null && times[i].equals(time)){
        times[i] = null;
      }
    }
  }
  public boolean isFree(){
    for (int i = 0; i < times.length; i++)
    {
      if (times[i] != null){
        return true;
      }
    }
    return false;
  }
}
