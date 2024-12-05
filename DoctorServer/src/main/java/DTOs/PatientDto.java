package DTOs;

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
}
