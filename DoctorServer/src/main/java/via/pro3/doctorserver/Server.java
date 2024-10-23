package via.pro3.doctorserver;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/doctorname")

public class Server
{
  @GetMapping("/name")
  public String getDoctorName(@RequestParam String name)
  {
    System.out.println("Client connected at: " + LocalDateTime.now() + " - Received name: " + name);

    return "Hello, " + name;
  }

}
