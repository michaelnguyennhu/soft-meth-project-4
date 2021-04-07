package main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;

public class OrderDetailListCell extends ListCell<MenuItemGroup>
{
    @FXML
    private Text itemNameText;

    @FXML
    private Pane pane;

    @FXML
    private Text priceText;

    @FXML
    private Text addinText;

    @FXML
    private VBox addinVBox;

    private FXMLLoader fxmlLoader;


    @Override
    protected void updateItem(MenuItemGroup menuItem, boolean b)
    {

        super.updateItem(menuItem, b);
        if(this.isEmpty() || menuItem == null){
            this.setText(null);
            this.setGraphic(null);
        }else{
            if(fxmlLoader == null){
                fxmlLoader = new FXMLLoader(this.getClass().getResource("/main/orderDetail.fxml"));
                fxmlLoader.setController(this);

                try{
                    fxmlLoader.load();
                } catch( IOException e){
                    Popup.DisplayError(e.getMessage());
                }

            }
            itemNameText.setText(menuItem.getItemName() + " x" + menuItem.getQuantity());
            priceText.setText("Price - " + Utility.ToDollars(menuItem.getTotalPrice()));

            addinVBox.getChildren().clear();

            String[] details = menuItem.getDetails();
            addinVBox.getChildren().removeAll();
            for(int i = 0; i < details.length; i++){
                Text duplicateText = new Text("- " + details[i]);
                duplicateText.setFont(addinText.getFont());
                duplicateText.setStroke(addinText.getStroke());
                duplicateText.setTextAlignment(addinText.getTextAlignment());
                addinVBox.getChildren().add(duplicateText);
            }
            addinVBox.getChildren().remove(addinText);

            this.setText(null);
            this.setGraphic(pane);
        }

    }
}
