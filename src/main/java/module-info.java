module com.aplikasi.sederhana.projectuas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;
    requires java.sql;

    requires com.dlsc.formsfx;

    opens com.aplikasi.sederhana.projectuas to javafx.fxml;
    exports com.aplikasi.sederhana.projectuas;
}