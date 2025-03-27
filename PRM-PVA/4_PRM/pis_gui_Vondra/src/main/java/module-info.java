module pis.pis_gui_vondra {
    requires javafx.controls;
    requires javafx.fxml;


    opens pis.pis_gui_vondra to javafx.fxml;
    exports pis.pis_gui_vondra;
}