module com.example.temasfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.temasfx to javafx.fxml;
    exports com.example.temasfx;
    exports com.example.temasfx.tema;
    opens com.example.temasfx.tema to javafx.fxml;
    exports com.example.temasfx.tema.impl;
    opens com.example.temasfx.tema.impl to javafx.fxml;
}