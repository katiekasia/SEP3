package via.pro3.mainserver.Model;

public class ActiveAppointment extends AppointmentState
{
  //TODO
  @Override public void cancel(Appointment appointment)
  {
    appointment.setStatus(new CancelledAppointment());
  }

  @Override public void expire(Appointment appointment)
  {
appointment.setStatus(new ExpiredAppointment());
  }

  @Override public String status()
  {
    return "Active";
  }

  @Override public AppointmentState copy()
  {
    return new ActiveAppointment();
  }
}
