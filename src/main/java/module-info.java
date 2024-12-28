module src.main.java {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.net.http;
    opens com.example to javafx.fxml;
    exports com.example;
}
