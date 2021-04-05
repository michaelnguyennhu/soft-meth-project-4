package main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainMenuController {
    public static MainMenuController _instance;
    private Stage primaryStage;


    private StoreOrders storeOrders;
    private Order currentOrder;


    private static final int ORDER_DONUTS = 0;
    private static final int ORDER_COFFEE = 1;
    private static final int CURRENT_ORDER = 0;
    private static final int USER_ORDERS = 1;
    private MenuItem currentMenuItem;
    private float totalOrderCost;
    private float currentMenuItemCost;


    @FXML
    private ComboBox addToOrderComboBox;
    @FXML
    private ComboBox seeDetailsComboBox;

    public void start(Stage primaryStage) throws Exception{
        storeOrders = new StoreOrders();
        currentOrder = new Order(storeOrders.getNumOrdersInHistory());

        addToOrderComboBox.getItems().addAll("Order Donuts", "Order Coffee");
        seeDetailsComboBox.getItems().addAll("Current Order", "Orders Placed by User");


        this.primaryStage = primaryStage;
    }

    public void quitMainMenu(){
        primaryStage.close();
    }

    public Order getCurrentOrder(){
        return this.currentOrder;
    }

    public void addToOrder() throws Exception{

        if (addToOrderComboBox.getSelectionModel().getSelectedIndex() == ORDER_DONUTS){

            Stage secondaryStage = new Stage();

            secondaryStage.initModality(Modality.APPLICATION_MODAL);

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/main/orderDonuts.fxml"));
            Pane root = loader.load();

            OrderDonutsController controller = loader.getController();
            controller.start(secondaryStage, this);
            OrderDonutsController._instance = controller;

            Scene scene = new Scene(root);
            secondaryStage.setScene(scene);
            secondaryStage.setTitle("Ordering Donuts");
            secondaryStage.setResizable(false);
            secondaryStage.show();


            addToOrderComboBox.getSelectionModel().clearSelection();
            seeDetailsComboBox.getSelectionModel().clearSelection();

        }
        else if (addToOrderComboBox.getSelectionModel().getSelectedIndex() == ORDER_COFFEE){

            Stage secondaryStage = new Stage();

            secondaryStage.initModality(Modality.APPLICATION_MODAL);

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/main/orderCoffee.fxml"));
            Pane root = loader.load();

            OrderCoffeeController controller = loader.getController();
            controller.start(secondaryStage, this);
            OrderCoffeeController._instance = controller;

            Scene scene = new Scene(root);
            secondaryStage.setScene(scene);
            secondaryStage.setTitle("Ordering Coffee");
            secondaryStage.setResizable(false);
            secondaryStage.show();


            addToOrderComboBox.getSelectionModel().clearSelection();
            seeDetailsComboBox.getSelectionModel().clearSelection();
        }
        else {
            System.out.println("This will bring a popup saying to select an item to add");
        }

    }

    public void seeDetails(){

        if (seeDetailsComboBox.getSelectionModel().getSelectedIndex() == CURRENT_ORDER){
            System.out.println("See Current Order");


            addToOrderComboBox.getSelectionModel().clearSelection();
            seeDetailsComboBox.getSelectionModel().clearSelection();
        }
        else if (seeDetailsComboBox.getSelectionModel().getSelectedIndex() == USER_ORDERS) {
            System.out.println("See All User Orders");


            addToOrderComboBox.getSelectionModel().clearSelection();
            seeDetailsComboBox.getSelectionModel().clearSelection();
        }
        else {
            System.out.println("This will bring a popup saying to select an item to add");
        }


    }


}
