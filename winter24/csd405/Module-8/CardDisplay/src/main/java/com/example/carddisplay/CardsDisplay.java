package com.example.carddisplay;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.Random;

public class CardsDisplay extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create random number generator
        Random random = new Random();

        // Create container for images
        HBox root = new HBox(10);

        // Select 4 random unique card numbers
        for (int i = 0; i < 4; i++) {
            // Generate random number between 1 and 54
            int cardNumber = random.nextInt(54) + 1;

            // Load image for the random card number
            Image image = new Image(getClass().getResourceAsStream("cards/" + cardNumber + ".png"));
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(400);
            imageView.setFitHeight(400);
            imageView.setPreserveRatio(true);

            // Add to the display
            root.getChildren().add(imageView);
        }

        // Create and configure the scene
        Scene scene = new Scene(root, 1620, 400);

        // Configure and show the stage
        primaryStage.setTitle("Random Card Display");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}