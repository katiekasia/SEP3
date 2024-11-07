package via.pro3.mainserver.database;

import java.time.LocalDateTime;

public interface EventInterface
{
  void createUser(String user, String password);

  void createAppointment(LocalDateTime DateAndTime);
}
