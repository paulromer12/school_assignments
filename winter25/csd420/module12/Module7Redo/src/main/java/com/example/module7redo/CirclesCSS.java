// Paul Romer, Module 7 assignment redo/module 12 assignment, March 5 2025
package com.example.module7redo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class CirclesCSS extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create and style circle 1 - plain blue circle
        Circle circle1 = new Circle(40);
        circle1.getStyleClass().add("plaincircle");
        
        // Create and style circle 2 - plain blue circle with black border
        Circle circle2 = new Circle(40);
        circle2.getStyleClass().add("plaincircle");  
        circle2.getStyleClass().add("circleborder"); 
        
        // Create and style circle 3 - red circle
        Circle circle3 = new Circle(40);
        circle3.setId("redcircle");
        
        // Create and style circle 4 - green circle with black border
        Circle circle4 = new Circle(40);
        circle4.setId("greencircle");
        circle4.getStyleClass().add("circleborder");
        
        // Create panes for each circle
        Pane pane1 = createPaneForCircle(circle1);
        Pane pane2 = createPaneForCircle(circle2);
        Pane pane3 = createPaneForCircle(circle3);
        Pane pane4 = createPaneForCircle(circle4);
        
        // Put first circle in a bordered container
        HBox borderedBox = new HBox();
        borderedBox.getStyleClass().add("border");
        borderedBox.getChildren().add(pane1);
        borderedBox.setAlignment(Pos.CENTER);
        borderedBox.setPrefHeight(200);
        
        // Create the main horizontal container for all circles
        HBox root = new HBox(10);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);
        
        // Add all elements to the main container
        root.getChildren().addAll(borderedBox, pane2, pane3, pane4);
        
        // Set up the scene with CSS styling
        Scene scene = new Scene(root, 450, 300);
        String cssPath = getClass().getResource("/com/example/module7redo/mystyle.css").toExternalForm();
        scene.getStylesheets().add(cssPath);
        
        // Display the window
        primaryStage.setTitle("Styled Circles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    // Helper method to create a pane containing a circle centered inside it
    private Pane createPaneForCircle(Circle circle) {
        Pane pane = new Pane();
        pane.getChildren().add(circle);
        
        // Center the circle in the pane
        circle.centerXProperty().bind(pane.widthProperty().divide(2));
        circle.centerYProperty().bind(pane.heightProperty().divide(2));

        return pane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}