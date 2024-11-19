package via.pro3.mainserver.Model;

public class ExpiredAppointment extends AppointmentState
{
  @Override public void cancel(Appointment appointment)
  {
    throw new IllegalStateException("Cannot cancel expired appointment.");
  }

  @Override public void expire(Appointment appointment)
  {
    throw new IllegalStateException("Appointment already expired.");
  }

  @Override public String status()
  {
    return "Expired";
  }

  @Override public AppointmentState copy()
  {
    return new ExpiredAppointment();
  }
}
