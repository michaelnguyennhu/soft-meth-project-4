package main;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CurrentOrderDetailController
{

    @FXML
    public ListView orderList;
    @FXML
    public Button removeSelectedButton;

    @FXML
    public Text subtotalText;
    @FXML
    public Text taxText;
    @FXML
    public Text totalText;

    private Stage primaryStage;

    private MainMenuController mainMenuController;

    public void start(Stage primaryStage, MainMenuController mainMenuData) {

        mainMenuController = mainMenuData;

        this.primaryStage = primaryStage;

        //This may not be required
        orderList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        orderList.getItems().add("Test");
        update();
    }

    public void buildList(){

    }


    public void backToMainMenu(){
        primaryStage.close();
    }

    @FXML
    public void update() {
        ObservableList selectedOrders = orderList.getSelectionModel().getSelectedIndices();
        removeSelectedButton.setDisable(!(selectedOrders.size() > 0));

        subtotalText.setText("Subtotal - $0.00");
        taxText.setText("Tax - $0.00");
        taxText.setText("Total - $0.00");
    }

    @FXML
    public void removeSelected() {

    }

    @FXML
    public void placeOrder() {

    }

}
