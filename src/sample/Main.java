package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is the main class. It opens the JavaFX application.
 *
 * @author Emily R Schwarz 9/30/19
 */
public class Main extends Application {

  /**
   * The start method is the starting point of a JavaFX program. This starts method sets the title.
   *
   * @brief This program manages product logging/creation.
   * @param primaryStage The primary stage.
   * @throws Exception Any problem with the code.
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    root.getStylesheets().add(getClass().getResource("ProductLineStylesheet.css").toExternalForm());
    primaryStage.setTitle("Product Line");
    primaryStage.setScene(new Scene(root));
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
