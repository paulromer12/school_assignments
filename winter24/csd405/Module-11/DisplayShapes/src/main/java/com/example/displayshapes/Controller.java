package com.example.displayshapes;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Circle circleDisplay;

    @FXML
    private Rectangle rectangleDisplay;

    @FXML
    private Ellipse ellipseDisplay;

    @FXML
    private RadioButton circleRadio;

    @FXML
    private RadioButton rectangleRadio;

    @FXML
    private RadioButton ellipseRadio;

    @FXML
    private CheckBox fillCheckBox;

    private final Random random = new Random();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Start with all shapes visible by selecting all radio buttons
        circleRadio.setSelected(true);
        rectangleRadio.setSelected(true);
        ellipseRadio.setSelected(true);

        updateShapeVisibility();
    }

    @FXML
    public void toggleCircle(ActionEvent e) {
        updateShapeVisibility();
    }

    @FXML
    public void toggleRectangle(ActionEvent e) {
        updateShapeVisibility();
    }

    @FXML
    public void toggleEllipse(ActionEvent e) {
        updateShapeVisibility();
    }

    @FXML
    public void toggleFill(ActionEvent e) {
        updateShapeFill();
    }

    private void updateShapeVisibility() {
        circleDisplay.setVisible(circleRadio.isSelected());
        rectangleDisplay.setVisible(rectangleRadio.isSelected());
        ellipseDisplay.setVisible(ellipseRadio.isSelected());

        updateShapeFill();
    }

    private void updateShapeFill() {
        Color fillColor = fillCheckBox.isSelected() ? randomColor() : Color.DODGERBLUE;

        if (circleDisplay.isVisible()) {
            circleDisplay.setFill(fillColor);
        }
        if (rectangleDisplay.isVisible()) {
            rectangleDisplay.setFill(fillColor);
        }
        if (ellipseDisplay.isVisible()) {
            ellipseDisplay.setFill(fillColor);
        }
    }

    private Color randomColor() {
        return Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }
}