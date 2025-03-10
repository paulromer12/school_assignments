package com.example.fan;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.*;


public class FanManagerFX extends Application {

    //Database connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/databasedb";
    private static final String USER = "student1";
    private static final String PASSWORD = "pass";

    // UI components
    private TextField idField, firstNameField, lastNameField, favoriteTeamField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Build the UI using a GridPane layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        // Create Labels and TextFields
        Label idLabel = new Label("ID:");
        idField = new TextField();
        Label firstNameLabel = new Label("First Name:");
        firstNameField = new TextField();
        Label lastNameLabel = new Label("Last Name:");
        lastNameField = new TextField();
        Label favoriteTeamLabel = new Label("Favorite Team:");
        favoriteTeamField = new TextField();

        // Create Buttons
        Button displayButton = new Button("Display");
        Button updateButton = new Button("Update");

        // Add components to the grid
        grid.add(idLabel, 0, 0);
        grid.add(idField, 1, 0);
        grid.add(firstNameLabel, 0, 1);
        grid.add(firstNameField, 1, 1);
        grid.add(lastNameLabel, 0, 2);
        grid.add(lastNameField, 1, 2);
        grid.add(favoriteTeamLabel, 0, 3);
        grid.add(favoriteTeamField, 1, 3);
        grid.add(displayButton, 0, 4);
        grid.add(updateButton, 1, 4);

        // Set up event handlers for buttons
        displayButton.setOnAction(e -> displayFan());
        updateButton.setOnAction(e -> updateFan());

        // Prepare and show the scene
        Scene scene = new Scene(grid, 400, 250);
        primaryStage.setTitle("Fans");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Get a connection to the database
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    // Display fan information for the given ID
    private void displayFan() {
        int id;
        try {
            id = Integer.parseInt(idField.getText());
        } catch (NumberFormatException ex) {
            showAlert("Invalid ID", "Please enter a valid numeric ID.");
            return;
        }

        String query = "SELECT firstname, lastname, favoriteteam FROM fans WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                firstNameField.setText(rs.getString("firstname"));
                lastNameField.setText(rs.getString("lastname"));
                favoriteTeamField.setText(rs.getString("favoriteteam"));
            } else {
                showAlert("Record Not Found", "No record found with ID: " + id);
            }
        } catch (SQLException ex) {
            showAlert("Database Error", ex.getMessage());
        }
    }

    // Update the fan record in the database with the values entered in the GUI
    private void updateFan() {
        int id;
        try {
            id = Integer.parseInt(idField.getText());
        } catch (NumberFormatException ex) {
            showAlert("Invalid ID", "Please enter a valid numeric ID.");
            return;
        }

        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String favoriteTeam = favoriteTeamField.getText();

        String query = "UPDATE fans SET firstname = ?, lastname = ?, favoriteteam = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, favoriteTeam);
            ps.setInt(4, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                showAlert("Success", "Record updated successfully.");
            } else {
                showAlert("Update Failed", "No record found with ID: " + id);
            }
        } catch (SQLException ex) {
            showAlert("Database Error", ex.getMessage());
        }
    }

    // Helper method to show an alert dialog
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}