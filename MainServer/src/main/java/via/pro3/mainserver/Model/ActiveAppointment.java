package via.pro3.mainserver.Model;

public class ActiveAppointment extends AppointmentState
{
  //TODO
  @Override public void cancel(Appointment appointment)
  {

  }

  @Override public void expire(Appointment appointment)
  {

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
