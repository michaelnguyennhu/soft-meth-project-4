package main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainMenuController {
    public static MainMenuController _instance;
    private Stage primaryStage;

    private StoreOrders storeOrders;

    private Order currentOrder;
    private MenuItem currentMenuItem;
    private float totalOrderCost;
    private float currentMenuItemCost;

    public void start(Stage primaryStage) throws Exception{
        storeOrders = new StoreOrders();

        this.primaryStage = primaryStage;
    }

    public void orderDonuts() throws Exception {
        Stage secondaryStage = new Stage();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/main/orderDonuts.fxml"));
        AnchorPane root = loader.load();

        OrderDonutsController controller = loader.getController();
        controller.start(secondaryStage);
        OrderDonutsController._instance = controller;

        Scene scene = new Scene(root);
        secondaryStage.setScene(scene);
        secondaryStage.setTitle("Ordering Donuts");
        secondaryStage.setResizable(false);
        secondaryStage.show();
    }
}
