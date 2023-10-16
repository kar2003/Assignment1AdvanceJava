package com.example.assignment1java;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;

public class  MilkPriceApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MilkPriceview.fxml")));
        primaryStage.setTitle("Milk Prices Bar Chart");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}
