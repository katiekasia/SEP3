package DTOs;

public class UserDto
{
  private String name;
  private String surname;
  private String email;
private String phone;
private String cpr;

  public String getCpr()
  {
    return cpr;
  }

  public String getEmail()
  {
    return email;
  }

  public String getName()
  {
    return name;
  }

  public String getSurname()
  {
    return surname;
  }

  public String getPhone()
  {
    return phone;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setCpr(String cpr)
  {
    this.cpr = cpr;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public void setPhone(String phone)
  {
    this.phone = phone;
  }

  public void setSurname(String surname)
  {
    this.surname = surname;
  }
}
