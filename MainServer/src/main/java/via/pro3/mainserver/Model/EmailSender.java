package via.pro3.mainserver.Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender implements EmailSenderInterface
{

  final String username = "postmaster@sandboxeba37d0ff69a41dd8bdd56e3e3375b87.mailgun.org";
  final String password = "16b0692833cb1e05e20ef3da71ee851e-da554c25-96eaede1";

  Properties props = new Properties();

  public EmailSender()
  {
    props.put("mail.smtp.host", "smtp.mailgun.org");
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");  // Enable STARTTLS for port 587
  }

  @Override public void sendBookingConfirmation(String doctorMail,
      String patientMail, Appointment appointment)
  {
    String doctorSubject = "New appointment booking";
    String doctorMessage =
        "A new appointment has been made at: " + appointment.getDateAndTime();

    String patientSubject = "New appointment made";
    String patientMessage =
        "A new appointment made: " + appointment.getDateAndTime();

    sendEmail(doctorMail, doctorSubject, doctorMessage);
    sendEmail(patientMail, patientSubject, patientMessage);

  }

  @Override public void sendBookingCancellation(String doctorMail,
      String patientMail, Appointment appointment)
  {
    String doctorSubject = "Appointment has been canceled";
    String doctorMessage =
        "An appointment has been cancelled at: " + appointment.getDateAndTime();

    String patientSubject = "Appointment has been canceled";
    String patientMessage =
        "An appointment has been cancelled at: " + appointment.getDateAndTime();

    sendEmail(doctorMail, doctorSubject, doctorMessage);
    sendEmail(patientMail, patientSubject, patientMessage);
  }

  private void sendEmail(String recipient, String subject, String message)
  {
    try
    {
      Session session = Session.getInstance(props, new Authenticator()
      {
        @Override protected PasswordAuthentication getPasswordAuthentication()
        {
          return new PasswordAuthentication(username, password);
        }
      });

      Message msg = new MimeMessage(session);
      msg.setFrom(new InternetAddress(username));
      msg.setRecipient(Message.RecipientType.TO,
          new InternetAddress("mkgbarczuk@gmail.com")); //HARDCODED BECAUSE WE'RE JUST POOR STUDENTS WHO DON'T WANT TO PAY FOR DOMAIN :(
      msg.setSubject(subject);
      msg.setText(message);

      //send mail
      Transport.send(msg);

    }
    catch (MessagingException e)
    {
      e.printStackTrace();
    }
  }
}
