package sample;

/**
 * This is the Multimedia Control Interface. This holds the controls of video and audio players,
 * since they are the same.
 *
 * @author Emily R Schwarz
 */
public interface MultimediaControl {
  public void play();

  public void stop();

  public void previous();

  public void next();
}
