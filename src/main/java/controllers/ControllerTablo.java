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
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import modells.TabloData;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

/**
 * Created by Loving on 05.03.2019.
 */
public class ControllerTablo implements Initializable {


    private static int terminal;
    TabloData tabloDataUz;
    TabloData tabloDataRu;
    TabloData tabloDataEn;
    @FXML
    private VBox myPane;
    @FXML
    private Label date;
    @FXML
    private Label time;
    @FXML
    private Label departclass;
    @FXML
    private Label reg;
    @FXML
    private Label terminalNum;
    @FXML
    private Label reys;
    @FXML
    private Label reysName;
    @FXML
    private ImageView logo;
    @FXML
    private Label line;
    @FXML
    private Label departure;
    @FXML
    private Label departureTime;
    @FXML
    private Label checkClosedAt;
    @FXML
    private Label checkClosedAtTime;
    @FXML
    private Label boardingClosedAt;

    int cnt;
    LocalDate localDate;
    LocalTime localTime;
    @FXML
    private Label boardingClosedAtTime;
    @FXML
    private Label sector;
    @FXML
    private Label sectorName;

    public void start(int selectedIndex) throws IOException {

        terminal = selectedIndex - 1;
        System.out.println(terminal);
        Parent tablo = FXMLLoader.load(getClass().getClassLoader().getResource("Tablo.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(tablo));
        stage.setMaximized(true);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        System.out.println(terminal);
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

                    reg.setText("Стойка регистрации");
                    reys.setText("Направление рейса");
                    departure.setText("Прилеты");
                    checkClosedAt.setText("Проверка совершен");
                    boardingClosedAt.setText("Залезть на");
                    sector.setText("Сектор");

                    terminalNum.setText(tabloDataRu.getTerminal());
                    reysName.setText(tabloDataRu.getDestination());
                    logo.setImage(tabloDataRu.getImage());
                    line.setText(tabloDataRu.getFlight());
                    departureTime.setText(tabloDataRu.getTime());
                    checkClosedAtTime.setText(tabloDataRu.getCheckInClosed());
                    boardingClosedAtTime.setText(tabloDataRu.getBoardingClosed());
                    sectorName.setText(tabloDataRu.getType());


                } else if (cnt == 2) {

                    reg.setText("werty hvyv");
                    reys.setText("shbhs sshd sh");
                    departure.setText("Departure");
                    checkClosedAt.setText("Check-in closed at");
                    boardingClosedAt.setText("Boarding closed at");
                    sector.setText("Sector");

                    terminalNum.setText(tabloDataEn.getTerminal());
                    reysName.setText(tabloDataEn.getDestination());
                    logo.setImage(tabloDataRu.getImage());
                    line.setText(tabloDataRu.getFlight());
                    departureTime.setText(tabloDataEn.getTime());
                    checkClosedAtTime.setText(tabloDataEn.getCheckInClosed());
                    boardingClosedAtTime.setText(tabloDataEn.getBoardingClosed());
                    sectorName.setText(tabloDataEn.getType());

                } else if (cnt == 3) {

                    reg.setText("Ro`yhat yo`laki");
                    reys.setText("Yo`nalish");
                    departure.setText("Ketish");
                    checkClosedAt.setText("Nazoratni tugashi");
                    boardingClosedAt.setText("Chiqish tugashi");
                    sector.setText("Sektor");

                    terminalNum.setText(tabloDataUz.getTerminal());
                    reysName.setText(tabloDataUz.getDestination());
                    logo.setImage(tabloDataUz.getImage());
                    line.setText(tabloDataUz.getFlight());
                    departureTime.setText(tabloDataUz.getTime());
                    checkClosedAtTime.setText(tabloDataUz.getCheckInClosed());
                    boardingClosedAtTime.setText(tabloDataUz.getBoardingClosed());
                    sectorName.setText(tabloDataUz.getType());
//                    Malumot Yangilash
                    cnt = 0;
                    tabloDataUz = new HttpRequests().getOne("departure/terminal/date=" + localDate, 1, terminal);
                    tabloDataRu = new HttpRequests().getOne("departure/terminal/date=" + localDate, 2, terminal);
                    tabloDataEn = new HttpRequests().getOne("departure/terminal/date=" + localDate, 3, terminal);
                }
                date.setText(localDate.format(DateTimeFormatter.ofPattern("MM.dd.yyyy")));
                time.setText(localTime.format(DateTimeFormatter.ofPattern("HH:mm")));

            }
        }));
        fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
        fiveSecondsWonder.play();
        date.setText(localDate.format(DateTimeFormatter.ofPattern("MM.dd.yyyy")));
        time.setText(localTime.format(DateTimeFormatter.ofPattern("HH:mm")));

        tabloDataUz = new HttpRequests().getOne("departure/terminal/date=" + localDate, 1, terminal);
        tabloDataRu = new HttpRequests().getOne("departure/terminal/date=" + localDate, 2, terminal);
        tabloDataEn = new HttpRequests().getOne("departure/terminal/date=" + localDate, 3, terminal);


        reg.setText("Ro`yhat yo`laki");
        reys.setText("Yo`nalish");
        departure.setText("Ketish");
        checkClosedAt.setText("Nazoratni tugashi");
        boardingClosedAt.setText("Chiqish tugashi");
        sector.setText("Sektor");

        terminalNum.setText(tabloDataUz.getTerminal());
        reysName.setText(tabloDataUz.getDestination());
        logo.setImage(tabloDataUz.getImage());
        line.setText(tabloDataUz.getFlight());
        departureTime.setText(tabloDataUz.getTime());
        checkClosedAtTime.setText(tabloDataUz.getCheckInClosed());
        boardingClosedAtTime.setText(tabloDataUz.getBoardingClosed());
        sectorName.setText(tabloDataUz.getType());

    }
}
