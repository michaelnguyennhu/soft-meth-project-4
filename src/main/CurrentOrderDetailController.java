package main;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.*;

public class CurrentOrderDetailController
{
    private final float TAX = 0.06625f;

    @FXML
    public ListView orderList;
    @FXML
    public Button removeSelectedButton;
    @FXML
    public Button placeOrderButton;

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

        ObservableList<MenuItemGroup> menuItems = FXCollections.observableList(generateMenuItemGroups());

        orderList.setCellFactory(listView -> new OrderDetailListCell());
        orderList.setItems(menuItems);

        update();
    }


    public void backToMainMenu(){
        primaryStage.close();
    }

    @FXML
    public void update() {


        ObservableList selectedOrders = orderList.getSelectionModel().getSelectedIndices();
        removeSelectedButton.setDisable(!(selectedOrders.size() > 0));

        placeOrderButton.setDisable(orderList.getItems().size() == 0);

        float subtotal = mainMenuController.getCurrentOrder().getPriceTotal();
        float tax = subtotal * TAX;
        float total = subtotal + tax;


        subtotalText.setText("Subtotal - " + Utility.ToDollars(subtotal));
        taxText.setText("Tax - " +  Utility.ToDollars(tax));
        totalText.setText("Total - " + Utility.ToDollars(total));
    }

    public ArrayList<MenuItemGroup> generateMenuItemGroups(){
        ArrayList<MenuItemGroup> group = new ArrayList<>();
        ArrayList<MenuItem> menuItems = mainMenuController.getCurrentOrder().toArrayList();

        while(menuItems.size() > 0){
            int amount = 1;

            for(int i = menuItems.size() - 1; i > 0; i--){
                if(menuItems.get(i).equals(menuItems.get(0))){
                    amount++;
                    menuItems.remove(i);
                }
            }


            group.add(new MenuItemGroup(menuItems.get(0).toString(), menuItems.get(0).getDetails(), amount, amount * menuItems.get(0).getItemPrice()));
            menuItems.remove(0);
        }

        return group;
    }

    @FXML
    public void removeSelected() {
        String itemRemovedName = orderList.getSelectionModel().getSelectedItem().toString();


        mainMenuController.getCurrentOrder().remove(orderList.getSelectionModel().getSelectedItem());
        orderList.getItems().remove(orderList.getSelectionModel().getSelectedIndex());

        orderList.refresh();

        update();
        Popup.Display("Successful Remove", "Removed " + itemRemovedName + " from order!");


    }

    @FXML
    public void placeOrder() {

        mainMenuController.getAllStoreOrders().add(mainMenuController.getCurrentOrder());
        System.out.println(mainMenuController.getCurrentOrder().toString());
        mainMenuController.newOrder();

        ObservableList<MenuItem> menuItems = FXCollections.observableList(mainMenuController.getCurrentOrder().toArrayList());

        orderList.setCellFactory(listView -> new OrderDetailListCell());
        orderList.setItems(menuItems);

        update();

    }

}
