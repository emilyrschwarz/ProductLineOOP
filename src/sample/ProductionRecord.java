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

  /** @param productId records a product by using its ID */
  public ProductionRecord(int productId) {

    productionNumber = 0;
    serialNumber = "0";
    dateProduced = new Date();
  }

  /**
   * @param product product item
   * @param count variable that updates to give product a serial number
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
   * @param productId generated ID of the product
   * @param productionNumber number assigned to product after production
   * @param serialNumber given number after product is created
   * @param dateProduced when product was produced
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

  // SETTERS //

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

  // GETTERS //

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
