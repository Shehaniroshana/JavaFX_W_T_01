package Controllers;

import DB.DataBase;
import Model.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Add {
    public Button btnAdd;
    public TextField txtQty;
    public TextField txtName;
    public TextField txtPrice;
    public TextField txtDescription;
    public Label lblOderId;
    public Button btnView;
    public Button btnRemove;
    private int idNumber=1;


    public void btnAddAction(ActionEvent event) {

        String id = lblOderId.getText();
        idNumber++;
        lblOderId.setText("#000"+idNumber);
        String name = txtName.getText();
        int qty=Integer.parseInt(txtQty.getText());
        double price=Double.parseDouble(txtPrice.getText());
        String description = txtDescription.getText();

       DataBase.getInstance().getItemList().add(new Item(id,name,qty,price,description));
        System.out.println(DataBase.getInstance().getItemList());
        resetFields();
    }

    public void btnViewAction(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/FXML/View.fxml"))));
        stage.setTitle("View");
        stage.show();
    }

    public void btnRemoveAction(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/FXML/Remove.fxml"))));
        stage.setTitle("Remove");
        stage.show();
    }
    private void resetFields() {
        txtDescription.setText("");
        txtName.setText("");
        txtQty.setText("");
        txtPrice.setText("");

    }
}
