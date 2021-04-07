package main;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller for the GUI that allows the user to order coffee.
 *
 * @author Alexander Xie
 * @author Michael Nguyen
 */


public class OrderCoffeeController
{

    private Stage primaryStage;
    private Coffee coffee;
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

    /**
     * Sets up the sizeComboBox options and selects the first item.
     * Changes subtotalTextField to reflect the selected coffee size.
     * @param primaryStage PrimaryStage
     * @param mainMenuData MainMenuController
     */
    public void start(Stage primaryStage, MainMenuController mainMenuData)
    {

        mainMenuController = mainMenuData;


        sizeComboBox.getItems().addAll("Short", "Tall", "Grande", "Venti");

        sizeComboBox.getSelectionModel().selectFirst();
        coffee = new Coffee(sizeComboBox.getSelectionModel().getSelectedIndex());
        changeSubtotalTextField();

        this.primaryStage = primaryStage;
    }

    /**
     * Closes the stage that allows for ordering coffee.
     */
    public void backToMainMenu()
    {
        primaryStage.close();
    }

    /**
     * Adds the coffee to the order and resets the stage to default values.
     */
    public void addToOrder()
    {
        if ( sizeComboBox.getSelectionModel().isEmpty() )
        {
            Popup.DisplayError("Must select a size.");
            return;
        } else
        {
            coffee.changeSize(sizeComboBox.getSelectionModel().getSelectedIndex());
            mainMenuController.getCurrentOrder().add(coffee);


            coffee = new Coffee(sizeComboBox.getSelectionModel().getSelectedIndex());
            sizeComboBox.getSelectionModel().selectFirst();
            creamCheckBox.setSelected(false);
            syrupCheckBox.setSelected(false);
            milkCheckBox.setSelected(false);
            caramelCheckBox.setSelected(false);
            whippedCreamCheckBox.setSelected(false);
            changeSubtotalTextField();
            Popup.Display("Coffee", "A coffee has been added to the current order.");

        }
    }

    /**
     * Gets the subtotal obtained from the coffee values selected.
     * @return The subtotal of the coffee as a float.
     */
    public float getSubtotal()
    {
        if ( sizeComboBox.getSelectionModel().isEmpty() )
        {
            return -1f;
        } else
        {
            coffee.changeSize(sizeComboBox.getSelectionModel().getSelectedIndex());
            return coffee.getItemPrice();

        }
    }

    /**
     * Changes subtotalTextField's text to the subtotal calculated by getSubtotal
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
     * Changes subtotalTextField's text
     */
    public void sizeSelected()
    {
        changeSubtotalTextField();
    }
    /**
     * Changes subtotalTextField's text
     */
    public void creamChecked()
    {

        AddIns tempAddIns = new AddIns();
        tempAddIns.setCream(true);

        if ( creamCheckBox.isSelected() )
        {
            coffee.add(tempAddIns);
        } else
        {
            coffee.remove(tempAddIns);
        }

        if ( sizeComboBox.getSelectionModel().isEmpty() )
        {
            return;
        } else
        {
            changeSubtotalTextField();
        }

    }
    /**
     * Changes subtotalTextField's text
     */
    public void syrupChecked()
    {
        AddIns tempAddIns = new AddIns();
        tempAddIns.setSyrup(true);

        if ( syrupCheckBox.isSelected() )
        {
            coffee.add(tempAddIns);
        } else
        {
            coffee.remove(tempAddIns);
        }

        if ( sizeComboBox.getSelectionModel().isEmpty() )
        {
            return;
        } else
        {
            changeSubtotalTextField();
        }
    }
    /**
     * Changes subtotalTextField's text
     */
    public void milkChecked()
    {
        AddIns tempAddIns = new AddIns();
        tempAddIns.setMilk(true);

        if ( milkCheckBox.isSelected() )
        {
            coffee.add(tempAddIns);
        } else
        {
            coffee.remove(tempAddIns);
        }

        if ( sizeComboBox.getSelectionModel().isEmpty() )
        {
            return;
        } else
        {
            changeSubtotalTextField();
        }
    }
    /**
     * Changes subtotalTextField's text
     */
    public void caramelChecked()
    {
        AddIns tempAddIns = new AddIns();
        tempAddIns.setCaramel(true);

        if ( caramelCheckBox.isSelected() )
        {
            coffee.add(tempAddIns);
        } else
        {
            coffee.remove(tempAddIns);
        }

        if ( sizeComboBox.getSelectionModel().isEmpty() )
        {
            return;
        } else
        {
            changeSubtotalTextField();
        }
    }
    /**
     * Changes subtotalTextField's text
     */
    public void whippedCreamChecked()
    {
        AddIns tempAddIns = new AddIns();
        tempAddIns.setWhippedCream(true);

        if ( whippedCreamCheckBox.isSelected() )
        {
            coffee.add(tempAddIns);
        } else
        {
            coffee.remove(tempAddIns);
        }

        if ( sizeComboBox.getSelectionModel().isEmpty() )
        {
            return;
        } else
        {
            changeSubtotalTextField();
        }
    }


}
