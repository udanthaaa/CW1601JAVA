module com.example.cw1601java {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cw1601java to javafx.fxml;
    exports com.example.cw1601java;
}