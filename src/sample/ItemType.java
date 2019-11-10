package sample;

/**
 * This is the Item Type Enum.
 *
 * @author Emily R Schwarz
 */
public enum ItemType {
  // AU, VI, AM, VM
  AUDIO("AU"),
  VISUAL("VI"),
  AUDIO_MOBILE("AM"),
  VISUAL_MOBILE("VM");
  public final String code;

  /** @param itemCode Gives a String value to the corresponding Enum type. */
  ItemType(String itemCode) {
    code = itemCode;
  }
}
