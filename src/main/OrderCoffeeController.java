package main;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class OrderCoffeeController {
    public static OrderCoffeeController _instance;
    private Stage primaryStage;


    private Coffee coffee;


    private static final int SHORT = 0;
    private static final int TALL = 1;
    private static final int GRANDE = 2;
    private static final int VENTI = 3;

    @FXML
    private ComboBox sizeComboBox;

    @FXML
    private CheckBox creamCheckBox;
    @FXML
    private CheckBox syrupCheckBox;
    @FXML
    private CheckBox milkCheckBox;
    @FXML
    private CheckBox caramelCheckBox;
    @FXML
    private CheckBox whippedCreamCheckBox;

    @FXML
    private TextField subtotalTextField;

    private MainMenuController mainMenuController;

    public void start(Stage primaryStage, MainMenuController mainMenuData) {

        mainMenuController = mainMenuData;


        sizeComboBox.getItems().addAll("Short", "Tall", "Grande", "Venti");

        sizeComboBox.getSelectionModel().selectFirst();
        coffee = new Coffee(sizeComboBox.getSelectionModel().getSelectedIndex());
        changeSubtotalTextField();

        this.primaryStage = primaryStage;
    }

    public void backToMainMenu(){
        primaryStage.close();
    }

    public void addToOrder(){
        if (sizeComboBox.getSelectionModel().isEmpty()){
            System.out.println("must select a size");
            return;
        }
        else {
            coffee.changeSize(sizeComboBox.getSelectionModel().getSelectedIndex());

            mainMenuController.getCurrentOrder().add(coffee);


            sizeComboBox.getSelectionModel().selectFirst();
            coffee = new Coffee(sizeComboBox.getSelectionModel().getSelectedIndex());
            creamCheckBox.setSelected(false);
            syrupCheckBox.setSelected(false);
            milkCheckBox.setSelected(false);
            caramelCheckBox.setSelected(false);
            whippedCreamCheckBox.setSelected(false);
            changeSubtotalTextField();

        }
    }


    public float getSubtotal(){
        if (sizeComboBox.getSelectionModel().isEmpty()){
            return -1f;
        }
        else {
            coffee.changeSize(sizeComboBox.getSelectionModel().getSelectedIndex());
            return coffee.getItemPrice();

        }
    }

    protected String toDollars(float amount)
    {
        float flooredAmount = ( float ) (Math.floor(Math.round(amount * 100)) / 100);

        DecimalFormat formatter = new DecimalFormat("'$'###,###,###,###,##0.00");
        formatter.setGroupingSize(3);


        return formatter.format(flooredAmount);
    }

    public void changeSubtotalTextField(){
        Float subtotal = getSubtotal();
        if (subtotal != -1f){
            String newSubtotal = toDollars(subtotal);
            subtotalTextField.setText(newSubtotal);
        }
    }

    public void sizeSelected(){
        changeSubtotalTextField();
    }

    public void creamChecked(){

        AddIns tempAddIns = new AddIns();
        tempAddIns.setCream(true);

        if (creamCheckBox.isSelected()){
            coffee.add(tempAddIns);
        }
        else {
            coffee.remove(tempAddIns);
        }

        if (sizeComboBox.getSelectionModel().isEmpty()){
            return;
        }
        else {
            changeSubtotalTextField();
        }

    }
    public void syrupChecked(){
        AddIns tempAddIns = new AddIns();
        tempAddIns.setSyrup(true);

        if (syrupCheckBox.isSelected()){
            coffee.add(tempAddIns);
        }
        else {
            coffee.remove(tempAddIns);
        }

        if (sizeComboBox.getSelectionModel().isEmpty()){
            return;
        }
        else {
            changeSubtotalTextField();
        }
    }
    public void milkChecked(){
        AddIns tempAddIns = new AddIns();
        tempAddIns.setMilk(true);

        if (milkCheckBox.isSelected()){
            coffee.add(tempAddIns);
        }
        else {
            coffee.remove(tempAddIns);
        }

        if (sizeComboBox.getSelectionModel().isEmpty()){
            return;
        }
        else {
            changeSubtotalTextField();
        }
    }
    public void caramelChecked(){
        AddIns tempAddIns = new AddIns();
        tempAddIns.setCaramel(true);

        if (caramelCheckBox.isSelected()){
            coffee.add(tempAddIns);
        }
        else {
            coffee.remove(tempAddIns);
        }

        if (sizeComboBox.getSelectionModel().isEmpty()){
            return;
        }
        else {
            changeSubtotalTextField();
        }
    }
    public void whippedCreamChecked(){
        AddIns tempAddIns = new AddIns();
        tempAddIns.setWhippedCream(true);

        if (whippedCreamCheckBox.isSelected()){
            coffee.add(tempAddIns);
        }
        else {
            coffee.remove(tempAddIns);
        }

        if (sizeComboBox.getSelectionModel().isEmpty()){
            return;
        }
        else {
            changeSubtotalTextField();
        }
    }




}