module com.example.displayshapes {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.displayshapes to javafx.fxml;
    exports com.example.displayshapes;
}