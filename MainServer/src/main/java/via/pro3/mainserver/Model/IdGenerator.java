package via.pro3.mainserver.Model;

import java.util.HashSet;
import java.util.Set;

public class IdGenerator implements GeneratorInterface {
    private Set<Integer> appointmentIds;
    private Set<Integer> prescriptionIds;

    public IdGenerator(int appointmentCount, int prescriptionCount) {
        appointmentIds = new HashSet<>();
        prescriptionIds = new HashSet<>();

        for (int i = 0; i < appointmentCount; i++) {
            appointmentIds.add(i);
        }
        for (int i = 0; i < prescriptionCount; i++) {
            prescriptionIds.add(i);
        }
    }

    @Override
    public int generateAppointmentId() {
        int nextId = appointmentIds.size();
        appointmentIds.add(nextId);
        return nextId;
    }


    @Override
    public int generatePrescriptionId() {
        int nextId = getNextAvailableId(prescriptionIds);
        prescriptionIds.add(nextId);
        return nextId;
    }

    private int getNextAvailableId(Set<Integer> ids) {
        int nextId = 0;
        while (ids.contains(nextId)) {
            nextId++;
        }
        return nextId;
    }

    @Override
    public void addAppointmentId(int id) {
        appointmentIds.add(id);
    }

    @Override
    public void addPrescriptionId(int id) {
        prescriptionIds.add(id);
    }

    @Override
    public void setAppointmentIds(Set<Integer> ids) {
        appointmentIds = ids;
    }

    @Override
    public void setPrescriptionIds(Set<Integer> ids) {
        prescriptionIds = ids;
    }
}
