package controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

/**
 * Created by Loving on 05.03.2019.
 */
public class ControllerTablo implements Initializable {


    @FXML
    VBox myPane;

    @FXML
    Label date;
    @FXML
    Label time;


    int cnt;
    LocalDate localDate;
    LocalTime localTime;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        cnt = 0;
        localDate = LocalDate.now();
        localTime = LocalTime.now();
        System.out.println("ibi hov");
        date.setText(localDate.format(DateTimeFormatter.ofPattern("MM.dd.yyyy")));
        time.setText(localTime.format(DateTimeFormatter.ofPattern("HH:mm")));
        /*Biror vaqtdan so`ng 3 tildan birsiga o`zgartirib turish*/
        Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(10), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                cnt++;
                localDate = LocalDate.now();
                localTime = localTime.now();
                if (cnt == 1) {
                } else if (cnt == 2) {
                } else if (cnt == 3) {

//                    Malumot Yangilash
                    localDate = LocalDate.now();
                    localTime = LocalTime.now();
                    date.setText(localDate.format(DateTimeFormatter.ofPattern("MM.dd.yyyy")));
                    time.setText(localTime.format(DateTimeFormatter.ofPattern("HH:mm")));
                    cnt = 0;
                }

            }
        }));
        fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
        fiveSecondsWonder.play();


    }
}
