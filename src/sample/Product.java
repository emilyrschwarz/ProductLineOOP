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

  /**
   * Creates a Product object using its name, manufacturer, and type.
   *
   * @param name The name of the product.
   * @param manufacturer The person/company that made the product.
   * @param type The type of product.
   */
  public Product(String name, String manufacturer, String type) {
    this.name = name;
    this.manufacturer = manufacturer;
    this.type = type;
    id = 0;
  }

  /**
   * toString() returns a string of properties of a specific product.
   *
   * @return A string of the name, manufacturer, and type of product.
   */
  public String toString() {
    return "Name: " + name + "\nManufacturer: " + manufacturer + "\nType: " + type;
  }

  // MUTATOR METHODS
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

  // ACCESSOR METHODS
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

/** The Widget Class instantiates objects of Product. Product is an Abstract Class. */
class Widget extends Product {
  public Widget(String name, String manufacturer, ItemType type) {
    super(name, manufacturer, type.toString());
  }
}
