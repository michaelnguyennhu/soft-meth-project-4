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
    private Stage primaryStage;


    private StoreOrders storeOrders;
    private Order currentOrder;


    private static final int ORDER_DONUTS = 0;
    private static final int ORDER_COFFEE = 1;
    private MenuItem currentMenuItem;
    private float totalOrderCost;
    private float currentMenuItemCost;


    @FXML
    private ComboBox addToOrderComboBox;

    public void start(Stage primaryStage) throws Exception{
        storeOrders = new StoreOrders();
        currentOrder = new Order(storeOrders.getNumOrdersInHistory());

        addToOrderComboBox.getItems().addAll("Order Donuts", "Order Coffee");


        this.primaryStage = primaryStage;
    }

    public void quitMainMenu(){
        primaryStage.close();
    }

    public Order getCurrentOrder(){
        return this.currentOrder;
    }

    public void addToOrder() {

        try{

        if (addToOrderComboBox.getSelectionModel().getSelectedIndex() == ORDER_DONUTS){

            Stage secondaryStage = new Stage();

            secondaryStage.initModality(Modality.APPLICATION_MODAL);

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/main/orderDonuts.fxml"));
            Pane root = loader.load();

            OrderDonutsController controller = loader.getController();
            controller.start(secondaryStage, this);

            Scene scene = new Scene(root);
            secondaryStage.setScene(scene);
            secondaryStage.setTitle("Ordering Donuts");
            secondaryStage.setResizable(false);
            secondaryStage.show();


            //addToOrderComboBox.getSelectionModel().clearSelection();

        }
        else if (addToOrderComboBox.getSelectionModel().getSelectedIndex() == ORDER_COFFEE){

            Stage secondaryStage = new Stage();

            secondaryStage.initModality(Modality.APPLICATION_MODAL);

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/main/orderCoffee.fxml"));
            Pane root = loader.load();

            OrderCoffeeController controller = loader.getController();
            controller.start(secondaryStage, this);

            Scene scene = new Scene(root);
            secondaryStage.setScene(scene);
            secondaryStage.setTitle("Ordering Coffee");
            secondaryStage.setResizable(false);
            secondaryStage.show();


            //addToOrderComboBox.getSelectionModel().clearSelection();
        }
        else {
            Popup.DisplayError("Select an option to add to the current order.");

        }

        }catch(Exception e){
            //ERROR
        }
    }


    public void viewAllOrders(){

    }

    public void viewCurrentOrder(){
        try{

            Stage secondaryStage = new Stage();

            secondaryStage.initModality(Modality.APPLICATION_MODAL);

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/main/currentOrderDetail.fxml"));
            Pane root = loader.load();

            CurrentOrderDetailController controller = loader.getController();
            controller.start(secondaryStage, this);

            Scene scene = new Scene(root);
            secondaryStage.setScene(scene);
            secondaryStage.setTitle("Current Order Details");
            secondaryStage.setResizable(false);
            secondaryStage.show();

        }catch(Exception e){
            //ERROR
            e.printStackTrace();
        }
    }
}
