package via.pro3.mainserver.Model;

public class CancelledAppointment extends AppointmentState
{

  @Override public void cancel(Appointment appointment)
  {
    throw new IllegalStateException("Appointment has been already cancelled.");
  }
//TODO
  @Override public void expire(Appointment appointment)
  {
    appointment.setStatus(new ExpiredAppointment());
  }

  @Override public String status()
  {
    return "Cancelled";
  }

  @Override public AppointmentState copy()
  {
    return new CancelledAppointment();
  }
}
