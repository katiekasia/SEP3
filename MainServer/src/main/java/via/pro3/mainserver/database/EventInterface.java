package via.pro3.mainserver.database;

import via.pro3.mainserver.Model.Appointment;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

public interface EventInterface
{
  void createUser(String user, String password);

  void createAppointment(Appointment appointment);
}
