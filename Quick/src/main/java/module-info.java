module com.example.quick {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.quick to javafx.fxml;
    exports com.example.quick;
}