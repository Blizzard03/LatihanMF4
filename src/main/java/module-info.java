module com.mariq.rasyid.latihanmf4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mariq.rasyid.latihanmf4 to javafx.fxml;
    exports com.mariq.rasyid.latihanmf4;
}
