module com.example.passwordstoragedb {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires log4j;

    opens com.example.passwordstoragedb to javafx.fxml;
    exports com.example.passwordstoragedb;
}