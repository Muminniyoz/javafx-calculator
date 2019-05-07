package calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

public class Menu implements Initializable {

    @FXML
    private ToggleGroup AsosRejim;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        AsosRejim.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if (AsosRejim.getToggles().get(0) == newValue) {
                    Calculator.stage.setWidth(216);
                     Calculator.stage.setHeight(316);

                    Calculator.layout.setCenter(Calculator.rejim1);
                } else
                if (AsosRejim.getToggles().get(1) == newValue) {
                    Calculator.stage.setWidth(412);
                     Calculator.stage.setHeight(316);

                    Calculator.layout.setCenter(Calculator.rejim2);
                } else    if (AsosRejim.getToggles().get(2) == newValue) {
                    Calculator.stage.setWidth(412);
                    Calculator.stage.setHeight(390);

                    Calculator.layout.setCenter(Calculator.rejim3);
                }

            }
        });
    }

}
