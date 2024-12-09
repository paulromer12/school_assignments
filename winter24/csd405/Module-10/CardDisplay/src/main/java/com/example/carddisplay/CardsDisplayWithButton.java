// Paul Romer, Module 10 Assignment, CSD405
package com.example.carddisplay;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import java.util.Random;
import javafx.scene.control.Button;

public class CardsDisplayWithButton extends Application {
    private Random random = new Random();
    private HBox cardBox;

    private void generateCards() {
        cardBox.getChildren().clear();

        for (int i = 0; i < 4; i++) {
            int cardNumber = random.nextInt(54) + 1;
            Image image = new Image(getClass().getResourceAsStream("cards/" + cardNumber + ".png"));
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(200);
            imageView.setFitHeight(200);
            imageView.setPreserveRatio(true);

            cardBox.getChildren().add(imageView);
        }
    }

    @Override
    public void start(Stage primaryStage) {
        cardBox = new HBox(10);
        cardBox.setAlignment(Pos.CENTER);

        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);

        // Initial card generation
        generateCards();

        // Initialize button object for shuffle
        Button shuffleButton = new Button("Shuffle");

        // Add lambda button click handler
        shuffleButton.setOnAction(e -> generateCards());

        root.getChildren().addAll(cardBox, shuffleButton);

        Scene scene = new Scene(root, 800, 500);
        primaryStage.setTitle("4 Random Cards");
        primaryStage.setMinWidth(650);
        primaryStage.setMinHeight(400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}