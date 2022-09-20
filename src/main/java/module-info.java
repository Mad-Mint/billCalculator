module com.example.assignment04 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.assignment04 to javafx.fxml;
    exports com.example.assignment04;
}