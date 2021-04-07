package main;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller for the GUI that allows the user to order donuts.
 *
 * @author Alexander Xie
 * @author Michael Nguyen
 */


public class OrderDonutsController
{

    private Stage primaryStage;
    private MainMenuController mainMenuController;
    @FXML
    private TextField quantityTextField;
    @FXML
    private TextField subtotalTextField;
    @FXML
    private ComboBox donutTypeComboBox;
    @FXML
    private ComboBox flavorComboBox;

    /**
     * Sets up the options for the donutTypeComboBox and flavorComboBox.
     * @param primaryStage PrimaryStage
     * @param mainMenuData MainMenuController
     */
    public void start(Stage primaryStage, MainMenuController mainMenuData)
    {

        mainMenuController = mainMenuData;

        donutTypeComboBox.getItems().addAll("Yeast Donut", "Cake Donut", "Donut Hole");
        flavorComboBox.getItems().addAll("Glazed", "Chocolate", "Vanilla");

        this.primaryStage = primaryStage;
    }

    /**
     * Closes the stage that allows for ordering donuts.
     */
    public void backToMainMenu()
    {
        primaryStage.close();
    }

    /**
     * Gets the subtotal for the donuts ordered.
     * @return The subtotal for the donuts that were ordered.
     *         Returns -1f if the subtotal could not be calculated.
     */
    public float getSubtotal()
    {
        if ( donutTypeComboBox.getSelectionModel().isEmpty() || flavorComboBox.getSelectionModel().isEmpty() )
        {
            return -1f;
        } else
        {
            Donut donut = new Donut(donutTypeComboBox.getSelectionModel().getSelectedIndex(), flavorComboBox.getSelectionModel().getSelectedIndex());
            Float quantity = Float.parseFloat(quantityTextField.getText());


            return (donut.getItemPrice() * quantity);
        }
    }

    /**
     * Changes subtotalTextField's text to a newly calculated value.
     */
    public void changeSubtotalTextField()
    {
        Float subtotal = getSubtotal();
        if ( subtotal != -1f )
        {
            String newSubtotal = Utility.ToDollars(subtotal);
            subtotalTextField.setText(newSubtotal);
        }
    }

    /**
     * Changes subtotalTextField if donut type has been selected.
     */
    public void donutTypeChosen()
    {
        changeSubtotalTextField();
    }

    /**
     * Changes subtotalTextField if donut flavor has been selected.
     */
    public void flavorChosen()
    {
        changeSubtotalTextField();
    }

    /**
     * Increments the integer in quantityTextField by one.
     */
    public void addQuantity()
    {
        int quantity = Integer.parseInt(quantityTextField.getText());
        quantity++;
        quantityTextField.setText("" + quantity);

        changeSubtotalTextField();
    }

    /**
     * Decrements the integer in quantityTextField by one.
     */
    public void minusQuantity()
    {
        int quantity = Integer.parseInt(quantityTextField.getText());
        if ( quantity == 0 )
        {
            Popup.DisplayError("Quantity cannot be negative.");
            return;
        }
        quantity--;
        quantityTextField.setText("" + quantity);

        changeSubtotalTextField();
    }

    /**
     * Adds the current order to the list of all store orders and resets the stage to the default state.
     */
    public void addToOrder()
    {

        if ( donutTypeComboBox.getSelectionModel().isEmpty() || flavorComboBox.getSelectionModel().isEmpty() )
        {
            Popup.DisplayError("Must select donut type AND donut flavor.");
            return;
        } else
        {
            int quantity = Integer.parseInt(quantityTextField.getText());
            if ( quantity == 0 )
            {
                Popup.DisplayError("Quantity must be greater than 0.");
                return;
            } else
            {
                for ( int i = 0; i < quantity; i++ )
                {
                    Donut donut = new Donut(donutTypeComboBox.getSelectionModel().getSelectedIndex(), flavorComboBox.getSelectionModel().getSelectedIndex());
                    mainMenuController.getCurrentOrder().add(donut);
                }
                if ( quantity == 1 )
                {
                    Popup.Display("Donuts", "Donut has been added to the current order.");
                } else
                {
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
