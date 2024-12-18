package via.pro3.mainserver.Model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class PrescriptionTest {

    private static Clinic clinic;
    private static Doctor doctor;
    private static MyDateAndTime myDateAndTime;

    @BeforeAll
    static void setup() {
        clinic = new Clinic("1", "Test Clinic", "Horsens", "Kamtjatka", "13");
        doctor = new Doctor("D123", "John", "Doe", "987-654-3210", "johndoe@email.com", "password123", "Cardiology", clinic);
        myDateAndTime = new MyDateAndTime(10, 12, 2024, 10, 30);
    }

    // Test the 'id' field
    @Test
    void testZeroId() {
        Prescription prescription = new Prescription(0, "Flu", "Tamiflu", "Take 1 pill per day", doctor, myDateAndTime);
        assertEquals(0, prescription.getId());
    }

    @Test
    void testOneId() {
        Prescription prescription = new Prescription(1, "Flu", "Tamiflu", "Take 1 pill per day", doctor,
                myDateAndTime);
        assertEquals(1, prescription.getId());
    }

    @Test
    void testManyId(){
        Prescription prescription1 = new Prescription(1, "Flu", "Tamiflu", "Take 1 pill per day", doctor,
                myDateAndTime);
        Prescription prescription2 = new Prescription(2, "Flu", "Tamiflu", "Take 1 pill per day", doctor,
                myDateAndTime);
        Prescription prescription3 = new Prescription(3, "Flu", "Tamiflu", "Take 1 pill per day", doctor,
                myDateAndTime);

        assertAll("id",
                () -> assertEquals(prescription1.getId(), 1),
                () -> assertEquals(prescription2.getId(), 2),
                () -> assertEquals(prescription3.getId(), 3)
        );
    }

    @Test
    void testBoundaryId() {
        Prescription prescription = new Prescription(Integer.MAX_VALUE, "Flu", "Tamiflu", "Take 1 pill per day", doctor, myDateAndTime);
        assertEquals(Integer.MAX_VALUE, prescription.getId());
    }


    // Test the 'diagnosis' field
    @Test
    void testZeroDiagnosis() {
        Prescription prescription = new Prescription(1, "", "Tamiflu", "Take 1 pill per day", doctor, myDateAndTime);
        assertEquals("", prescription.getDiagnosis());
    }

    @Test
    void testOneDiagnosis() {
        Prescription prescription = new Prescription(1, "Flu", "Tamiflu", "Take 1 pill per day", doctor, myDateAndTime);
        assertEquals("Flu", prescription.getDiagnosis());
    }

    @Test
    void testManyDiagnosis() {
        Prescription prescription1 = new Prescription(1, "Flu", "Tamiflu", "Take 1 pill per day", doctor, myDateAndTime);
        Prescription prescription2 = new Prescription(2, "Cold", "Tylenol", "Take 2 pills per day", doctor, myDateAndTime);
        Prescription prescription3 = new Prescription(3, "Covid-19", "Remdesivir", "Take 1 pill every 12 hours", doctor, myDateAndTime);

        assertAll("diagnosis",
                () -> assertEquals("Flu", prescription1.getDiagnosis()),
                () -> assertEquals("Cold", prescription2.getDiagnosis()),
                () -> assertEquals("Covid-19", prescription3.getDiagnosis())
        );
    }

    @Test
    void testBoundaryDiagnosis() {
        Prescription prescription = new Prescription(1, "A".repeat(1000), "Tamiflu", "Take 1 pill per day", doctor, myDateAndTime);
        assertEquals("A".repeat(1000), prescription.getDiagnosis());
    }

    // Test the 'medication' field
    @Test
    void testZeroMedication() {
        Prescription prescription = new Prescription(1, "Flu", "", "Take 1 pill per day", doctor, myDateAndTime);
        assertEquals("", prescription.getMedication());
    }

    @Test
    void testOneMedication() {
        Prescription prescription = new Prescription(1, "Flu", "Tamiflu", "Take 1 pill per day", doctor, myDateAndTime);
        assertEquals("Tamiflu", prescription.getMedication());
    }

    @Test
    void testManyMedication() {
        Prescription prescription1 = new Prescription(1, "Flu", "Tamiflu", "Take 1 pill per day", doctor, myDateAndTime);
        Prescription prescription2 = new Prescription(2, "Cold", "Tylenol", "Take 2 pills per day", doctor, myDateAndTime);
        Prescription prescription3 = new Prescription(3, "Covid-19", "Remdesivir", "Take 1 pill every 12 hours", doctor, myDateAndTime);

        assertAll("medication",
                () -> assertEquals("Tamiflu", prescription1.getMedication()),
                () -> assertEquals("Tylenol", prescription2.getMedication()),
                () -> assertEquals("Remdesivir", prescription3.getMedication())
        );
    }

    @Test
    void testBoundaryMedication() {
        Prescription prescription = new Prescription(1, "Flu", "A".repeat(1000), "Take 1 pill per day", doctor, myDateAndTime);
        assertEquals("A".repeat(1000), prescription.getMedication());
    }


    // Test the 'recommendations' field
    @Test
    void testZeroRecommendations() {
        Prescription prescription = new Prescription(1, "Flu", "Tamiflu", "", doctor, myDateAndTime);
        assertEquals("", prescription.getRecommendations());
    }

    @Test
    void testOneRecommendations() {
        Prescription prescription = new Prescription(1, "Flu", "Tamiflu", "Take 1 pill per day", doctor, myDateAndTime);
        assertEquals("Take 1 pill per day", prescription.getRecommendations());
    }

    @Test
    void testManyRecommendations() {
        Prescription prescription1 = new Prescription(1, "Flu", "Tamiflu", "Take 1 pill per day", doctor, myDateAndTime);
        Prescription prescription2 = new Prescription(2, "Cold", "Tylenol", "Take 2 pills per day", doctor, myDateAndTime);
        Prescription prescription3 = new Prescription(3, "Covid-19", "Remdesivir", "Take 1 pill every 12 hours", doctor, myDateAndTime);

        assertAll("recommendations",
                () -> assertEquals("Take 1 pill per day", prescription1.getRecommendations()),
                () -> assertEquals("Take 2 pills per day", prescription2.getRecommendations()),
                () -> assertEquals("Take 1 pill every 12 hours", prescription3.getRecommendations())
        );
    }

    @Test
    void testBoundaryRecommendations() {
        Prescription prescription = new Prescription(1, "Flu", "Tamiflu", "A".repeat(1000), doctor,
                myDateAndTime);
        assertEquals("A".repeat(1000), prescription.getRecommendations());
    }

    // Test the 'doctor' field
    @Test
    void testOneDoctor() {
        Prescription prescription = new Prescription(1, "Flu", "Tamiflu", "Take 1 pill per day", doctor, myDateAndTime);
        assertEquals("John", prescription.getDoctor().getName());
    }

    @Test
    void testManyDoctors() {
        Doctor doctor1 = new Doctor("D123", "John", "Doe", "987-654-3210", "johndoe@email.com", "password123", "Cardiology", clinic);
        Doctor doctor2 = new Doctor("D124", "Jane", "Smith", "987-654-4321", "janesmith@email.com", "password456", "Dermatology", clinic);
        Doctor doctor3 = new Doctor("D125", "Mike", "Johnson", "987-654-8765", "mikejohnson@email.com", "password789", "Neurology", clinic);

        Prescription prescription1 = new Prescription(1, "Flu", "Tamiflu", "Take 1 pill per day", doctor1, new MyDateAndTime(10, 12, 2024, 10, 30));
        Prescription prescription2 = new Prescription(2, "Cold", "Tylenol", "Take 2 pills per day", doctor2, new MyDateAndTime(11, 12, 2024, 15, 45));
        Prescription prescription3 = new Prescription(3, "Covid-19", "Remdesivir", "Take 1 pill every 12 hours", doctor3, new MyDateAndTime(12, 12, 2024, 8, 0));

        assertAll("doctor",
                () -> assertEquals("John", prescription1.getDoctor().getName()),
                () -> assertEquals("Jane", prescription2.getDoctor().getName()),
                () -> assertEquals("Mike", prescription3.getDoctor().getName())
        );
    }

    // Test the 'dateAndTime' field
    @Test
    void testZeroDateAndTime() {
        assertThrows(NullPointerException.class, () -> {
            new Prescription(1, "Flu", "Tamiflu", "Take 1 pill per day", doctor, null);
        });
    }

    @Test
    void testOneDateAndTime() {
        MyDateAndTime dateAndTime = new MyDateAndTime(10, 12, 2024, 10, 30);
        Prescription prescription = new Prescription(1, "Flu", "Tamiflu", "Take 1 pill per day", doctor, dateAndTime);
        assertEquals(dateAndTime, prescription.getDateAndTime());
    }

    @Test
    void testManyDateAndTime() {
        MyDateAndTime dateAndTime1 = new MyDateAndTime(10, 12, 2024, 10, 30);
        MyDateAndTime dateAndTime2 = new MyDateAndTime(11, 12, 2024, 15, 45);
        MyDateAndTime dateAndTime3 = new MyDateAndTime(12, 12, 2024, 8, 0);

        Prescription prescription1 = new Prescription(1, "Flu", "Tamiflu", "Take 1 pill per day", doctor, dateAndTime1);
        Prescription prescription2 = new Prescription(2, "Cold", "Tylenol", "Take 2 pills per day", doctor, dateAndTime2);
        Prescription prescription3 = new Prescription(3, "Covid-19", "Remdesivir", "Take 1 pill every 12 hours", doctor, dateAndTime3);

        assertAll("dateAndTime",
                () -> assertEquals(dateAndTime1, prescription1.getDateAndTime()),
                () -> assertEquals(dateAndTime2, prescription2.getDateAndTime()),
                () -> assertEquals(dateAndTime3, prescription3.getDateAndTime())
        );
    }

    @Test
    void testBoundaryDateAndTime() {
        MyDateAndTime dateAndTime1 = new MyDateAndTime(1, 1, 2024, 0, 0);
        MyDateAndTime dateAndTime2 = new MyDateAndTime(31, 12, 2024, 23, 59);

        Prescription prescription1 = new Prescription(1, "Flu", "Tamiflu", "Take 1 pill per day", doctor, dateAndTime1);
        Prescription prescription2 = new Prescription(2, "Cold", "Tylenol", "Take 2 pills per day", doctor, dateAndTime2);

        assertAll("boundary dateAndTime",
                () -> assertEquals(dateAndTime1, prescription1.getDateAndTime()),
                () -> assertEquals(dateAndTime2, prescription2.getDateAndTime())
        );
    }
}
