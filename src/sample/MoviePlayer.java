package sample;

/**
 * This is the Movie Player Class. This class implements Multimedia Control functions.
 *
 * @author Emily R Schwarz
 */
public class MoviePlayer extends Product implements MultimediaControl {

  Screen screen;
  MonitorType monitorType;

  /**
   * Creates a movie player product using the name and manufacturer and sets the screen and monitor
   * types that were inputted.
   *
   * @param name The name of the movie player.
   * @param manufacturer The manufacturer of the movie player.
   * @param screen The type of screen each player has.
   * @param monitorType The type of monitor each player has.
   */
  public MoviePlayer(String name, String manufacturer, Screen screen, MonitorType monitorType) {
    super(name, manufacturer, "VISUAL");
    this.screen = screen;
    this.monitorType = monitorType;
  }

  @Override
  public void play() {
    System.out.println("Playing movie");
  }

  @Override
  public void stop() {
    System.out.println("Stopping movie");
  }

  @Override
  public void previous() {
    System.out.println("Previous movie");
  }

  @Override
  public void next() {
    System.out.println("Next movie");
  }

  /**
   * toString() returns a String of properties that correspond to the specific movie player logged.
   *
   * @return This returns a String of the name, manufacturer, type, screen, and monitor of a movie
   *     player.
   */
  public String toString() {
    return "Name: "
        + getName()
        + "\nManufacturer: "
        + getManufacturer()
        + "\nType: "
        + getType()
        + "\n"
        + screen
        + "\nMonitor Type: "
        + monitorType;
  }

  // MUTATOR METHODS
  public void setScreen(Screen theScreen) {
    screen = theScreen;
  }

  public void setMonitorType(MonitorType theMonitor) {
    monitorType = theMonitor;
  }

  // ACCESSOR METHODS
  public Screen getScreen() {
    return screen;
  }

  public MonitorType getMonitorType() {
    return monitorType;
  }
}
