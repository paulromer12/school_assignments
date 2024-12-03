package com.example.carddisplay;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class OneCard extends Application {

    @Override
    public void start(Stage primaryStage) {
            // Load the image
            Image image = new Image(getClass().getResourceAsStream("1.png"));
            ImageView imageView = new ImageView(image);

            // Create a container for the image
            StackPane root = new StackPane();
            root.getChildren().add(imageView);

            // Create and configure the scene
            Scene scene = new Scene(root, 400, 400);

            // Configure and show the stage
            primaryStage.setTitle("Card Display");
            primaryStage.setScene(scene);
            primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
