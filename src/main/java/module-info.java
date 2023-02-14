module com.example.sounddemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sounddemo to javafx.fxml;
    exports com.example.sounddemo;
}