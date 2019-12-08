package sample;

/**
 * This is the Screen Class. This contains code to display a movie to a movie player.
 *
 * @author Emily R Schwarz
 */
public class Screen implements ScreenSpec {

  String resolution;
  int refreshRate;
  int responseTime;

  /**
   * Sets the screen resolution, refresh rate, and response time for each product.
   *
   * @param theResolution The resolution of the screen.
   * @param theRefreshRate The refresh rate of the screen. The time the screen takes to update.
   * @param theResponseTime The response time of the screen. The speed the screen reacts at.
   */
  public Screen(String theResolution, int theRefreshRate, int theResponseTime) {
    resolution = theResolution;
    refreshRate = theRefreshRate;
    responseTime = theResponseTime;
  }

  /**
   * toString() returns a String of properties about the specific product.
   *
   * @return This returns a String of the screen resolution, refresh rate, and response time.
   */
  public String toString() {

    return "Screen:"
        + "\nResolution: "
        + resolution
        + "\nRefresh rate: "
        + refreshRate
        + "\nResponse time: "
        + responseTime;
  }

  @Override
  public String getResolution() {
    return resolution;
  }

  @Override
  public int getRefreshRate() {
    return refreshRate;
  }

  @Override
  public int getResponseTime() {
    return responseTime;
  }
}
