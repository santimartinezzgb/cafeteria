module org.example.cafeteria {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.cafeteria to javafx.fxml;
    exports org.example.cafeteria;
}