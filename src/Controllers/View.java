package Controllers;

import DB.DataBase;
import Model.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class View {
    public TableView tblItem;
    public TableColumn colItemId;
    public TableColumn colName;
    public TableColumn colQty;
    public TableColumn colPrice;
    public TableColumn colDescription;
    public Button btnReload;

    public void btnReloadaction(ActionEvent event) {
        ObservableList<Item> object= FXCollections.observableArrayList();

        colItemId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));

        DataBase.getInstance().getItemList().forEach(obj->{
              object.add(obj);
        });
        System.out.println(DataBase.getInstance().getItemList());

        tblItem.setItems(object);
    }
}
