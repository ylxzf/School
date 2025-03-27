package pis.pis_gui_vondra;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class pis_gui_1_Application extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(pis_gui_1_Application.class.getResource("pis_gui_1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("pis_gui_1_Vondra");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}