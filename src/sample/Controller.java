package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

/**
 * This is the Controller class. This is where the FXML and connection to the Database go.
 * @author Emily R. Schwarz
 * 9/30/19
 */

public class Controller {

  private Connection conn;

  static final String JDBC_DRIVER = "org.h2.Driver";
  static final String DB_URL = "jdbc:h2:./res/ProductLineDatabase";


  @FXML ComboBox<Integer> produceQuantityComboBox;

  /**
   *
   * @param event This event represents when the button "Add Product" is clicked.
   */

  @FXML
  void addProductButtonClick(ActionEvent event) {

    try (Statement statement = conn.createStatement()) {

      statement.execute(
          "INSERT INTO Product(type, manufacturer, name) VALUES ( 'AUDIO', 'Apple', 'iPod' );");

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @FXML
  void recordProdButtonClick(ActionEvent event) {

    System.out.println("Production Button");
  }

  void initialize() {

    // intelliJ must be disconnected from database in order for program to connect

    //  Database credentials
    conn = null;

    try {
      // STEP 1: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      // STEP 2: Open a connection
      conn = DriverManager.getConnection(DB_URL);

      // STEP 3: Execute a query

      // STEP 4: Clean-up environment
      conn.close();
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    produceQuantityComboBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    produceQuantityComboBox.setEditable(true);

    produceQuantityComboBox.getSelectionModel().selectFirst();
  }
}
