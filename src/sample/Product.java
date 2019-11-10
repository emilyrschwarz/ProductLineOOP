package sample;

/**
 * This is the Product Abstract Class and the Widget Class.
 *
 * @author Emily R Schwarz
 */
public abstract class Product implements Item {

  private int id;
  private String type;
  private String manufacturer;
  private String name;

  public Product(String name, String manufacturer, String type) {
    this.name = name;
    this.manufacturer = manufacturer;
    this.type = type;
    id = 0;
  }

  public String toString() {
    return "Name: " + name + "\nManufacturer: " + manufacturer + "\nType: " + type;
  }

  // SETTERS //

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String theName) {
    name = theName;
  }

  public void setManufacturer(String theManu) {
    manufacturer = theManu;
  }

  public void setType(String theType) {
    type = theType;
  }

  // GETTERS //

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public String getType() {
    return type;
  }
}

// WIDGET CLASS //

class Widget extends Product {
  public Widget(String name, String manufacturer, ItemType type) {
    super(name, manufacturer, type.toString());
  }
}
