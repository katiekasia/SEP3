package DTOs;

import java.util.ArrayList;
import java.util.List;

public class ResponseDto
{
  private String response;
  private List<GetAppointmentsDto> appointments = new ArrayList<>();

  public String getResponse() {
    return response;
  }

  public void setResponse(String response) {
    this.response = response;
  }

  public List<GetAppointmentsDto> getAppointments() {
    return appointments;
  }

  public void setAppointments(List<GetAppointmentsDto> appointments) {
    this.appointments = appointments;
  }
}
