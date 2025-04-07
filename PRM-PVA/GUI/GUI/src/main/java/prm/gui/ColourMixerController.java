package prm.gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class ColourMixerController implements Initializable {
    //promenee pro pamatovani nastavenych barev
    private int red = 0;
    private int green = 0;
    private int blue = 0;

    //graf. komponenty z FXML
    @FXML
    private Pane pnl_color;
    @FXML
    private Slider sld_red;
    @FXML
    private Slider sld_green;
    @FXML
    private Slider sld_blue;

    @FXML
    private Label lbl_red;
    @FXML
    private Label lbl_green;
    @FXML
    private Label lbl_blue;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //tato metoda se spusti pri startu aplikace

        //ozivime red slider
        sld_red.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                                Number oldValue, Number newValue) {
                //sem vlozit kod, ktery se spusti pri pohnuti se sliderem
                //stahni novou hodnotu cerveneho slideru a uloz ji do promenne
                red = newValue.intValue();
                //prebarvi pozadi panelu
                setPanelBackGround();
                lbl_red.setText(String.valueOf(red));
            }
        });

        //ozivime green slider
        sld_green.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                                Number oldValue, Number newValue) {
                //sem vlozit kod, ktery se spusti pri pohnuti se sliderem
                //stahni novou hodnotu cerveneho slideru a uloz ji do promenne
                green = newValue.intValue();
                //prebarvi pozadi panelu
                setPanelBackGround();
                lbl_green.setText(String.valueOf(green));
            }
        });

        //ozivime blue slider
        sld_blue.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                                Number oldValue, Number newValue) {
                //sem vlozit kod, ktery se spusti pri pohnuti se sliderem
                //stahni novou hodnotu cerveneho slideru a uloz ji do promenne
                blue = newValue.intValue();
                //prebarvi pozadi panelu
                setPanelBackGround();
                lbl_blue.setText(String.valueOf(blue));
            }
        });

        lbl_red.setText(String.valueOf(red));
        lbl_green.setText(String.valueOf(green));
        lbl_blue.setText(String.valueOf(blue));
        //spustime setBackGround - kvuli nastaveni prvni cerne barvy
        setPanelBackGround();
    }

    private void setPanelBackGround() {
        pnl_color.setBackground(new Background(
                new BackgroundFill(Color.rgb(red, green, blue),
                        CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
