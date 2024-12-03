package com.example.hboxvboxexamples;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class HBoxVBoxExamples extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("HBox and VBox example!");

        Label label1 = new Label("Label 1 ");
        Label label2 = new Label("Label 2 ");
        Label label3 = new Label("Label 3 ");
        Label label4 = new Label("Label 4 ");
        Label label5 = new Label("Label 5 ");
        Label label6 = new Label("Label 6 ");

        HBox hbox = new HBox();
        hbox.getChildren().addAll(label1, label2, label3);
        hbox.setSpacing(20);
        hbox.setAlignment(Pos.TOP_CENTER);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(label4, label5, label6);
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER_LEFT);

        BorderPane root = new BorderPane();

        root.setTop(hbox);
        root.setLeft(vbox);

        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setTitle("HBox and VBox Example");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}