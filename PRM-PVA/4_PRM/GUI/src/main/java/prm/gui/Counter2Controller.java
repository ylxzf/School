package prm.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Counter2Controller implements Initializable {

    int counter;

    @FXML
    private Label lbl_Counter;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        counter = 0;
        lbl_Counter.setText(String.valueOf(counter));
    }

    @FXML
    private void onClickUpdate(ActionEvent event) {
        String btnID = ((Button) event.getSource()).getId();

        switch (btnID) {
            case "btn_Add":
                counter++;
                break;
            case "btn_Subtract":
                counter--;
                break;
            case "btn_Reset":
                counter = 0;
                break;
        }
        lbl_Counter.setText(String.valueOf(counter));
    }

//    @FXML
//    private void onClickAdd(ActionEvent event) {
//        counter++;
//        lbl_Counter.setText(String.valueOf(counter));
//    }
//
//    @FXML
//    private void onClickSubtract(ActionEvent event) {
//        counter--;
//        lbl_Counter.setText(String.valueOf(counter));
//    }
//
//    @FXML
//    private void onClickReset(ActionEvent event) {
//        counter = 0;
//        lbl_Counter.setText(String.valueOf(counter));
//    }
}
