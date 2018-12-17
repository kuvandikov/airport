package controllers;

import modells.TableData;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;

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
    TableColumn<TableData,Image> Image;
    @FXML
    TableColumn<TableData,String> Reys;
    @FXML
    TableColumn<TableData,String> Mashrut;
    @FXML
    TableColumn<TableData,String> Status;

    List<TableData> list=new ArrayList<TableData>();
    public void initialize(URL location, ResourceBundle resources) {
       Vaqt.setCellValueFactory(new PropertyValueFactory<TableData,String>("vremya"));
       Image.setCellValueFactory(new PropertyValueFactory<TableData,Image>("image"));
       Reys.setCellValueFactory(new PropertyValueFactory<TableData,String>("reys"));
       Mashrut.setCellValueFactory(new PropertyValueFactory<TableData,String>("mashrut"));
       Status.setCellValueFactory(new PropertyValueFactory<TableData,String>("status"));
       list.add(new TableData("12:09",null,"TI 64","Душанбе","Atmena"));
       list.add(new TableData("12:09",null,"TI 64","Душанбе","Atmena"));
       tableView.getItems().addAll(list);
    }
}
