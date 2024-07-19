module com.example.javafxproject {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.javafxproject to javafx.sql;
    exports com.example.javafxproject;
}
