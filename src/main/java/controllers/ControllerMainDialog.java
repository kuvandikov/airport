package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBox.getItems().addAll("Departure", "Arrive");
        comboBox.getSelectionModel().select(0);
        comboBox.show();
    }

    public void okClick(ActionEvent actionEvent) throws IOException {
        Parent sample = FXMLLoader.load(getClass().getClassLoader().getResource("Sample.fxml"));
        Scene mainScene = ((JFXButton) actionEvent.getSource()).getParent().getScene();
        Stage stage = (Stage) mainScene.getWindow();
        mainScene.setRoot(sample);
        stage.setMaximized(true);
        stage.initStyle(StageStyle.UNDECORATED);
//        primaryStage.setMaximized(true);
//        primaryStage.initStyle(StageStyle.UNDECORATED);

    }

    public void cancel(ActionEvent actionEvent) {
        System.exit(0);
    }
}
