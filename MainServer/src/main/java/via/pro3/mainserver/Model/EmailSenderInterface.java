package via.pro3.mainserver.Model;

public interface EmailSenderInterface
{
  void sendBookingConfirmation(String doctorMail, String patientMail, Appointment appointment);
  void sendBookingCancellation(String doctorMail, String patientMail, Appointment appointment);

}

