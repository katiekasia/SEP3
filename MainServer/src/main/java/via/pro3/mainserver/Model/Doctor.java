package via.pro3.mainserver.Model;

public class Doctor
{
  private String name;
  private String surname;
  private String password;
  private String email;
  private int id;
  private String specialisation;

  public Doctor(int id, String name, String surname, String password, String email,  String specialisation)
  {
    setName(name);
    setSurname(surname);
    setPassword(password);
    setEmail(email);
    setId(id);
    setSpecialisation(specialisation);
  }

//GETTERS BELOW**************************

  public String getEmail()
  {
    return email;
  }

  public int getId()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }

  public String getPassword()
  {
    return password;
  }

  public String getSurname()
  {
    return surname;
  }

  public String getSpecialisation()
  {
    return specialisation;
  }
  @Override public String toString(){
  return getId() + getName() + " " + getSurname() + " " + getSpecialisation();
  }
//SETTERS BELOW*********************************

  public void setName(String name)
  {
    this.name = name;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public void setSpecialisation(String specialisation)
  {
    this.specialisation = specialisation;
  }

  public void setSurname(String surname)
  {
    this.surname = surname;
  }

}
