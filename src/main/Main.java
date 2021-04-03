package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/main/MainMenu.fxml"));
        Pane root = loader.load();

        MainMenuController controller = loader.getController();
        controller.start(primaryStage);
        MainMenuController._instance = controller;

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("RU Cafe: Main Menu");
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
