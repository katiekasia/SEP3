package via.pro3.mainserver.Model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {

    private static Clinic clinic;

    @BeforeAll
    static void setup() {
        clinic = new Clinic("1", "Test Clinic", "Horsens", "Kamtjatka", "13");
    }

    // Date tests
    @Test
    void testAppointmentWithZerDate() {
        Appointment appointment = new Appointment(
                1, clinic, "Checkup", null, "Just a checkup", "Active"
        );
        assertNull(appointment.getDate(), "Appointment date should not be null");
    }

    @Test
    void testAppointmentWithDate() {
        MyDateAndTime dateAndTime = new MyDateAndTime(
                LocalDate.of(2023, 10, 10),
                LocalTime.of(10, 10)
        );
        Appointment appointment = new Appointment(
                1, clinic, "Checkup", dateAndTime, "Just a checkup", "Active"
        );
        assertEquals(LocalDate.of(2023, 10, 10), appointment.getDate());
    }

    @Test
    void testAppointmentManyDates(){
        MyDateAndTime dateAndTime1 = new MyDateAndTime(LocalDate.of(2023, 10, 10), LocalTime.of(10, 10));
        MyDateAndTime dateAndTime2 = new MyDateAndTime(LocalDate.of(2023, 10, 11), LocalTime.of(06, 30));
        MyDateAndTime dateAndTime3 = new MyDateAndTime(LocalDate.of(2021, 03, 22), LocalTime.of(12, 45));
        Appointment appointment1 = new Appointment(1, clinic, "Checkup", dateAndTime1, "Just a checkup", "Active");
        Appointment appointment2 = new Appointment(2, clinic, "Checkup", dateAndTime2, "Just a checkup", "Active");
        Appointment appointment3 = new Appointment(3, clinic, "Checkup", dateAndTime3, "Just a checkup", "Active");

        assertAll("dateAndTime",
                () -> assertEquals(appointment1.getDate(), LocalDate.of(2023, 10, 10)),
                () -> assertEquals(appointment1.getTime(), LocalTime.of(10, 10)),
                () -> assertEquals(appointment2.getDate(), LocalDate.of(2023, 10, 11)),
                () -> assertEquals(appointment2.getTime(), LocalTime.of(06, 30)),
                () -> assertEquals(appointment3.getDate(), LocalDate.of(2021, 03, 22)),
                () -> assertEquals(appointment3.getTime(), LocalTime.of(12, 45))
        );
    }

    @Test
    void testAppointmentBoundaryDates(){
        MyDateAndTime dateAndTime = new MyDateAndTime(LocalDate.of(1, 1, 1), LocalTime.of(00, 00));
        Appointment appointment = new Appointment(1, clinic, "Checkup", dateAndTime, "Just a checkup", "Active");
        assertEquals(LocalDate.of(1, 1, 1), appointment.getDate(), "Appointment should handle minimum valid date");
    }

    // ID Tests
    @Test
    void testAppointmentWithZeroId() {
        Appointment appointment = new Appointment(
                0, clinic, "Checkup", null, "Just a checkup", "Active"
        );
        assertEquals(0, appointment.getAppointmentId(), "Appointment should accept zero as a valid ID");
    }

    @Test
    void testAppointmentWithPositiveId() {
        Appointment appointment = new Appointment(
                42, clinic, "Checkup", null, "Just a checkup", "Active"
        );
        assertEquals(42, appointment.getAppointmentId(), "Appointment should accept positive IDs");
    }

    @Test
    void testAppointmentManyIds() {
        Appointment appointment1 = new Appointment(1, clinic, "Checkup1", null, "Checkup 1", "Active");
        Appointment appointment2 = new Appointment(100, clinic, "Checkup2", null, "Checkup 2", "Active");
        Appointment appointment3 = new Appointment(1000000, clinic, "Checkup3", null, "Checkup 3", "Active");

        assertAll("ids",
                () -> assertEquals(1, appointment1.getAppointmentId()),
                () -> assertEquals(100, appointment2.getAppointmentId()),
                () -> assertEquals(1000000, appointment3.getAppointmentId())
        );
    }

    @Test
    void testAppointmentBoundaryId() {
        Appointment appointment = new Appointment(
                Integer.MAX_VALUE, clinic, "Checkup", null, "Just a checkup", "Active"
        );
        assertEquals(Integer.MAX_VALUE, appointment.getAppointmentId(), "Appointment should handle maximum integer ID");
    }

    @Test
    void testAppointmentExceptionNegativeId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(-1, clinic, "Checkup", null, "Just a checkup", "Active");
        }, "Exception should be thrown for negative ID");
    }

    // Clinic Tests
    @Test
    void testAppointmentWithNullClinic() {
        Appointment appointment = new Appointment(
                1, null, "Checkup", null, "Just a checkup", "Active"
        );
        assertNull(appointment.getClinic(), "Appointment should allow null clinic");
    }

    @Test
    void testAppointmentWithClinic() {
        Clinic testClinic = new Clinic("2", "Another Clinic", "Aarhus", "Main Street", "22");
        Appointment appointment = new Appointment(
                1, testClinic, "Checkup", null, "Just a checkup", "Active"
        );
        assertEquals(testClinic, appointment.getClinic(), "Appointment should store the correct clinic");
    }

    @Test
    void testAppointmentManyClinics() {
        Clinic clinic1 = new Clinic("1", "Clinic One", "Vejle", "Street1", "10");
        Clinic clinic2 = new Clinic("2", "Clinic Two", "Aarhus", "Street2", "20");
        Clinic clinic3 = new Clinic("3", "Clinic Three", "Copenhagen", "Street3", "30");

        Appointment appointment1 = new Appointment(1, clinic1, "Checkup1", null, "Desc1", "Active");
        Appointment appointment2 = new Appointment(2, clinic2, "Checkup2", null, "Desc2", "Active");
        Appointment appointment3 = new Appointment(3, clinic3, "Checkup3", null, "Desc3", "Active");

        assertAll("clinics",
                () -> assertEquals(clinic1, appointment1.getClinic()),
                () -> assertEquals(clinic2, appointment2.getClinic()),
                () -> assertEquals(clinic3, appointment3.getClinic())
        );
    }

    // Status Tests

    @Test
    void testAppointmentWithValidStatus() {
        Appointment appointment = new Appointment(
                1, clinic, "Checkup", null, "Just a checkup", "Active"
        );
        assertEquals("Active", appointment.getStatus(), "Appointment should store the correct status");
    }

    @Test
    void testAppointmentManyStatuses() {
        Appointment appointment1 = new Appointment(1, clinic, "Checkup1", null, "Desc1", "Active");
        Appointment appointment2 = new Appointment(2, clinic, "Checkup2", null, "Desc2", "Cancelled");
        Appointment appointment3 = new Appointment(3, clinic, "Checkup3", null, "Desc3", "Expired");

        assertAll("statuses",
                () -> assertEquals("Active", appointment1.getStatus()),
                () -> assertEquals("Cancelled", appointment2.getStatus()),
                () -> assertEquals("Expired", appointment3.getStatus())
        );
    }

    // Description Tests
    @Test
    void testAppointmentWithZeroLengthDescription() {
        Appointment appointment = new Appointment(
                1, clinic, "Checkup", null, "", "Active"
        );
        assertEquals("", appointment.getDescription(), "Appointment should accept zero-length description");
    }

    @Test
    void testAppointmentWithValidDescription() {
        Appointment appointment = new Appointment(
                1, clinic, "Checkup", null, "Just a checkup", "Active"
        );
        assertEquals("Just a checkup", appointment.getDescription(), "Appointment should store the correct description");
    }

    @Test
    void testAppointmentManyDescriptions() {
        Appointment appointment1 = new Appointment(1, clinic, "Checkup1", null, "Short desc", "Active");
        Appointment appointment2 = new Appointment(2, clinic, "Checkup2", null, "Medium description", "Active");
        Appointment appointment3 = new Appointment(3, clinic, "Checkup3", null, "Very long description that provides more details", "Active");

        assertAll("descriptions",
                () -> assertEquals("Short desc", appointment1.getDescription()),
                () -> assertEquals("Medium description", appointment2.getDescription()),
                () -> assertEquals("Very long description that provides more details", appointment3.getDescription())
        );
    }

    @Test
    void testAppointmentBoundaryDescriptionLength() {
        String longDescription = "A".repeat(1000);
        Appointment appointment = new Appointment(
                1, clinic, "Checkup", null, longDescription, "Active"
        );
        assertEquals(longDescription, appointment.getDescription(), "Appointment should handle long description strings");
    }

    @Test
    void testNullDescriptionDefaultsToEmptyString() {
        Appointment appointment = new Appointment(1, null, "Checkup", null, null, "Active");
        assertEquals("", appointment.getDescription(), "Description should default to an empty string when null is provided");
    }
}