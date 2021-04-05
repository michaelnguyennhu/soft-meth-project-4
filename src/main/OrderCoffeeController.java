package main;

import javafx.stage.Stage;

public class OrderCoffeeController {
    public static OrderCoffeeController _instance;
    private Stage primaryStage;

    private MainMenuController mainMenuController;

    public void start(Stage primaryStage, MainMenuController mainMenuData) {

        mainMenuController = mainMenuData;

        this.primaryStage = primaryStage;
    }

    public void backToMainMenu(){
        primaryStage.close();
    }
}
