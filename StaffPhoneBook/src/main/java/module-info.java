module coit11134.staffphonebook {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens coit11134.staffphonebook to javafx.fxml;
    exports coit11134.staffphonebook;
}
