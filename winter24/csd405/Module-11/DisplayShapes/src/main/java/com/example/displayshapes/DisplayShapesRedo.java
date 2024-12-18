// Paul Romer, Module 12 Assignment

package com.example.displayshapes;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class DisplayShapesRedo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        BorderPane borderPane = new BorderPane();

        ShapePane shapePane = new ShapePane();
        borderPane.setCenter(shapePane);

        Label titleLabel = new Label("Shape With Random Color");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // center the label at the top
        BorderPane.setAlignment(titleLabel, Pos.CENTER);

        // add margin around the title
        BorderPane.setMargin(titleLabel, new Insets(20, 0, 20, 0));

        borderPane.setTop(titleLabel);

        // create checkbox to select fill random color
        CheckBox randomColor = new CheckBox("Random Color");
        shapePane.setRandomColor(randomColor);

        // refresh when checkbox is checked
        randomColor.setOnAction(e -> shapePane.drawShape());

        // VBox for radio buttons
        VBox Buttons = new VBox();
        Buttons.setSpacing(25);
        Buttons.setPadding(new Insets(25));
        Buttons.setAlignment(Pos.CENTER_LEFT);
        borderPane.setLeft(Buttons);

        // create radio buttons
        RadioButton radioButtonCircle = new RadioButton("Circle");
        RadioButton radioButtonRectangle = new RadioButton("Rectangle");
        RadioButton radioButtonEllipse = new RadioButton("Ellipse");
        RadioButton radioButtonSquare = new RadioButton("Square");


        // set toggle group
        ToggleGroup shapeToggle = new ToggleGroup();
        radioButtonCircle.setToggleGroup(shapeToggle);
        radioButtonRectangle.setToggleGroup(shapeToggle);
        radioButtonEllipse.setToggleGroup(shapeToggle);
        radioButtonSquare.setToggleGroup(shapeToggle);

        // set radio button actions
        radioButtonCircle.setOnAction(e -> shapePane.drawShape(ShapePane.CIRCLE));
        radioButtonRectangle.setOnAction(e -> shapePane.drawShape(ShapePane.RECTANGLE));
        radioButtonEllipse.setOnAction(e -> shapePane.drawShape(ShapePane.ELLIPSE));
        radioButtonSquare.setOnAction(e -> shapePane.drawShape(ShapePane.SQUARE));

        // place buttons in vbox
        Buttons.getChildren().addAll(radioButtonCircle, radioButtonRectangle, radioButtonEllipse, radioButtonSquare, randomColor);

        // select circle by default and draw it
        radioButtonCircle.setSelected(true);
        shapePane.drawShape(ShapePane.CIRCLE);

        // set the scene, stage, and show it
        Scene scene = new Scene(borderPane, 840, 560);
        primaryStage.setTitle("Paul Romer Module 11");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static class ShapePane extends StackPane {

        // final static variables to determine what shape to display
        public static final int CIRCLE = 0;
        public static final int RECTANGLE = 1;
        public static final int ELLIPSE = 2;
        public static final int SQUARE = 3;

        // stores reference to the checkbox of outer class
        private CheckBox randomColor;

        // Store the current shape as an int
        private int currentShape = 0;

        private void setRandomColor(CheckBox checkBox) {
            // setter - shares checkbox reference from inner class
            randomColor = checkBox;
        }

        private void setCurrentShape(int shape) {
            // Setter to store the currently selected shape
            currentShape = shape;
        }

        private Color getColor() {
            if (randomColor.isSelected()) {
                return Color.rgb(
                        (int) (Math.random() * 256),
                        (int) (Math.random() * 256),
                        (int) (Math.random() * 256)
                );
            } else {
                return Color.ROYALBLUE;
            }
        }

        public void drawShape() {
            drawShape(currentShape);
        }

        public void drawShape(int shape) {
            // Set the shape pane with the selected shape

            // clear the existing shapes from pane
            getChildren().clear();

            // set the object shape string to the current shape to recall later
            setCurrentShape(shape);

            // add the currently selected shape to the pane
            switch (shape) {
                case ShapePane.CIRCLE:
                    getChildren().add(getCircle());
                    break;
                case ShapePane.RECTANGLE:
                    getChildren().add(getRectangle());
                    break;
                case ShapePane.ELLIPSE:
                    getChildren().add(getEllipse());
                    break;
                case ShapePane.SQUARE:
                    getChildren().add(getSquare());
                    break;
            }
        }

        private Circle getCircle() {
            // Returns circle shape
            return new Circle(200, getColor());
        }

        private Rectangle getRectangle() {
            // Returns rectangle shape
            return new Rectangle(400, 300, getColor());
        }

        private Ellipse getEllipse() {
            // Returns ellipse shape
            Ellipse ellipse = new Ellipse(250, 200);
            ellipse.setStrokeWidth(2);
            ellipse.setFill(getColor());
            return ellipse;
        }

        private Rectangle getSquare() {
            // Returns square shape
            return new Rectangle(300, 300, getColor());
        }
    }
}
