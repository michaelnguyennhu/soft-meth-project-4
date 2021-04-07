package main;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;

public class StoreOrderPageController {

    private MainMenuController mainMenuController;
    private Stage primaryStage;


    @FXML
    public ListView orderList;

    public void start(Stage primaryStage, MainMenuController mainMenuData) {

        mainMenuController = mainMenuData;
        orderList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        setUpList();

        this.primaryStage = primaryStage;
    }

    public void setUpList(){
        for (int i = 0; i < mainMenuController.getAllStoreOrders().getNumOrders(); i++){
            System.out.println(i);
            orderList.getItems().add(mainMenuController.getAllStoreOrders().getOrdersList()[i].toString());
        }
    }

    public void backToMainMenu(){
        primaryStage.close();
    }

    public void update(){

    }

    public void cancelSelected(){

    }

    public void importStoreOrders(){

    }

    public void exportStoreOrders(){

    }
}
