package main;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Creates popups for errors and confirmation messages.
 *
 * @author Alexander Xie
 * @author Michael Nguyen
 */



public class Popup
{
    /**
     * Displays a given message.
     * @param title The title of the stage created.
     * @param message The message that will be presented.
     */
    public static void Display(String title, String message)
    {
        Stage popupStage = new Stage();

        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle(title);
        popupStage.setMinWidth(300);
        popupStage.setMinHeight(125);
        popupStage.setResizable(false);

        Label buttonText = new Label();
        buttonText.setText(message);
        Button closeButton = new Button("OK");
        closeButton.setOnAction(e -> popupStage.close());

        VBox verticalLayout = new VBox(12);
        verticalLayout.getChildren().addAll(buttonText, closeButton);
        verticalLayout.setAlignment(Pos.CENTER);


        Scene scene = new Scene(verticalLayout);
        popupStage.setScene(scene);
        popupStage.showAndWait();

    }

    /**
     * Displays an error message.
     * @param message Error message that will be presented.
     */
    public static void DisplayError(String message)
    {
        Display("Error", message);
    }
}
