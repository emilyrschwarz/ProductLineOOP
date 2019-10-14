package sample;

public abstract class Product implements Item {

  private int id;
  private String type;
  private String manufacturer;
  private String name;

  public Product(String name, String manufacturer, String type) {
    this.name = name;
    this.manufacturer = manufacturer;
    this.type = type;
  }

  public String toString() {
    return "Name: " + name + "\nManufacturer: " + manufacturer + "\nType: " + type;
  }

  public int getId() {
    return id;
  }

  public void setName(String theName) {
    name = theName;
  }

  public String getName() {
    return name;
  }

  public void setManufacturer(String theManu) {
    manufacturer = theManu;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setType(String theType) {
    type = theType;
  }

  public String getType() {
    return type;
  }
}
