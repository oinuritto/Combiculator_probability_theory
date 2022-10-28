package ru.itis.oinuritto.combinatorics.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import ru.itis.oinuritto.combinatorics.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private static String toggledRadioButton = "Без повторений";
    private static String comboboxSettedValue = "Перестановки";

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private RadioButton nonRepeat;

    @FXML
    private RadioButton repeat;

    @FXML
    private ToggleGroup repeatOrNotGroup;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.getItems().add("Перестановки");
        comboBox.getItems().add("Размещения");
        comboBox.getItems().add("Сочетания");

        comboBox.setValue(comboboxSettedValue);
        if (toggledRadioButton.equals("Без повторений")) {
            nonRepeat.fire();
        } else {
            repeat.fire();
        }
    }

    public void onNextButtonClick(ActionEvent event) throws IOException {
        String comboBoxValue = comboBox.getValue();
        String radioButtonValue = ((RadioButton) repeatOrNotGroup.getSelectedToggle()).getText();
        String path;

        if (radioButtonValue.equals("Без повторений")) {
            switch (comboBoxValue) {
                case ("Размещения"):
                    path = "fxml/variation-non-repeat.fxml";
                    break;
                case ("Сочетания"):
                    path = "fxml/combination-non-repeat.fxml";
                    break;
                default:
                    path = "fxml/permutation-non-repeat.fxml";
            }
        } else {
            switch (comboBoxValue) {
                case ("Размещения"):
                    path = "fxml/variation-repeat.fxml";
                    break;
                case ("Сочетания"):
                    path = "fxml/combination-repeat.fxml";
                    break;
                default:
                    path = "fxml/permutation-repeat.fxml";
            }
        }
        root = FXMLLoader.load(Main.class.getResource(path));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        comboboxSettedValue = comboBoxValue;
        toggledRadioButton = radioButtonValue;
    }
}
