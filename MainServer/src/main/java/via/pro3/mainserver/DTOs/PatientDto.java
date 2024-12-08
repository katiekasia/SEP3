package via.pro3.mainserver.DTOs;

import via.pro3.mainserver.Model.Patient;

public class PatientDto {
    public String cprNumber;
    public String email;
    public String firstName;
    public String lastName;
    public String phoneNumber;

    public PatientDto(String cprNumber, String firstName, String lastName, String email, String phoneNumber) {
        this.cprNumber = cprNumber;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getCprNumber() {
        return cprNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
