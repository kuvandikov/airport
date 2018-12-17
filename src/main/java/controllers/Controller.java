package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import modells.TableData;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Loving on 14.12.2018.
 */
public class Controller implements Initializable {
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
        Vaqt.setCellValueFactory(new PropertyValueFactory<TableData, String>("time"));
        Rasm.setCellValueFactory(new PropertyValueFactory<TableData, ImageView>("imageView"));
        Reys.setCellValueFactory(new PropertyValueFactory<TableData, String>("flight"));
        Mashrut.setCellValueFactory(new PropertyValueFactory<TableData, String>("destination"));
       Status.setCellValueFactory(new PropertyValueFactory<TableData,String>("status"));
        ImageView imageView = new ImageView("img/uzairways_logo.jpg");

        list.add(new TableData("12:09", imageView, "TI 64", "Душанбе", "Atmena"));
        list.add(new TableData("12:09", imageView, "TI 64", "Душанбе", "Atmena"));
       tableView.getItems().addAll(list);
    }
}
