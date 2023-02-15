package com.example.sounddemo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    public Button btn1;
    public Button btn4;
    public Button btn3;
    public Button btn2;

    public ComboBox<String> combo2;
    public VBox vBox;
    public AnchorPane rootPane;

    private ObservableList<String> choiceListArray = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] fruits = {"Option 1", "Option 2", "Option 3"};


        String[] week_days =
                {"Select Day","Monday", "Tuesday", "Wednesday",
                        "Thursday", "Friday"};

        // Create a combo box
        ComboBox combo_box = new ComboBox(FXCollections.observableArrayList(week_days));
combo_box.getSelectionModel().select(week_days[0]);
        rootPane.getChildren().add(combo_box);
        combo2 =new ComboBox<>(FXCollections.observableArrayList(fruits));
        vBox.getChildren().add(combo2);
        combo2.getSelectionModel().select(fruits[0]);
    }

}
