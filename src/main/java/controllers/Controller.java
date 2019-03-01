package controllers;

import httpRequests.HttpRequests;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import modells.TableData;
import view.CalBackCellStyle;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Loving on 14.12.2018.
 */
public class Controller implements Initializable {

    private static String path;
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
    TableColumn<TableData, String> Terminal;
    @FXML
    TableColumn<TableData,String> Status;
    @FXML
    Label date;
    @FXML
    Label time;
//Namuna uchun
    int cnt;
    LocalDate localDate;
    LocalTime localTime;
    ImageView imageuzairway;
    ImageView imagenordwind;
    ImageView imageS7airline;

    List<TableData> listuz=new ArrayList<TableData>();
    List<TableData> listeng=new ArrayList<TableData>();
    List<TableData> listru=new ArrayList<TableData>();


    public void start(int selectedIndex) throws IOException {
        if (selectedIndex == 0) {
            path = "departure";
        } else {
            path = "arrive";
        }
        System.out.println("start: " + path);
        Parent sample = FXMLLoader.load(getClass().getClassLoader().getResource("Sample.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(sample));
        stage.setMaximized(true);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

    }

    //////
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("ini: " + path);
        cnt=0;
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
                if(cnt==1){
                    if (path.equals("arrive")) {
                        Terminal.setVisible(false);
                        title.setText("KELISH");
                    } else {
                        title.setText("JO`NASH");
                    }
                    Vaqt.setText("VAQT");
                    Reys.setText("REYS");
                    Mashrut.setText("MARSHRUT");
                    Terminal.setText("TERMINAL");
                    Status.setText("STATUS");
                    tableView.getItems().clear();
                    tableView.getItems().addAll(listuz);
                }
                else if(cnt==2){
                    if (path.equals("arrive")) {
                        Terminal.setVisible(false);
                        title.setText("ARRIVE");
                    } else {
                        title.setText("DEPARTURE");
                    }
                    Vaqt.setText("TIME");
                    Reys.setText("REYS");
                    Mashrut.setText("FLIGHT");
                    Terminal.setText("TERMINAL");
                    Status.setText("STATUS");

                    tableView.getItems().clear();
                    tableView.getItems().addAll(listeng);
                }
                else if(cnt==3){
                    if (path.equals("arrive")) {
                        Terminal.setVisible(false);
                        title.setText("ВЫЛЕТЫ");
                    } else {
                        title.setText("ПРИЛЕТЫ");
                    }
                    Vaqt.setText("ВРЕМЯ");
                    Reys.setText("РЕЙС");
                    Mashrut.setText("МАРШРУТ");
                    Terminal.setText("ТЕРМИНАЛ");
                    Status.setText("СТАТУС");

                    tableView.getItems().clear();
                    tableView.getItems().addAll(listru);

//                    Malumot Yangilash
                    localDate = LocalDate.now();
                    localTime = LocalTime.now();
                    date.setText(localDate.format(DateTimeFormatter.ofPattern("MM.dd.yyyy")));
                    time.setText(localTime.format(DateTimeFormatter.ofPattern("HH:mm")));
                    cnt=0;
                    listuz = new HttpRequests().getAll(path + "/terminal/date=" + localDate, 1);
                    listeng = new HttpRequests().getAll(path + "/terminal/date=" + localDate, 2);
                    listru = new HttpRequests().getAll(path + "/terminal/date=" + localDate, 3);
                }

            }
        }));
        fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
        fiveSecondsWonder.play();
        Vaqt.setCellValueFactory(new PropertyValueFactory<TableData, String>("time"));
        Rasm.setCellValueFactory(new PropertyValueFactory<TableData, ImageView>("imageView"));
        Reys.setCellValueFactory(new PropertyValueFactory<TableData, String>("flight"));
        Mashrut.setCellValueFactory(new PropertyValueFactory<TableData, String>("destination"));
        Terminal.setCellValueFactory(new PropertyValueFactory<TableData, String>("terminal"));
        Status.setCellValueFactory(new PropertyValueFactory<TableData,String>("status"));

//        imageuzairway  = new ImageView("img/uzairways_logo.jpg");
//        imagenordwind  = new ImageView("img/nordwind-airlines-logo.png");
//        imageS7airline = new ImageView("img/S7-airline-logo.png");
//
//        listru.add(new TableData("15:40", imageuzairway, "S7 966", "Ташкент", "6", "ожидается в 12:25"));
//        listru.add(new TableData("17:05", imageS7airline, "HY 966", "Санкт-Петербург", "5", "отменён"));
//        listru.add(new TableData("18:50", imagenordwind, "S7 966", "Москва", "5", "по расписанию"));
//
//        listuz.add(new TableData("15:40", imageuzairway, "S7 966", "Toshkent", "6", "16:40 da kutilmoqda"));
//        listuz.add(new TableData("17:05", imageS7airline, "HY 966", "Sankt-Peterburk", "5", "Qoldirildi"));
//        listuz.add(new TableData("18:50", imagenordwind, "S7 966", "Moskva", "5", "Jadval asosida"));
//
//        listeng.add(new TableData("15:40", imageuzairway, "S7 966", "Tashkent", "6", "expected at 16:40"));
//        listeng.add(new TableData("17:05", imageS7airline, "HY 966", "Sankt-Peterburk", "5", "cancel"));
//        listeng.add(new TableData("18:50", imagenordwind, "S7 966", "Moscow", "5", "scheduled"));

        CalBackCellStyle cellStyle=new CalBackCellStyle();
        cellStyle.setTableColumn(Status);
        if (path.equals("arrive")) {
            Terminal.setVisible(false);
        }
        tableView.getItems().addAll(listru);

        listuz = new HttpRequests().getAll(path + "/terminal/date=" + localDate, 1);
        listeng = new HttpRequests().getAll(path + "/terminal/date=" + localDate, 2);
        listru = new HttpRequests().getAll(path + "/terminal/date=" + localDate, 3);
        tableView.getItems().addAll(listru);
    }

}
