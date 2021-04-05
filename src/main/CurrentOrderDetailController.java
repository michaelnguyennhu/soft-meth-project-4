package main;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;

public class CurrentOrderDetailController
{

    @FXML
    public ListView orderList;
    @FXML
    public Button removeSelectedButton;

    private Stage primaryStage;

    private MainMenuController mainMenuController;

    public void start(Stage primaryStage, MainMenuController mainMenuData) {

        mainMenuController = mainMenuData;

        this.primaryStage = primaryStage;

        //This may not be required
        orderList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

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
    }

    @FXML
    public void removeSelected() {

    }

    @FXML
    public void placeOrder() {

    }

}
