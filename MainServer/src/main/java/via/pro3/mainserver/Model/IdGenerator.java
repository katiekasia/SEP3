package via.pro3.mainserver.Model;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator implements GeneratorInterface {
  private AtomicInteger appointmentIdCounter;
  private AtomicInteger prescriptionIdCounter;
  private Set<Integer> appointmentIds;
  private Set<Integer> prescriptionIds;

  public IdGenerator() {
    this.appointmentIdCounter = new AtomicInteger(1);
    this.prescriptionIdCounter = new AtomicInteger(1);
    this.appointmentIds = new HashSet<>();
    this.prescriptionIds = new HashSet<>();
  }

  @Override
  public int generateAppointmentId() {
    int newId;
    do {
      newId = appointmentIdCounter.getAndIncrement();
    } while (appointmentIds.contains(newId));

    appointmentIds.add(newId);
    return newId;
  }

  @Override
  public int generatePrescriptionId() {
    int newId;
    do {
      newId = prescriptionIdCounter.getAndIncrement();
    } while (prescriptionIds.contains(newId));

    prescriptionIds.add(newId);
    return newId;
  }

  // Existing methods remain the same
  @Override
  public void addAppointmentId(int id) {
    appointmentIds.add(id);
    // Update counter if needed
    appointmentIdCounter.set(Math.max(appointmentIdCounter.get(), id + 1));
  }

  @Override
  public void addPrescriptionId(int id) {
    prescriptionIds.add(id);
    // Update counter if needed
    prescriptionIdCounter.set(Math.max(prescriptionIdCounter.get(), id + 1));
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