module com.example.module7redo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.module7redo to javafx.fxml;
    exports com.example.module7redo;
}