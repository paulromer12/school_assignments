module com.example.hboxvboxexamples {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hboxvboxexamples to javafx.fxml;
    exports com.example.hboxvboxexamples;
}