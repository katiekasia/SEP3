package via.pro3.mainserver.Model;

import java.util.Set;

public class IdGenerator implements GeneratorInterface
{
  private Set<Integer> appointmentIds;
  private Set<Integer> prescriptionIds;

  @Override public int generateAppointmentId()
  {
    int nextId = appointmentIds.size();
    appointmentIds.add(nextId);
    return nextId;
  }

  @Override public int generatePrescriptionId()
  {
    int nextId = prescriptionIds.size();
    addPrescriptionId(nextId);
    return nextId;
  }

  @Override public void addAppointmentId(int id)
  {
    appointmentIds.add(id);
  }

  @Override public void addPrescriptionId(int id)
  {
    prescriptionIds.add(id);
  }

  @Override public void setAppointmentIds(Set<Integer>  ids)
  {
appointmentIds = ids;
  }

  @Override public void setPrescriptionIds(Set<Integer>  ids)
  {
prescriptionIds = ids;
  }
}
