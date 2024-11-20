package via.pro3.mainserver.Model;

public abstract class AppointmentState
{
  public abstract void cancel(Appointment appointment);
  public abstract void expire(Appointment appointment);
  public abstract String status();
  public abstract AppointmentState copy();
}
