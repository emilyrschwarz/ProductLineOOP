package sample;

/**
 * This is the Audio Player class. This holds multimedia control for audio players.
 *
 * @author Emily R Schwarz
 */
public class AudioPlayer extends Product implements MultimediaControl {

  private String supportedAudioFormats;
  private String supportedPlaylistFormats;

  /**
   * Creates and sets the name, manufacturer, supported audio formats, and supported playlist
   * formats of an audio player.
   *
   * @param name The name of the audio player.
   * @param manufacturer The manufacturer of the audio player.
   * @param supportedAudioFormats The supported audio formats of the audio player.
   * @param supportedPlaylistFormats The supported playlist formats of the audio player.
   */
  public AudioPlayer(
      String name,
      String manufacturer,
      String supportedAudioFormats,
      String supportedPlaylistFormats) {
    super(name, manufacturer, "AUDIO");
    this.supportedAudioFormats = supportedAudioFormats;
    this.supportedPlaylistFormats = supportedPlaylistFormats;
  }

  @Override
  public void play() {
    System.out.println("Playing");
  }

  @Override
  public void stop() {
    System.out.println("Stopping");
  }

  @Override
  public void previous() {
    System.out.println("Previous");
  }

  @Override
  public void next() {
    System.out.println("Next");
  }

  /**
   * toString() returns a string of properties about a specific audio player.
   *
   * @return Returns a String of the name, manufacturer, type, supported audio formats, and
   *     supported playlist formats of the audio player.
   */
  public String toString() {
    return "Name: "
        + getName()
        + "\nManufacturer: "
        + getManufacturer()
        + "\nType: "
        + getType()
        + "\nSupported Audio Formats: "
        + supportedAudioFormats
        + "\nSupported Playlist Formats: "
        + supportedPlaylistFormats;
  }

  // MUTATOR METHODS
  public void setSupportedAudioFormats(String supportAF) {
    supportedAudioFormats = supportAF;
  }

  public void setSupportedPlaylistFormats(String supportPF) {
    supportedPlaylistFormats = supportPF;
  }

  // ACCESSOR METHODS
  public String getSupportedAudioFormats() {
    return supportedAudioFormats;
  }

  public String getSupportedPlaylistFormats() {
    return supportedPlaylistFormats;
  }
}
