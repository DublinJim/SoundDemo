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
        //create the arrays for choices
        fruits = new String[]{"Option 1", "Option 2", "Option 3"};
        week_days = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        // Create a combo box
        comboBox1 = new ComboBox<>(FXCollections.observableArrayList(week_days));
        comboBox2 = new ComboBox<>(FXCollections.observableArrayList(fruits));

        //set the default text
        comboBox1.setPromptText("Days");
        comboBox2.setPromptText("Options");

        //add to the Vbox
        vBox.getChildren().add(comboBox2);
        vBox.getChildren().add(comboBox1);

        //blank the second text block
        txtOutput2.setText(null);

        //set up the buttons
        btn1.setText("Options");
        btn1.setPrefWidth(100);
        btn1.setOnAction(e -> getOutputCombo2());

        btn2.setText("Day");
        btn2.setPrefWidth(100);
        btn2.setOnAction(e -> getOutputCombo1());




    }


    public void getOutputCombo2() {

        txtOutput.setText(comboBox2.getValue());
    }

    public void getOutputCombo1() {
        txtOutput.setText(comboBox1.getValue());

        if (Objects.equals(comboBox1.getValue(), week_days[1])) {
            txtOutput2.setText("Now " + comboBox1.getValue() + " was selected");
        } else txtOutput2.setText(null);
    }

}
