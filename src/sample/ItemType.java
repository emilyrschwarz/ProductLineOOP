package sample;

public enum ItemType {
    // AU, VI, AM, VM
    AUDIO("AU"),
    VISUAL("VI"),
    AUDIO_MOBILE("AM"),
    VISUAL_MOBILE("VM");
    private final String code;

    ItemType(String itemCode) {
      code = itemCode;
    }

}
