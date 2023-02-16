package com.example.sounddemo;

import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    public Button btn1;
    public Button btn4;
    public Button btn3;
    public Button btn2;

    public ComboBox<String> comboBox2;
    public VBox vBox;
    public AnchorPane rootPane;
    public Text txtOutput;

    public ComboBox<String> comboBox1;
    public Text txtOutput2;
    public String[] fruits;
    public String[] week_days;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        fruits = new String[]{"Option 1", "Option 2", "Option 3"};
        week_days = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        // Create a combo box
        comboBox1 = new ComboBox<>(FXCollections.observableArrayList(week_days));
        comboBox2 = new ComboBox<>(FXCollections.observableArrayList(fruits));

        comboBox1.setPromptText("Days");
        comboBox2.setPromptText("Options");

        vBox.getChildren().add(comboBox2);
        vBox.getChildren().add(comboBox1);

        btn1.setOnAction(e -> getOutputCombo2());

        btn2.setOnAction(e -> getOutputCombo1());


    }


    public void getOutputCombo2() {

        txtOutput.setText(comboBox2.getValue());
    }

    public void getOutputCombo1() {
        txtOutput.setText(comboBox1.getValue());

        if (Objects.equals(comboBox1.getValue(), week_days[1])) {
            txtOutput2.setText("Now "+comboBox1.getValue()+" " + fruits[1]);
        }
    }

}
