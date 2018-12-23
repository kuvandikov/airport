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
    TableColumn<TableData,Integer> Terminal;
    @FXML
    TableColumn<TableData,String> Status;


//Namuna uchun
    int cnt;
    ImageView imageuzairway;
    ImageView imagenordwind;
    ImageView imageS7airline;

    List<TableData> listuz=new ArrayList<TableData>();
    List<TableData> listeng=new ArrayList<TableData>();
    List<TableData> listru=new ArrayList<TableData>();


//////
    public void initialize(URL location, ResourceBundle resources) {
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("QQQQQQQQQQQQQ");
                System.out.println(timer.purge());
            }

        },401);
        Vaqt.setCellValueFactory(new PropertyValueFactory<TableData, String>("time"));
        Rasm.setCellValueFactory(new PropertyValueFactory<TableData, ImageView>("imageView"));
        Reys.setCellValueFactory(new PropertyValueFactory<TableData, String>("flight"));
        Mashrut.setCellValueFactory(new PropertyValueFactory<TableData, String>("destination"));
        Terminal.setCellValueFactory(new PropertyValueFactory<TableData, Integer>("terminal"));
        Status.setCellValueFactory(new PropertyValueFactory<TableData,String>("status"));

        imageuzairway  = new ImageView("img/uzairways_logo.jpg");
        imagenordwind  = new ImageView("img/nordwind-airlines-logo.png");
        imageS7airline = new ImageView("img/S7-airline-logo.png");

//        listru.add(new TableData("12:10", imagenordwind, "HY 615", "Москва",null, "прибил в 12:15"));
//        listru.add(new TableData("14:30", imageuzairway, "HY 52", "Ташкент", 3,"по расписанию"));
        listru.add(new TableData("15:40", imageuzairway, "S7 966", "Ташкент",6, "по расписанию"));
        listru.add(new TableData("17:05", imageS7airline, "HY 966", "Санкт-Петербург",5, "по расписанию"));
        listru.add(new TableData("18:50", imagenordwind, "S7 966", "Москва", 5,"по расписанию"));
//        Terminal.setVisible(false);
        tableView.getItems().addAll(listru);
    }



}
