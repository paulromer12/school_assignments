// Paul Romer, Module 12 Assignment
// Module 11 Redo - improved documentation and updated fill code to start transparent, and fill with random color
// based when the checkbox is selected and clear when not. Added stroke so that the shape is visible when it isn't filled.

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

// The main entry for this JavaFX application.
public class DisplayShapesRedo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Initializes and sets up the main stage of the JavaFX application.
     *
     * This method creates the primary layout using a BorderPane and adds the UI components:
     * - A title label at the top.
     * - A ShapePane in the center for displaying shapes.
     * - A VBox on the left for the radio buttons to select the shape and a checkbox for random colors.
     *
     * The method also configures event handlers for user interaction, such as:
     * - Updating the ShapePane when a radio button is selected to draw the corresponding shape.
     * - Applying a random color to shapes when the checkbox is selected.
     *
     * Finally, the method sets the scene dimensions, assigns the layout to the stage, and shows the stage.
     */

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
        primaryStage.setTitle("Paul Romer Module 12");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // inner class contains the logic for managing and displaying the shapes
    public static class ShapePane extends StackPane {

        // variables to determine what shape to display
        public static final int CIRCLE = 0;
        public static final int RECTANGLE = 1;
        public static final int ELLIPSE = 2;
        public static final int SQUARE = 3;

        // stores reference to the checkbox of outer class
        private CheckBox randomColor;

        // store the current shape as an int
        private int currentShape = 0;

        private void setRandomColor(CheckBox checkBox) {
            // setter shares checkbox reference from inner class
            randomColor = checkBox;
        }

        private void setCurrentShape(int shape) {
            // setter to store the currently selected shape
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
                return null; // transparent fill
            }
        }

        public void drawShape() {
            drawShape(currentShape);
        }

        // determines the shape to display based on the provided integer and updates the pane
        public void drawShape(int shape) {

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

        // initiates and defines shapes stroke width, stroke color, and fill
        private Circle getCircle() {
            // Returns circle shape
            Circle circle = new Circle(200);
            circle.setFill(getColor()); // sets fill color to getColor()
            circle.setStroke(Color.BLACK); // sets stroke color to black
            circle.setStrokeWidth(2); // sets stroke width to 2
            return circle;
        }

        private Rectangle getRectangle() {
            // Returns rectangle shape
            Rectangle rectangle = new Rectangle(400, 300);
            rectangle.setFill(getColor()); // sets fill color to getColor()
            rectangle.setStroke(Color.BLACK); // sets stroke color to black
            rectangle.setStrokeWidth(2); // sets stroke width to 2
            return rectangle;
        }

        private Ellipse getEllipse() {
            // Returns ellipse shape
            Ellipse ellipse = new Ellipse(250, 200);
            ellipse.setFill(getColor()); // sets fill color to getColor()
            ellipse.setStroke(Color.BLACK); // sets stroke color to black
            ellipse.setStrokeWidth(2); // sets stroke width to 2
            return ellipse;
        }

        private Rectangle getSquare() {
            // Returns square shape
            Rectangle square = new Rectangle(300, 300);
            square.setFill(getColor()); // sets fill color to getColor()
            square.setStroke(Color.BLACK); // sets stroke color to black
            square.setStrokeWidth(2); // sets stroke width to 2
            return square;
        }
    }
}
