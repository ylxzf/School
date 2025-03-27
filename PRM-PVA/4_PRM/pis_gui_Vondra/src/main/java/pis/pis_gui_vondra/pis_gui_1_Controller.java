package pis.pis_gui_vondra;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringJoiner;

public class pis_gui_1_Controller implements Initializable {

    @FXML
    private TextField txt_rodnecislo_1;
    @FXML
    private TextField txt_rodnecislo_2;

    @FXML
    private Label lbl_output;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void onClickCheck() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(txt_rodnecislo_1.getText());
        stringBuilder.append(txt_rodnecislo_2.getText());

        StringJoiner stringJoiner = new StringJoiner(", ");

        try {
            long rodneCislo = Long.parseLong(stringBuilder.toString());

            String month = txt_rodnecislo_1.getText().substring(2, 4);
            String day = txt_rodnecislo_1.getText().substring(4, 6);

            if (stringBuilder.toString().length() != 10) {
                stringJoiner.add("Invalid length");
            }

            if (Integer.parseInt(month) % 50 < 1 || Integer.parseInt(month) % 50 > 12) {
                stringJoiner.add("Invalid Month");
            }

            if (Integer.parseInt(day) < 1 || Integer.parseInt(day) > 31) {
                stringJoiner.add("Invalid Day");
            }

            System.out.println("a");

            if (rodneCislo % 11 == 0) {
                stringJoiner.add("Valid RČ");
            } else {
                stringJoiner.add("Not divisible by 11");
            }

        } catch (NumberFormatException e) {
            stringJoiner.add("Invalid Number");
        }

        lbl_output.setText(stringJoiner.toString());
    }
}