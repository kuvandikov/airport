package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXProgressBar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Loving on 30.01.2019.
 */
public class ControllerMainDialog implements Initializable {

    @FXML
    JFXButton ok;
    @FXML
    JFXButton cancel;
    @FXML
    JFXComboBox<String> comboBox;
    @FXML
    JFXProgressBar progressBar;

    Controller controller;
    ControllerTablo controllerTablo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBox.getItems().addAll("Departure", "Arrive", "Terminal 1", "Terminal 2", "Terminal 3", "Terminal 4", "Terminal 5");
        comboBox.getSelectionModel().select(0);
        comboBox.show();
        controller = new Controller();
        controllerTablo = new ControllerTablo();
    }

    public void okClick(ActionEvent actionEvent) throws IOException {
        if (comboBox.getSelectionModel().getSelectedIndex() < 2) {
            controller.start(comboBox.getSelectionModel().getSelectedIndex());
        } else {
            controllerTablo.start(comboBox.getSelectionModel().getSelectedIndex());
        }
        Stage stage = (Stage) ((JFXButton) actionEvent.getSource()).getScene().getWindow();
        stage.close();
//        System.out.println(comboBox.getSelectionModel().getSelectedIndex());
//        Parent sample = FXMLLoader.load(getClass().getClassLoader().getResource("Sample.fxml"));
//        System.out.println("ha navchun");
//        Scene mainScene = ((JFXButton) actionEvent.getSource()).getParent().getScene();
//        Stage stage = (Stage) mainScene.getWindow();
//        mainScene.setRoot(sample);
//        stage.setMaximized(true);

    }

    public void cancel(ActionEvent actionEvent) {
        Stage stage = (Stage) ((JFXButton) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
