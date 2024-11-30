package models;

public class Contact {
  private int id;
  private String name;
  private String adress;
  private String neighborhood;
  private String city;
  private String state;
  private String phone_number;
  private String email;
  private String cpf;

  public Contact(int id, String name, String adress, String neighborhood, String city, String state,
      String phone_number, String email, String cpf) {
    this.id = id;
    this.name = name;
    this.adress = adress;
    this.neighborhood = neighborhood;
    this.city = city;
    this.state = state;
    this.phone_number = phone_number;
    this.email = email;
    this.cpf = cpf;
  }

  @Override
  public String toString() {
    return "Contact{" + "id=" + id + ", name='" + name + '\'' + ", adress='" + adress + '\'' + ", neighborhood='"
        + neighborhood + '\'' + ", city='" + city + '\'' + ", state='" + state + '\'' + ", phone_number='"
        + phone_number + '\'' + ", email='" + email + '\'' + "}\n";
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAdress() {
    return adress;
  }

  public void setAdress(String adress) {
    this.adress = adress;
  }

  public String getNeighborhood() {
    return neighborhood;
  }

  public void setNeighborhood(String neighborhood) {
    this.neighborhood = neighborhood;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getPhoneNumber() {
    return phone_number;
  }

  public void setPhoneNumber(String phone_number) {
    this.phone_number = phone_number;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
}
