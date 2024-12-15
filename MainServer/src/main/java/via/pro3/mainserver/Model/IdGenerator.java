package via.pro3.mainserver.Model;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class IdGenerator implements GeneratorInterface {
    private Set<Integer> appointmentIds;
    private Set<Integer> prescriptionIds;

    public IdGenerator() {
        appointmentIds = new HashSet<>();
        prescriptionIds = new HashSet<>();
    }

    @Override
    public int generateAppointmentId() {
        Random rand = new Random();
        int nextId;

        do {
            nextId = rand.nextInt(1000000);
        } while (appointmentIds.contains(nextId));
        appointmentIds.add(nextId);
        return nextId;
    }


    @Override
    public int generatePrescriptionId() {
        Random rand = new Random();
        int nextId;

        do {
            nextId = rand.nextInt(1000000);
        } while (prescriptionIds.contains(nextId));
        prescriptionIds.add(nextId);
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
