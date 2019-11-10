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

  ItemType(String itemCode) {
    code = itemCode;
  }
}
