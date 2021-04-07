package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Controller for the Store Order Page GUI.
 *
 * @author Alexander Xie
 * @author Michael Nguyen
 */


public class StoreOrderPageController
{
    //Tax values
    private final static float TAX = 0.06625f;
    //Get price after taxes by multiplying this value.
    private final static float TAX_MULTIPLIER = 1.06625f;


    @FXML
    public ListView orderList;
    private MainMenuController mainMenuController;
    private Stage primaryStage;
    @FXML
    private Text subtotalText;
    @FXML
    private Text taxText;
    @FXML
    private Text totalText;
    @FXML
    private Button cancelSelectedButton;

    /**
     * Sets up the stage for the Store Order Page GUI.
     * Sets up orderList to include the orders in storeOrders.
     * @param primaryStage PrimaryStage
     * @param mainMenuData MainMenuController
     */
    public void start(Stage primaryStage, MainMenuController mainMenuData)
    {

        mainMenuController = mainMenuData;
        orderList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        setUpList();

        this.primaryStage = primaryStage;
    }

    /**
     * Sets up orderList to include all user orders .
     */
    public void setUpList()
    {
        for ( int i = 0; i < mainMenuController.getAllStoreOrders().getNumOrders(); i++ )
        {
            Order order = mainMenuController.getAllStoreOrders().getOrdersList()[i];
            orderList.getItems().add("Order number - " + order.getOrderNumber() + " " + combinedMenuItemGroupStrings(generateMenuItemGroups(order.toArrayList())) + " - Total Price: " + Utility.ToDollars(order.getPriceTotal() * (TAX_MULTIPLIER)));
        }
    }

    /**
     * Converts an ArrayList of MenuItemGroups into a single string.
     * @param groups ArrayList of MenuItemGroups
     * @return String of all menu items.
     */
    public String combinedMenuItemGroupStrings(ArrayList< MenuItemGroup > groups)
    {
        String concatDescriptions = "";

        for ( int i = 0; i < groups.size(); i++ )
        {
            concatDescriptions += groups.get(i).toString() + "; ";
        }

        concatDescriptions = concatDescriptions.substring(0, concatDescriptions.length() - 2);

        return concatDescriptions;
    }

    /**
     * Generates a array list of menu items grouped by similarity.
     * @param menuItems List of menu items to group.
     * @return ArrayList of MenuItemGroup.
     */
    public ArrayList< MenuItemGroup > generateMenuItemGroups(ArrayList< MenuItem > menuItems)
    {
        ArrayList< MenuItemGroup > group = new ArrayList<>();

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
     * Closes current UI to go back to main menu.
     */
    public void backToMainMenu()
    {
        primaryStage.close();
    }

    public void update()
    {
        int selectedOrder = orderList.getSelectionModel().getSelectedIndex();
        cancelSelectedButton.setDisable(selectedOrder == -1);

        float subtotal = mainMenuController.getAllStoreOrders().getOrdersList()[selectedOrder].getPriceTotal();
        float tax = subtotal * TAX;
        float total = subtotal + tax;

        subtotalText.setText("Subtotal - " + Utility.ToDollars(subtotal));
        taxText.setText("Tax - " + Utility.ToDollars(tax));
        totalText.setText("Total - " + Utility.ToDollars(total));
    }

    /**
     * Cancel the selected order and removes it from all lists.
     */
    public void cancelSelected()
    {
        Order order = mainMenuController.getAllStoreOrders().getOrdersList()[orderList.getSelectionModel().getSelectedIndex()];
        mainMenuController.getAllStoreOrders().remove(order);

        orderList.getItems().remove(orderList.getSelectionModel().getSelectedIndex());

        orderList.refresh();

        update();
        Popup.Display("Successful Remove", "Removed " + order.getOrderNumber() + " from order list!");
    }

    /**
     * Exports all the orders into a text file formatted with all order details and item details.
     * @param action Action to display file chooser
     */
    public void exportStoreOrders(ActionEvent action)
    {
        try
        {
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Select database export file");

            Stage stage = ( Stage ) (( Node ) action.getSource()).getScene().getWindow();

            File file = chooser.showSaveDialog(stage);

            if ( file == null )
            {
                Popup.Display("Invalid File", "Invalid File Selected. Not exporting.");
                return;
            } else
            {

                if ( !file.exists() )
                {
                    try
                    {
                        file.createNewFile();
                    } catch ( Exception e )
                    {
                        Popup.DisplayError("Failed to create new file, file in use?");
                    }
                }

                try
                {
                    FileWriter fileWriter = new FileWriter(file, false);

                    String output = "";
                    Order[] orders = mainMenuController.getAllStoreOrders().getOrdersList();
                    for ( int i = 0; i < mainMenuController.getAllStoreOrders().getNumOrders(); i++ )
                    {
                        output += "Order number - " + orders[i].getOrderNumber();
                        output += " | Sub Total - " + Utility.ToDollars(orders[i].getPriceTotal());
                        output += " | Tax - " + Utility.ToDollars(orders[i].getPriceTotal() * TAX);
                        output += " | Total Price - " + Utility.ToDollars(orders[i].getPriceTotal() * TAX_MULTIPLIER);

                        ArrayList< MenuItemGroup > itemGroups = generateMenuItemGroups(orders[i].toArrayList());

                        for ( int j = 0; j < itemGroups.size(); j++ )
                        {
                            output += "\n\t" + itemGroups.get(j).toString();
                        }
                        output += "\n\n";
                    }

                    fileWriter.write(output);

                    fileWriter.flush();
                    fileWriter.close();
                } catch ( Exception e )
                {
                    Popup.DisplayError("Failed to write to file\n" + e.getMessage());
                    return;
                }


                Popup.Display("Successful Export!", "Exported all orders to file!");

            }


        } catch ( Exception e )
        {
            Popup.DisplayError(e.getMessage());
        }
    }
}
