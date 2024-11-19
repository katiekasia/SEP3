package via.pro3.mainserver.Model;

public class Clinic
{
  private String name;
  private String city;
  private String street;
  private String streetNo;

  public Clinic(String name, String city, String street, String streetNo){
    setName(name);
    setCity(city);
    setStreet(street);
    setStreetNo(streetNo);
  }
  public Clinic copy(){
    return new Clinic(getName(), getCity(), getStreet(), getStreetNo());
  }


//GETTERS BELOW***********************************

  public String getAddress(){
    return getCity() + " " + getStreet() + " " + getStreetNo();
  }
  public String getName()
  {
    return name;
  }

  public String getCity()
  {
    return city;
  }

  public String getStreet()
  {
    return street;
  }

  public String getStreetNo()
  {
    return streetNo;
  }
  @Override public String toString(){
    return getName() + " " + getAddress();
  }

  //SETTERS BELOW************************

  public void setCity(String city)
  {
    this.city = city;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setStreet(String street)
  {
    this.street = street;
  }

  public void setStreetNo(String streetNo)
  {
    this.streetNo = streetNo;
  }
}
