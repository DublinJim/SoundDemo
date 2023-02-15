package com.example.sounddemo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.EventListener;
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

    private ObservableList<String> choiceListArray = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] fruits = {"Option 1", "Option 2", "Option 3"};
        String[] week_days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        // Create a combo box
        ComboBox comboBox1 = new ComboBox(FXCollections.observableArrayList(week_days));
        comboBox2 = new ComboBox<>(FXCollections.observableArrayList(fruits));

        comboBox1.setPromptText("Days");
        comboBox2.setPromptText("Options");

        vBox.getChildren().add(comboBox2);
        vBox.getChildren().add(comboBox1);

btn1.setOnAction(e->{
    getOutput();
});

    }

    public void getOutput()
    {
        txtOutput.setText(comboBox2.getValue());
    }


}
