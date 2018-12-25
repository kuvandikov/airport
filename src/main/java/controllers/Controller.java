package controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import modells.TableData;
import view.CalBackCellStyle;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Loving on 14.12.2018.
 */
public class Controller implements Initializable {

    @FXML
    Label title;
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
        cnt=0;
        Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(10), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                cnt++;
                if(cnt==1){
                    title.setText("JO`NASH");
                    Vaqt.setText("VAQT");
                    Reys.setText("REYS");
                    Mashrut.setText("MASHRUT");
                    Terminal.setText("TERMINAL");
                    Status.setText("STATUS");
                    tableView.getItems().clear();
                    tableView.getItems().addAll(listuz);
                }
                else if(cnt==2){
                    title.setText("DEPARTURE");
                    Vaqt.setText("TIME");
                    Reys.setText("REYS");
                    Mashrut.setText("FLIGHT");
                    Terminal.setText("TERMINAL");
                    Status.setText("STATUS");

                    tableView.getItems().clear();
                    tableView.getItems().addAll(listeng);
                }
                else if(cnt==3){
                    title.setText("ПРИЛЕТЫ");
                    Vaqt.setText("ВРЕМЯ");
                    Reys.setText("РЕЙС");
                    Mashrut.setText("МАШРУТ");
                    Terminal.setText("ТЕРМИНАЛ");
                    Status.setText("СТАТУС");

                    tableView.getItems().clear();
                    tableView.getItems().addAll(listru);
                    cnt=0;
                }
            }
        }));
        fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
        fiveSecondsWonder.play();

        Vaqt.setCellValueFactory(new PropertyValueFactory<TableData, String>("time"));
        Rasm.setCellValueFactory(new PropertyValueFactory<TableData, ImageView>("imageView"));
        Reys.setCellValueFactory(new PropertyValueFactory<TableData, String>("flight"));
        Mashrut.setCellValueFactory(new PropertyValueFactory<TableData, String>("destination"));
        Terminal.setCellValueFactory(new PropertyValueFactory<TableData, Integer>("terminal"));
        Status.setCellValueFactory(new PropertyValueFactory<TableData,String>("status"));

        imageuzairway  = new ImageView("img/uzairways_logo.jpg");
        imagenordwind  = new ImageView("img/nordwind-airlines-logo.png");
        imageS7airline = new ImageView("img/S7-airline-logo.png");

//        listru.add(new TableData("12:10", imagenordwind, "HY 615", "Москва1",null, "прибил в 12:15"));
//        listru.add(new TableData("14:30", imageuzairway, "HY 52", "Ташкент", 3,"по расписанию"));
        listru.add(new TableData("15:40", imageuzairway, "S7 966", "Ташкент",6, "ожидается в 12:25"));
        listru.add(new TableData("17:05", imageS7airline, "HY 966", "Санкт-Петербург",5, "отменён"));
        listru.add(new TableData("18:50", imagenordwind, "S7 966", "Москва", 5,"по расписанию"));

        listuz.add(new TableData("15:40", imageuzairway, "S7 966", "Toshkent",6, "16:40 da kutilmoqda"));
        listuz.add(new TableData("17:05", imageS7airline, "HY 966", "Sankt-Peterburk",5, "qoldirildi"));
        listuz.add(new TableData("18:50", imagenordwind, "S7 966", "Moskva", 5,"jadval asosida"));

        listeng.add(new TableData("15:40", imageuzairway, "S7 966", "Tashkent",6, "expected at 16:40"));
        listeng.add(new TableData("17:05", imageS7airline, "HY 966", "Sankt-Peterburk",5, "cancel"));
        listeng.add(new TableData("18:50", imagenordwind, "S7 966", "Moscow", 5,"scheduled"));
        
        CalBackCellStyle cellStyle=new CalBackCellStyle();
        cellStyle.setTableColumn(Status);
        Terminal.setVisible(true);
        tableView.getItems().addAll(listru);

    }



}
