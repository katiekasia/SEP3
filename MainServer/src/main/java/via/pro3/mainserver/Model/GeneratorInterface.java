package via.pro3.mainserver.Model;

import java.util.Set;

public interface GeneratorInterface
{
   int generateAppointmentId();
   int generatePrescriptionId();
  void addAppointmentId(int id);
  void addPrescriptionId(int id);
  void setAppointmentIds(Set<Integer>  ids);
  void setPrescriptionIds(Set<Integer>  ids);
}
