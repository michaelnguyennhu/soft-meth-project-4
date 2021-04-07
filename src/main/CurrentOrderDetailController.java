package main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Displays a FX stage for the current order details.
 *
 * @author Alexander Xie
 * @author Michael Nguyen
 */

public class CurrentOrderDetailController
{
    //Tax amount on sales
    private final static float TAX = 0.06625f;

    @FXML
    private ListView orderList;
    @FXML
    private Button removeSelectedButton;
    @FXML
    private Button placeOrderButton;

    @FXML
    private Text subtotalText;
    @FXML
    private Text taxText;
    @FXML
    private Text totalText;


    private Stage primaryStage;

    private MainMenuController mainMenuController;

    /**
     * Initializes the current order detail stage. Adds all order items and the layout for each item.
     * @param primaryStage Primary stage
     * @param mainMenuData Controller for main menu
     */
    public void start(Stage primaryStage, MainMenuController mainMenuData)
    {

        mainMenuController = mainMenuData;

        this.primaryStage = primaryStage;

        ObservableList< MenuItemGroup > menuItems = FXCollections.observableList(generateMenuItemGroups());

        orderList.setCellFactory(listView -> new OrderDetailListCell());
        orderList.setItems(menuItems);

        update();
    }


    /**
     * Closes the current stage.
     */
    public void backToMainMenu()
    {
        primaryStage.close();
    }

    /**
     * Disables/Enables buttons and updates the prices.
     */
    @FXML
    public void update()
    {


        ObservableList selectedOrders = orderList.getSelectionModel().getSelectedIndices();
        removeSelectedButton.setDisable(!(selectedOrders.size() > 0));

        placeOrderButton.setDisable(orderList.getItems().size() == 0);

        float subtotal = mainMenuController.getCurrentOrder().getPriceTotal();
        float tax = subtotal * TAX;
        float total = subtotal + tax;


        subtotalText.setText("Subtotal - " + Utility.ToDollars(subtotal));
        taxText.setText("Tax - " + Utility.ToDollars(tax));
        totalText.setText("Total - " + Utility.ToDollars(total));
    }

    /**
     * Generates a array list of menu items grouped by similarity.
     * @return ArrayList of MenuItemGroup.
     */
    public ArrayList< MenuItemGroup > generateMenuItemGroups()
    {
        ArrayList< MenuItemGroup > group = new ArrayList<>();
        ArrayList< MenuItem > menuItems = mainMenuController.getCurrentOrder().toArrayList();

        while ( menuItems.size() > 0 )
        {
            int amount = 1;

            for ( int i = menuItems.size() - 1; i > 0; i-- )
            {
                if ( menuItems.get(i).equals(menuItems.get(0)) )
                {
                    amount++;
                    menuItems.remove(i);
                }
            }


            group.add(new MenuItemGroup(menuItems.get(0).toString(), menuItems.get(0).getDetails(), amount, amount * menuItems.get(0).getItemPrice(), menuItems.get(0)));
            menuItems.remove(0);
        }

        return group;
    }

    /**
     * Removes the selected item from the order.
     */
    @FXML
    public void removeSelected()
    {
        MenuItemGroup itemGroup = ( MenuItemGroup ) orderList.getSelectionModel().getSelectedItem();


        mainMenuController.getCurrentOrder().remove(orderList.getSelectionModel().getSelectedItem());
        orderList.getItems().remove(orderList.getSelectionModel().getSelectedIndex());

        for(int i = 0 ; i < itemGroup.getQuantity(); i++){
            mainMenuController.getCurrentOrder().remove(itemGroup.getItem());
        }

        orderList.refresh();

        update();
        Popup.Display("Successful Remove", "Removed " + itemGroup.toString() + " from order!");


    }

    /**
     * Places the current order, stores it, and creates a new order.
     */
    @FXML
    public void placeOrder()
    {

        mainMenuController.getAllStoreOrders().add(mainMenuController.getCurrentOrder());
        Popup.Display("Order Placed", "The current order has been placed");
        mainMenuController.newOrder();

        ObservableList< MenuItem > menuItems = FXCollections.observableList(mainMenuController.getCurrentOrder().toArrayList());

        orderList.setCellFactory(listView -> new OrderDetailListCell());
        orderList.setItems(menuItems);

        update();

    }

}
