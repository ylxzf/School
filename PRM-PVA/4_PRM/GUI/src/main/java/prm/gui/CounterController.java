package prm.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CounterController implements Initializable {
    int counter;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        counter = 0;
    }

    @FXML
    private Label lblCounter;

    @FXML
    private void onAddClick() {
        counter++;
        lblCounter.setText(String.valueOf(counter));
    }

    @FXML
    private void onSubtractClick() {
        counter--;
        lblCounter.setText(Integer.toString(counter));
    }
}