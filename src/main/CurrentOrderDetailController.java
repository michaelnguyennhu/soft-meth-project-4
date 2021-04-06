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
    private final float TAX = 0.06625f;

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
        orderList.getItems().add("Test2");
        orderList.getItems().add("Test3");
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

        float subtotal = mainMenuController.getCurrentOrder().getPriceTotal();
        float tax = subtotal * TAX;
        float total = subtotal + tax;


        subtotalText.setText("Subtotal - " + Utility.ToDollars(subtotal));
        taxText.setText("Tax - " +  Utility.ToDollars(tax));
        taxText.setText("Total - " + Utility.ToDollars(total));
    }

    @FXML
    public void removeSelected() {

    }

    @FXML
    public void placeOrder() {

        mainMenuController.getAllStoreOrders().add(mainMenuController.getCurrentOrder());
        System.out.println(mainMenuController.getCurrentOrder().toString());
    }

}
