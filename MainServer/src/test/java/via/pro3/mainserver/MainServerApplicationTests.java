package via.pro3.mainserver;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import via.pro3.mainserver.Model.Appointment;
import via.pro3.mainserver.Model.Clinic;
import via.pro3.mainserver.Model.MyDateAndTime;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@TestPropertySource(properties = {
        "grpc.server.port=0",  // Use random port for testing
        "grpc.server.enable=false"  // Optionally disable gRPC server during tests
})
class MainServerApplicationTests {
  private static Clinic clinic;

  @BeforeAll
  static void setup() {
    clinic = new Clinic("1", "Test Clinic", "Horsens", "Kamtjatka", "13");
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
  void testAppointmentWithNullDate() {
    Appointment appointment = new Appointment(
            1, clinic, "Checkup", null, "Just a checkup", "Active"
    );
    assertNull(appointment.getDate());
  }
}
