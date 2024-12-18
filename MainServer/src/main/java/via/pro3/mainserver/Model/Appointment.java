package via.pro3.mainserver.Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private int id;
    private MyDateAndTime dateAndTime;
    private String description;
    private AppointmentState status;
    private String type;
    private Clinic clinic;

    public Appointment(int id, Clinic clinic, String type,
                       MyDateAndTime dateAndTime, String description, String status) {
        if(id < 0)
          throw new IllegalArgumentException("id cannot be negative");
        else
          setId(id);
        setClinic(clinic);
        setType(type);
        setDateAndTime(dateAndTime);
        setDescription(description);
      switch (status) {
        case "Active" -> setStatus(new ActiveAppointment());
        case "Cancelled" -> setStatus(new CancelledAppointment());
        default -> setStatus(new ExpiredAppointment());
      }
    }

    public void cancel() {
        status.cancel(this);
    }

    public void expire() {
        if (dateAndTime == null) {
            System.out.println("No date and time set for the appointment; cannot expire.");
            return;
        }
        if (LocalDate.now().isAfter(dateAndTime.getDate()) ||
                (LocalDate.now().isEqual(dateAndTime.getDate()) && LocalTime.now().isAfter(dateAndTime.getTime()))) {
            status.expire(this);
        }
    }

    //GETTERS BELOW*************************
    public int getAppointmentId() {
        return id;
    }

    public LocalDate getDate() {
        return dateAndTime != null ? dateAndTime.getDate() : null;
    }

    public String getType() {
        return type;
    }

    public String getCity() {
      return clinic != null ? clinic.getCity() : "No clinic assigned";
    }

    public LocalTime getTime() {
        return dateAndTime != null ? dateAndTime.getTime() : null;
    }

    public String getDescription() {
        return description != null ? description : "";
    }

    public String getStatus() {
        expire();
        return status.status();
    }

    public String getAdressString() {
      return clinic != null ? clinic.getAddress() : "No clinic address available";
    }

    public Clinic getClinic() {
      return clinic != null ? clinic.copy() : null;
    }

    public String getClinicName() {
      return clinic != null ? clinic.getName() : "No clinic name available";
    }

    public MyDateAndTime getDateAndTime() {
        return dateAndTime.copy();
    }


    //SETTERS BELOW****************************88
    public void setId(int appointmentId) {
        this.id = appointmentId;
    }

    public void setDate(LocalDate date) {
        dateAndTime.setDate(date);
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDateAndTime(MyDateAndTime dateAndTime) {
        this.dateAndTime = dateAndTime != null ? dateAndTime.copy() : null;
    }

    public void setClinic(Clinic clinic) {
      this.clinic = clinic != null ? clinic.copy() : null;
    }

    public void setTime(LocalTime time) {
        dateAndTime.setTime(time);
    }

    public void setDescription(String description) {
        if (description != null) {
            this.description = description;
        } else this.description = "";
    }

    public void setStatus(AppointmentState status) {
        this.status = status;
    }

}

