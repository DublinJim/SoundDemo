package com.example.sounddemo;

import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.File;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    public Button btn1;

    public Button btn2;

    public ComboBox<String> comboBox2;
    public VBox vBox;
    public AnchorPane rootPane;
    public Text txtOutput1;

    public ComboBox<String> comboBox1;
    public Text txtOutput2;
    public String[] options;
    public String[] week_days;
public  String soundFilePiano;
public  String soundFileWinTada;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //create the arrays for choices
        options = new String[]{"Option 1", "Option 2", "Option 3"};
        week_days = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        // create a combo box
        comboBox1 = new ComboBox<>(FXCollections.observableArrayList(week_days));
        comboBox2 = new ComboBox<>(FXCollections.observableArrayList(options));

        //set the default text
        comboBox1.setPromptText("Days");
        comboBox2.setPromptText("Options");
        comboBox1.setPrefWidth(100);
        comboBox2.setPrefWidth(100);

        //blank the text blocks
        txtOutput2.setText(null);
        txtOutput1.setText(null);

        //set up the buttons
        btn1.setText("Options");
        btn1.setPrefWidth(100);
        btn1.setOnAction(e -> getOutputCombo2());

        btn2.setText("Day");
        btn2.setPrefWidth(100);

        btn2.setOnAction(e -> {
            playSound(soundFilePiano);
            getOutputCombo1();
        });

        //set a font
        Font franklin_gothic = new Font("Franklin Gothic", 15);

        //create a label
        Label lbl1 = new Label("Submit Choices");
        lbl1.setLayoutY(10);
        lbl1.setLayoutX(90);
        lbl1.setFont(franklin_gothic);

        //add to the Vbox and root
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.getChildren().add(comboBox2);
        vBox.getChildren().add(comboBox1);
        rootPane.getChildren().add(lbl1);

        soundFilePiano = "src/main/resources/piano2.wav";
        soundFileWinTada ="src/main/resources/owin31.wav";
    }


    public void getOutputCombo2() {

        txtOutput1.setText(comboBox2.getValue());
    }

    public void getOutputCombo1() {
        txtOutput1.setText(comboBox1.getValue());
        if (Objects.equals(comboBox1.getValue(), week_days[1])) {
            txtOutput2.setText("Now " + comboBox1.getValue() + " was selected");
            playSound(soundFileWinTada);
        } else txtOutput2.setText(null);
    }

    public void playSound(String soundFile) {

        Media sound = new Media(new File(soundFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();

    }

}
