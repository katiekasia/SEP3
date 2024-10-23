package via.pro3.doctorserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication public class DoctorServerApplication
{

  public static void main(String[] args)
  {
    try {
      // Retrieve and print the local host IP address
      InetAddress localHost = InetAddress.getLocalHost();
      String ipAddress = localHost.getHostAddress();
      System.out.println("Server is starting...");
      System.out.println("Server IP Address: " + ipAddress);
    } catch (UnknownHostException e) {
      System.err.println("Unable to retrieve IP address: " + e.getMessage());
    }
    SpringApplication.run(DoctorServerApplication.class, args);
  }

}
