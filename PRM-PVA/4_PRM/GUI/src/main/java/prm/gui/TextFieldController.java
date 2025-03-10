package prm.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringJoiner;

public class TextFieldController implements Initializable {

    @FXML
    private Label lbl_output;
    @FXML
    private TextField txt_count;
    @FXML
    private TextField txt_word;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void onClickUpdateOutput() {
        StringJoiner stringJoiner = new StringJoiner(" ");
        for (int i = 0; i < Integer.parseInt(txt_count.getText()); i++) {
            stringJoiner.add(txt_word.getText());
        }
        lbl_output.setText(stringJoiner.toString());
    }
}
