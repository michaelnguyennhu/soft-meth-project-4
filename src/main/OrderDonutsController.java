package main;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class OrderDonutsController {
    private Stage primaryStage;

    private MainMenuController mainMenuController;

    private static final int YEAST = 0;
    private static final float YEAST_PRICE = 1.39f;
    private static final int CAKE = 1;
    private static final float CAKE_PRICE = 1.59f;
    private static final int HOLE = 2;
    private static final float HOLE_PRICE = 0.33f;

    private static final int GLAZED = 0;
    private static final int CHOCOLATE = 1;
    private static final int VANILLA = 2;


    @FXML
    private TextField quantityTextField;
    @FXML
    private TextField subtotalTextField;
    @FXML
    private ComboBox donutTypeComboBox;
    @FXML
    private ComboBox flavorComboBox;


    public void start(Stage primaryStage, MainMenuController mainMenuData) throws Exception{

        mainMenuController = mainMenuData;

        donutTypeComboBox.getItems().addAll("Yeast Donut", "Cake Donut", "Donut Hole");
        flavorComboBox.getItems().addAll("Glazed", "Chocolate", "Vanilla");

        this.primaryStage = primaryStage;
    }

    public void backToMainMenu(){
        primaryStage.close();
    }

    public float getSubtotal(){
        if (donutTypeComboBox.getSelectionModel().isEmpty() || flavorComboBox.getSelectionModel().isEmpty()){
            return -1f;
        }
        else {
            Donut donut = new Donut(donutTypeComboBox.getSelectionModel().getSelectedIndex(), flavorComboBox.getSelectionModel().getSelectedIndex());
            Float quantity = Float.parseFloat(quantityTextField.getText());


            return (donut.getItemPrice() * quantity);
        }
    }


    public void changeSubtotalTextField(){
        Float subtotal = getSubtotal();
        if (subtotal != -1f){
            String newSubtotal = Utility.ToDollars(subtotal);
            subtotalTextField.setText(newSubtotal);
        }
    }

    public void donutTypeChosen(){
        changeSubtotalTextField();
    }

    public void flavorChosen(){
        changeSubtotalTextField();
    }


    public void addQuantity(){
        int quantity = Integer.parseInt(quantityTextField.getText());
        quantity++;
        quantityTextField.setText("" + quantity);

        changeSubtotalTextField();
    }
    public void minusQuantity(){
        int quantity = Integer.parseInt(quantityTextField.getText());
        if (quantity == 0){
            Popup.DisplayError("Quantity cannot be negative.");
            return;
        }
        quantity--;
        quantityTextField.setText("" + quantity);

        changeSubtotalTextField();
    }

    public void addToOrder(){

        if (donutTypeComboBox.getSelectionModel().isEmpty() || flavorComboBox.getSelectionModel().isEmpty()){
            Popup.DisplayError("Must select donut type AND donut flavor.");
            return;
        }
        else {
            int quantity = Integer.parseInt(quantityTextField.getText());
            if (quantity == 0){
                Popup.DisplayError("Quantity must be greater than 0.");
                return;
            }
            else {
                for (int i = 0; i < quantity; i++){
                    Donut donut = new Donut(donutTypeComboBox.getSelectionModel().getSelectedIndex(), flavorComboBox.getSelectionModel().getSelectedIndex());
                    mainMenuController.getCurrentOrder().add(donut);
                }
                if (quantity == 1){
                    Popup.Display("Donuts", "Donut has been added to the current order.");
                }
                else {
                    Popup.Display("Donuts", "Donuts have been added to the current order.");
                }


                donutTypeComboBox.getSelectionModel().clearSelection();
                flavorComboBox.getSelectionModel().clearSelection();
                quantityTextField.setText("0");
                subtotalTextField.setText("$0.00");
            }
        }


    }

}
