package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Main entry point for the javaFX program.
 *
 * @author Alexander Xie
 * @author Michael Nguyen
 */


public class Main extends Application
{

    /**
     * Main method. Launches the fx.
     * @param args
     */
    public static void main(String[] args)
    {
        launch(args);
    }

    /**
     * Initializes and shows main menu.
     * @param primaryStage Primary fx stage
     * @throws Exception If an error occurs starting the FX.
     */
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/main/mainMenu.fxml"));
        Pane root = loader.load();

        MainMenuController controller = loader.getController();
        controller.start(primaryStage);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("RU Cafe: Main Menu");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
