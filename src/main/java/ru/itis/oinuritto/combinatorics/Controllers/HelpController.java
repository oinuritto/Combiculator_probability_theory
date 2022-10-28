package ru.itis.oinuritto.combinatorics.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.itis.oinuritto.combinatorics.utils.Combinatorics;
import ru.itis.oinuritto.combinatorics.Main;

import java.io.IOException;

public class HelpController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label permutNonRepeatAnswer;
    @FXML
    private TextField permutNonRepeatField;

    @FXML
    private TextField permutRepeatField_n;
    @FXML
    private Label permutRepeatAnswer;
    @FXML
    private TextField permutRepeatField_n1_nk;

    @FXML
    private TextField variationNonRepeatField_n;
    @FXML
    private TextField variationNonRepeatField_m;
    @FXML
    private Label variationsNonRepeatAnswer;

    @FXML
    private Label variationsRepeatAnswer;
    @FXML
    private TextField variationRepeatField_n;
    @FXML
    private TextField variationRepeatField_m;

    @FXML
    private TextField combinationNonRepeatField_n;
    @FXML
    private TextField combinationNonRepeatField_m;
    @FXML
    private Label combinationsNonRepeatAnswer;

    @FXML
    private TextField combinationRepeatField_n;
    @FXML
    private TextField combinationRepeatField_m;
    @FXML
    private Label combinationsRepeatAnswer;

    public void onPrevButtonClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Main.class.getResource("fxml/view-model.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void onCalculateNonRepeatPermut(ActionEvent actionEvent) {
        String input = permutNonRepeatField.getText().trim();
        int n = -1;
        try {
            n = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            permutNonRepeatAnswer.setText("Неверно записано число...");
        }

        if (n < 0) {
            permutNonRepeatAnswer.setText("Неверно записано число...");
            return;
        }
        permutNonRepeatAnswer.setText(Combinatorics.permutationNonRepeat(n));
    }

    public void onCalculateRepeatPermut(ActionEvent actionEvent) {
        String strN = permutRepeatField_n.getText().trim();
        String[] nArray = permutRepeatField_n1_nk.getText().trim().split(" ");

        int n = -1;
        int[] intArrayOfNk = new int[nArray.length];
        try {
            n = Integer.parseInt(strN);
            for (int i = 0; i < nArray.length; i++) {
                intArrayOfNk[i] = Integer.parseInt(nArray[i]);
            }
        } catch (NumberFormatException e) {
            permutRepeatAnswer.setText("Неверно записаны числа...");
        }

        if (n < 0 || Combinatorics.sumArr(intArrayOfNk) != n) {
            permutRepeatAnswer.setText("Неверно записаны числа...");
            return;
        }

        permutRepeatAnswer.setText(Combinatorics.permutationRepeat(n, intArrayOfNk));
    }

    public void onCalculateVariationsNonRepeat(ActionEvent actionEvent) {
        String strN = variationNonRepeatField_n.getText().trim();
        String strM = variationNonRepeatField_m.getText().trim();

        int n = -1;
        int m = -1;
        try {
            n = Integer.parseInt(strN);
            m = Integer.parseInt(strM);
        } catch (NumberFormatException e) {
            variationsNonRepeatAnswer.setText("Неверно записаны числа...");
        }

        if (n < 0 || m < 0 || m > n) {
            variationsNonRepeatAnswer.setText("Неверно записаны числа...");
            return;
        }

        variationsNonRepeatAnswer.setText(Combinatorics.variationsNonRepeat(n, m));
    }

    public void onCalculateVariationsRepeat(ActionEvent actionEvent) {
        String strN = variationRepeatField_n.getText().trim();
        String strM = variationRepeatField_m.getText().trim();

        int n = -1;
        int m = -1;
        try {
            n = Integer.parseInt(strN);
            m = Integer.parseInt(strM);
        } catch (NumberFormatException e) {
            variationsRepeatAnswer.setText("Неверно записаны числа...");
        }

        if (n < 0 || m < 0) {
            variationsRepeatAnswer.setText("Неверно записаны числа...");
            return;
        }

        variationsRepeatAnswer.setText(Combinatorics.variationsRepeat(n, m));
    }

    public void onCalculateCombinationsNonRepeat(ActionEvent actionEvent) {
        String strN = combinationNonRepeatField_n.getText().trim();
        String strM = combinationNonRepeatField_m.getText().trim();

        int n = -1;
        int m = -1;
        try {
            n = Integer.parseInt(strN);
            m = Integer.parseInt(strM);
        } catch (NumberFormatException e) {
            combinationsNonRepeatAnswer.setText("Неверно записаны числа...");
        }

        if (n < 0 || m < 0 || m > n) {
            combinationsNonRepeatAnswer.setText("Неверно записаны числа...");
            return;
        }

        combinationsNonRepeatAnswer.setText(Combinatorics.combinationsNonRepeat(n, m));
    }

    public void onCalculateCombinationsRepeat(ActionEvent actionEvent) {
        String strN = combinationRepeatField_n.getText().trim();
        String strM = combinationRepeatField_m.getText().trim();

        int n = -1;
        int m = -1;
        try {
            n = Integer.parseInt(strN);
            m = Integer.parseInt(strM);
        } catch (NumberFormatException e) {
            combinationsRepeatAnswer.setText("Неверно записаны числа...");
        }

        if (n < 0 || m < 0) {
            combinationsRepeatAnswer.setText("Неверно записаны числа...");
            return;
        }

        combinationsRepeatAnswer.setText(Combinatorics.combinationsRepeat(n, m));
    }
}
