package view;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import modells.TableData;


/**
 * Created by Loving on 19.12.2018.
 */
public class CalBackCellStyle {


        private TableColumn<TableData,String> tableColumn;


        public void setTableColumn(TableColumn<TableData, String> tableColumn) {
            this.tableColumn = tableColumn;
            this.start();
        }

        private void start()
        {
           tableColumn.setCellFactory(new Callback<TableColumn<TableData, String>, TableCell<TableData, String>>() {
               @Override
               public TableCell<TableData, String> call(final TableColumn<TableData, String> param) {
                   return new TableCell<TableData, String>(){
                       @Override
                       protected void updateItem(String item, boolean empty) {
                            if(!empty)
                            {
                                int index = indexProperty().getValue() < 0 ? 0 : indexProperty().getValue();
                                String s = param.getTableView().getItems().get(index).getStatus();
                                s =  s.toLowerCase();
                                if(s.contains("по расписанию") || s.contains("jadval asosida") || s.contains("schedule")){
                                    setStyle("-fx-text-fill: rgb(116,219,127);-fx-effect: dropshadow(three-pass-box, derive(darkgreen, -20%), 10, 0, 4, 4)");
                                }
                                else if(s.contains("ожидается") || s.contains("kutilmoqda") || s.contains("expected")){
                                    setStyle("-fx-text-fill: orange;-fx-effect: dropshadow(three-pass-box, derive(darkorange, -20%), 10, 0, 4, 4)");
                                }
                                else if(s.contains("прибил") || s.contains("kelish") || s.contains("arrive")){
                                    setStyle("-fx-text-fill: rgb(207,234,254);-fx-effect: dropshadow(three-pass-box, derive(cadetblue, -20%), 10, 0, 4, 4)");
                                }
                                else if(s.contains("отменён") || s.contains("qoldirildi") || s.contains("cancel")){
                                    setStyle("-fx-text-fill: red;-fx-effect: dropshadow(three-pass-box, derive(brown, -20%), 10, 0, 4, 4)");
                                }
                                else{
                                    setStyle("-fx-text-fill: rgb(207,234,254);-fx-effect: dropshadow(three-pass-box, derive(cadetblue, -20%), 10, 0, 4, 4)");
                                }
                                setText(s);
                            }

                       }
                   };
               }
           });
        }


    }

