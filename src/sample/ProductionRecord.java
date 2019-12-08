package sample;

import java.util.Date;

/**
 * This is the Production Record Class.
 *
 * @author Emily R Schwarz
 */
public class ProductionRecord {

  private int productionNumber;
  private int productId;
  private String serialNumber;
  private Date dateProduced;

  /**
   * Sets initial production number, serial number, and date to a product in production record.
   *
   * @param productId Records a product by using its ID.
   */
  public ProductionRecord(int productId) {

    productionNumber = 0;
    serialNumber = "0";
    dateProduced = new Date();
  }

  /**
   * Creates a serial number for a product and sets the date the product was produced.
   *
   * @param product The product item.
   * @param count A variable that updates to give the product a serial number.
   */
  public ProductionRecord(Product product, int count) {
    serialNumber =
        product.getManufacturer().substring(0, 3)
            + product.getType().substring(0, 2)
            + "0000"
            + count;
    dateProduced = new Date();
  }

  /**
   * Sets the current date and a new serial number/production number/product ID to a product.
   *
   * @param productId A generated ID of the product.
   * @param productionNumber The number assigned to product after production.
   * @param serialNumber The given number after the product is created.
   * @param dateProduced When the product was produced.
   */
  public ProductionRecord(
      int productId, int productionNumber, String serialNumber, Date dateProduced) {
    this.dateProduced = dateProduced;
    this.serialNumber = serialNumber;
    this.productionNumber = productionNumber;
    this.productId = productId;
  }

  @Override
  public String toString() {
    return "Prod. Num: "
        + productionNumber
        + " Product ID: "
        + productId
        + " Serial Num: "
        + serialNumber
        + " Date: "
        + dateProduced;
  }

  // MUTATOR METHODS
  public void setProductionNum(int productionNumber) {
    this.productionNumber = productionNumber;
  }

  public void setProductID(int productId) {
    this.productId = productId;
  }

  public void setSerialNum(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  public void setProdDate(Date dateProduced) {
    this.dateProduced = dateProduced;
  }

  // ACCESSOR METHODS
  public int getProductionNum() {
    return productionNumber;
  }

  public int getProductID() {
    return productId;
  }

  public String getSerialNum() {
    return serialNumber;
  }

  public Date getProdDate() {
    return dateProduced;
  }
}
