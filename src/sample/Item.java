package sample;

/**
 * This is the Item Interface.
 *
 * @author Emily R Schwarz
 */
public interface Item {

  /** MUTATOR METHODS * */
  public void setName(String theName);

  public void setManufacturer(String theManu);

  /** ACCESSOR METHODS * */
  public int getId();

  public String getName();

  public String getManufacturer();
}
