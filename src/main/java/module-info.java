module com.example.demo2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.demo2 to javafx.fxml;
    exports com.example.demo2;
    exports com.example.demo2.shapes;
    opens com.example.demo2.shapes to javafx.fxml;
    exports com.example.demo2.editor;
    opens com.example.demo2.editor to javafx.fxml;
}