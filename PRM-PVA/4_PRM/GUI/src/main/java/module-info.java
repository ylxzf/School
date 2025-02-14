module prm.gui {
    requires javafx.controls;
    requires javafx.fxml;


    opens prm.gui to javafx.fxml;
    exports prm.gui;
}