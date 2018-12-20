package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import modells.TableData;

import java.net.URL;
import java.util.*;

/**
 * Created by Loving on 14.12.2018.
 */
public class Controller implements Initializable {
    private Timer timer;
    @FXML
    TableView tableView;
    @FXML
    TableColumn<TableData,String> Vaqt;
    @FXML
    TableColumn<TableData, ImageView> Rasm;
    @FXML
    TableColumn<TableData,String> Reys;
    @FXML
    TableColumn<TableData,String> Mashrut;
    @FXML
    TableColumn<TableData,String> Status;



    List<TableData> list=new ArrayList<TableData>();
    public void initialize(URL location, ResourceBundle resources) {

        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ImageView imageView1 = new ImageView("img/uzairways_logo.jpg");
                ImageView imageView2 = new ImageView("img/uzairways_logo.jpg");
                list =new ArrayList<TableData>();
                list.add(new TableData("12:10", imageView1, "HY 615", "Москва", "прибил в 12:15"));
                list.add(new TableData("14:30", imageView2, "HY 52", "Ташкент", "по расписанию"));
                tableView.getItems().clear();
                tableView.getItems().addAll(list);

            }
        },6001);
        Vaqt.setCellValueFactory(new PropertyValueFactory<TableData, String>("time"));
        Rasm.setCellValueFactory(new PropertyValueFactory<TableData, ImageView>("imageView"));
        Reys.setCellValueFactory(new PropertyValueFactory<TableData, String>("flight"));
        Mashrut.setCellValueFactory(new PropertyValueFactory<TableData, String>("destination"));
        Status.setCellValueFactory(new PropertyValueFactory<TableData,String>("status"));
        ImageView imageView1 = new ImageView("img/uzairways_logo.jpg");
        ImageView imageView2 = new ImageView("img/uzairways_logo.jpg");
        ImageView imageView3 = new ImageView("img/nordwind-airlines-logo.png");
        ImageView imageView4 = new ImageView("img/uzairways_logo.jpg");
        ImageView imageView5 = new ImageView("img/S7-airline-logo.png");

        list.add(new TableData("12:10", imageView1, "HY 615", "Москва", "прибил в 12:15"));
        list.add(new TableData("14:30", imageView2, "HY 52", "Ташкент", "по расписанию"));
        list.add(new TableData("15:40", imageView3, "S7 966", "Ташкент", "по расписанию"));
        list.add(new TableData("17:05", imageView4, "HY 966", "Санкт-Петербург", "по расписанию"));
        list.add(new TableData("18:50", imageView5, "S7 966", "Москва", "по расписанию"));
        tableView.getItems().addAll(list);

    }


}
