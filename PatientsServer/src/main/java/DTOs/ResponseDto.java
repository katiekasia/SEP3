package DTOs;

import java.util.ArrayList;
import java.util.List;

public class ResponseDto
{
  private String response;
  private List<GetAppointmentsDto> appointments = new ArrayList<>();

  //---for changing status to Cancelled----------------------------------
  private boolean success;
  public ResponseDto() {}

  public ResponseDto(String response, boolean success) {
    this.response = response;
    this.success = success;
  }

  public static ResponseDto createCancellationSuccess() {
    return new ResponseDto("Appointment cancelled successfully", true);
  }

  public static ResponseDto createCancellationError(String errorMessage) {
    return new ResponseDto("Failed to cancel appointment: " + errorMessage, false);
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }
//----------------------------------------------------------------



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
