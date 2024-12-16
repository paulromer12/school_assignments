package com.example.displayshapes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DisplayShapes extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DisplayShapes.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 860, 780);
        stage.setTitle("Paul Romer Module 11");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}