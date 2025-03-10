module com.example.paulthreethreadsfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.paulthreethreadsfx to javafx.fxml;
    exports com.example.paulthreethreadsfx;
}