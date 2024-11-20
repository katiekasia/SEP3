package via.pro3.mainserver.database;

import via.pro3.mainserver.Model.Appointment;
import via.pro3.mainserver.Model.Patient;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

public interface EventInterface
{
  void createAppointment(Appointment appointment);

  void createUser(Patient patient);
}
