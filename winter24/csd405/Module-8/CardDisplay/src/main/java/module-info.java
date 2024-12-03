module com.example.carddisplay {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.carddisplay to javafx.fxml;
    exports com.example.carddisplay;
}