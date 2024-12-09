package com.example.carddisplay;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Cards extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Load the first image
        Image image1 = new Image(getClass().getResourceAsStream("cards/1.png"));
        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitWidth(400);
        imageView1.setFitHeight(400);
        imageView1.setPreserveRatio(true);

        // Load second image
        Image image2 = new Image(getClass().getResourceAsStream("cards/2.png"));
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitWidth(400);
        imageView2.setFitHeight(400);
        imageView2.setPreserveRatio(true);

        // Load third image
        Image image3 = new Image(getClass().getResourceAsStream("cards/3.png"));
        ImageView imageView3 = new ImageView(image3);
        imageView3.setFitWidth(400);
        imageView3.setFitHeight(400);
        imageView3.setPreserveRatio(true);

        // Load fourth image
        Image image4 = new Image(getClass().getResourceAsStream("cards/4.png"));
        ImageView imageView4 = new ImageView(image4);
        imageView4.setFitWidth(400);
        imageView4.setFitHeight(400);
        imageView4.setPreserveRatio(true);

        // Create a container for the images side by side
        HBox root = new HBox(10); // 10 is the spacing between images
        root.getChildren().addAll(imageView1, imageView2, imageView3, imageView4);

        // Create and configure the scene
        Scene scene = new Scene(root, 1600, 400); // Increased width to accommodate both images

        // Configure and show the stage
        primaryStage.setTitle("Card Display");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}