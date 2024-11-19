package via.pro3.mainserver.Model;

import java.util.Set;

public class IdGenerator implements GeneratorInterface
{
  private Set<Integer> appointmentIds;
  private Set<Integer> prescriptionIds;

  @Override public int generateAppointmentId()
  {
    return 0;
  }

  @Override public int generatePrescriptionId()
  {
    return 0;
  }

  @Override public void addAppointmentId(int id)
  {

  }

  @Override public void addPrescriptionId(int id)
  {

  }

  @Override public void setAppointmentIds(Set<Integer>  ids)
  {

  }

  @Override public void setPrescriptionIds(Set<Integer>  ids)
  {

  }
}
