package main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Main Menu Controller FX.
 *
 * @author Alexander Xie
 * @author Michael Nguyen
 */


public class MainMenuController
{
    //Order index types
    private static final int ORDER_DONUTS = 0;
    private static final int ORDER_COFFEE = 1;


    private Stage primaryStage;
    private StoreOrders storeOrders;
    private Order currentOrder;
    private MenuItem currentMenuItem;
    private float totalOrderCost;
    private float currentMenuItemCost;


    @FXML
    private ComboBox addToOrderComboBox;

    /**
     * Starts the stage and adds the combo box items.
     * @param primaryStage Primary Stage
     * @throws Exception If fails creating stage.
     */
    public void start(Stage primaryStage) throws Exception
    {
        storeOrders = new StoreOrders();
        currentOrder = new Order(storeOrders.getNumOrdersInHistory());

        addToOrderComboBox.getItems().addAll("Order Donuts", "Order Coffee");


        this.primaryStage = primaryStage;
    }

    /**
     * Closes the main menu. Effectively closes the program.
     */
    public void quitMainMenu()
    {
        primaryStage.close();
    }

    /**
     * Get the current order object.
     * @return Order object.
     */
    public Order getCurrentOrder()
    {
        return this.currentOrder;
    }

    /**
     * Creates a new order to fill.
     */
    public void newOrder()
    {
        currentOrder = new Order(storeOrders.getNumOrdersInHistory());
    }

    /**
     * Gets all the stores order inside a StoreOrders object.
     * @return StoresOrder object.
     */
    public StoreOrders getAllStoreOrders()
    {
        return this.storeOrders;
    }

    /**
     * Launches the ordering menu for the selected ordering page in combo box.
     */
    public void addToOrder()
    {

        try
        {

            if ( addToOrderComboBox.getSelectionModel().getSelectedIndex() == ORDER_DONUTS )
            {

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

            } else if ( addToOrderComboBox.getSelectionModel().getSelectedIndex() == ORDER_COFFEE )
            {

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
            } else
            {
                Popup.DisplayError("Select an option to add to the current order.");

            }

        } catch ( Exception e )
        {
            //ERROR
        }
    }

    /**
     * Starts the StoreOrderPageController and shows all the orders placed.
     */
    public void viewAllOrders()
    {
        try
        {
            Stage secondaryStage = new Stage();

            secondaryStage.initModality(Modality.APPLICATION_MODAL);

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/main/storeOrderPage.fxml"));
            Pane root = loader.load();

            StoreOrderPageController controller = loader.getController();
            controller.start(secondaryStage, this);

            Scene scene = new Scene(root);
            secondaryStage.setScene(scene);
            secondaryStage.setTitle("Store Orders Page");
            secondaryStage.setResizable(false);
            secondaryStage.show();
        } catch ( Exception e )
        {

        }
    }


    /**
     * Starts the current order detail page and shows all order details.
     */
    public void viewCurrentOrder()
    {
        try
        {

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

        } catch ( Exception e )
        {
            //ERROR
            e.printStackTrace();
        }
    }
}
