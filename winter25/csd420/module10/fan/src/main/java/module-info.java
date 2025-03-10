module com.example.fan {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.fan to javafx.fxml;
    exports com.example.fan;
}