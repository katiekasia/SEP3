package via.pro3.mainserver.Model;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class MyDateAndTime
{
  private int day, month, year, hour, minute;
  private LocalDate date;
  public LocalTime time;

  public MyDateAndTime(int day, int month, int year, int hour, int minute)
  {
    setDay(day);
    setMonth(month);
    setYear(year);
    setHour(hour);
    setMinute(minute);
    LocalDate date = LocalDate.of(year, month, day);
    LocalTime time = LocalTime.of(hour, minute);
    setDate(date);
    setTime(time);
  }

  public MyDateAndTime(LocalDate date, LocalTime time){
    setDay(date.getDayOfMonth());
    setMonth(date.getMonthValue());
    setYear(date.getYear());
    setHour(time.getHour());
    setMinute(time.getMinute());
    setDate(date);
    setTime(time);
  }


  public boolean isAfter(MyDateAndTime other)
  {
    if (getYear() > other.getYear())
      return true;
    else if (getYear() < other.getYear())
      return false;
    if (getMonth() > other.getMonth())
      return true;
    else if (getMonth() < other.getMonth())
      return false;
    return getDay() >= other.getDay() && getHour() >= other.getHour() && getMinute() > other.getMinute();
  }
  public boolean isBefore(MyDateAndTime other){
    if (getYear() < other.getYear())
      return true;
    else if (getYear() > other.getYear())
      return false;
    if (getMonth() < other.getMonth())
      return true;
    else if (getMonth() > other.getMonth())
      return false;
    return getDay() <= other.getDay() && getHour() <= other.getHour() && getMinute() < other.getMinute();
  }

  public MyDateAndTime copy(){
    return new MyDateAndTime(getDay(), getMonth(), getYear(), getHour(), getMinute());
  }

  @Override public boolean equals(Object obj)
  {
    if(obj==null || obj.getClass()!=this.getClass())
      return false;
    MyDateAndTime other = (MyDateAndTime)obj;
    return other.getYear()==this.getYear() &&
        other.getMonth()==this.getMonth() &&
        other.getDay()==this.getDay() &&
        other.getHour()==this.getHour() &&
        other.getMinute()==this.getMinute();
  }
  //GETTERS BELOW******************************

  @Override public String toString()
  {
    return getDay() + "/" + getMonth() + "/" + getYear() + "|" + getHour() + "/"
        + getMinute();
  }

  public int getDay()
  {
    return day;
  }

  public int getHour()
  {
    return hour;
  }

  public int getMinute()
  {
    return minute;
  }

  public int getMonth()
  {
    return month;
  }

  public int getYear()
  {
    return year;
  }

  public LocalTime getTime()
  {
    return LocalTime.of(hour, minute);
  }

  public LocalDate getDate()
  {
    return LocalDate.of(year, month, day);
  }

  //SETTERS BELOW****************************

  public void setDate(LocalDate date)
  {
    this.date = date;
  }

  public void setDay(int day)
  {
    this.day = day;
  }

  public void setHour(int hour)
  {
    this.hour = hour;
  }

  public void setMinute(int minute)
  {
    this.minute = minute;
  }

  public void setMonth(int month)
  {
    this.month = month;
  }

  public void setTime(LocalTime time)
  {
    this.time = time;
  }

  public void setYear(int year)
  {
    this.year = year;
  }

}
