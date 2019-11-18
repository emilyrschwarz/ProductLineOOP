package sample;

import static sample.ItemType.AUDIO;
import static sample.ItemType.AUDIO_MOBILE;
import static sample.ItemType.VISUAL;
import static sample.ItemType.VISUAL_MOBILE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * This is the Controller class. This is where the FXML and connection to the Database go.
 *
 * @author Emily R Schwarz 9/30/19
 */
public class Controller {

  private Connection conn;
  private Statement stmt;

  static final String JDBC_DRIVER = "org.h2.Driver";
  static final String DB_URL = "jdbc:h2:./res/ProductLineDatabase";

  @FXML private GridPane mainGridPane;

  @FXML private TabPane mainTabPane;

  @FXML private Tab productLineTab;

  @FXML private AnchorPane productLinePane;

  @FXML private GridPane productLineGridPane;

  @FXML private Label productNameLabel;

  @FXML private TextField productNameTxtField;

  @FXML private Label manufacturerLabel;

  @FXML private Label itemTypeLabel;

  @FXML private TextField manuTxtField;

  @FXML private ChoiceBox<ItemType> itemTypeChoiceBx;

  @FXML private Button addProductBtn;

  @FXML private TableView<Product> existingProductsTblView;

  @FXML private TableColumn<?, ?> productCol;

  @FXML private TableColumn<?, ?> manuCol;

  @FXML private TableColumn<?, ?> itemTypeCol;

  @FXML private TableColumn<?, ?> idCol;

  @FXML private Label existingProductsLabel;

  @FXML private Tab produceTab;

  @FXML private Label chooseProductLabel;

  @FXML private Label chooseQuantityLabel;

  @FXML private ListView<Product> chooseLabelListView;

  @FXML private ComboBox<Integer> produceQuantityComboBox;

  @FXML private Button recordProdBtn;

  @FXML private Tab productionLogTab;

  @FXML private TextArea productionLogTxtArea;

  private ObservableList<Product> productLine = FXCollections.observableArrayList();

  /** Initialize initializes the database. */
  public void initialize() {

    // intelliJ must be disconnected from database in order for program to connect

    //  Database credentials
    conn = null;
    stmt = null;

    try {
      // Register JDBC driver
      Class.forName(JDBC_DRIVER);

      // Open a connection
      conn = DriverManager.getConnection(DB_URL);
      stmt = conn.createStatement();

      // Clean-up environment
      produceQuantityComboBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

      produceQuantityComboBox.setEditable(true);

      produceQuantityComboBox.getSelectionModel().selectFirst();

      itemTypeChoiceBx.getItems().addAll(AUDIO, VISUAL, AUDIO_MOBILE, VISUAL_MOBILE);

      itemTypeChoiceBx.getSelectionModel().selectFirst();

      // conn.close();
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  } // END INITIALIZE
  /**
   * @param event This event represents when the button "Add Product" is clicked.
   * @throws SQLException
   */
  @FXML
  void addProductButtonClick(ActionEvent event) throws SQLException {

    try {
      String query = "INSERT INTO PRODUCT(name, manufacturer, type) VALUES (?, ?, ?)";
      PreparedStatement ps = conn.prepareStatement(query);
      ps.setString(1, productNameTxtField.getText());
      ps.setString(2, manuTxtField.getText());
      ps.setString(3, itemTypeChoiceBx.getValue().code);

      ps.executeUpdate();
      ps.close();
      conn.close();

      System.out.println("Item has been added!");

    } catch (SQLException e) {
      e.printStackTrace();
      conn.close();
    }
    try {
      String sql = "SELECT * FROM PRODUCT";

      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {

        // these lines correspond to the database table columns
        int id = rs.getInt(1);
        String name = rs.getString(2);
        String type = rs.getString(3);
        String manufacturer = rs.getString(4);
        // create object
        ItemType prodType = null;

        if (type.equals("AU")) {
          prodType = AUDIO;
        } else if (type.equals("VI")) {
          prodType = VISUAL;
        } else if (type.equals("AM")) {
          prodType = AUDIO_MOBILE;
        } else if (type.equals("VM")) {
          prodType = VISUAL_MOBILE;
        }

        // COLUMNS //

        productCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        manuCol.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
        itemTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        Product product = new Widget(name, manufacturer, prodType);

        product.setId(id++);
        productLine.add(product);
      }
      existingProductsTblView.setItems(productLine);
      chooseLabelListView.setItems(productLine);
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
      conn.close();
    }
  } // END ADD PRODUCT BTN

  /**
   * @param event This event represents when the "Record Production" button is clicked.
   * @throws SQLException
   */
  @FXML
  void recordProdButtonClick(ActionEvent event) throws SQLException {
    System.out.println("Production Recorded!");
  } // END RECORD PRODUCTION BTN
}
