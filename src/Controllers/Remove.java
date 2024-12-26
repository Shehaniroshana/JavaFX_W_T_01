package Controllers;

import DB.DataBase;
import Model.Item;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Remove {
    public TextField txtSearchId;
    public Button btnRemove;
    public Button btnSearch;
    public TextField txtQty;
    public TextField txtname;
    public TextField txtPrice;
    public TextField txtDescription;
    private int id;

    public void btnRemoveAction(ActionEvent event) {
        if (id != -1) {
            DataBase.getInstance().getItemList().remove(id);
            resetFields();
        } else {
            showAlert(Alert.AlertType.WARNING, "Item Not Found", "No item found to remove.");
        }
    }

    public void btnsearchAction(ActionEvent event) {
        id = -1;
        boolean itemFound = false;

        for (Item obj : DataBase.getInstance().getItemList()) {
            if (obj.getId().equals(txtSearchId.getText())) {
                txtname.setText(obj.getItemName());
                txtQty.setText(String.valueOf(obj.getQty()));
                txtPrice.setText(String.valueOf(obj.getPrice()));
                txtDescription.setText(obj.getDescription());
                id = DataBase.getInstance().getItemList().indexOf(obj);
                itemFound = true;
                break;
            }
        }

        if (!itemFound) {
            showAlert(Alert.AlertType.WARNING, "Item Not Found", "The item with the given ID was not found.");
            resetFields();
        }
    }

    private void resetFields() {
        txtDescription.setText("");
        txtname.setText("");
        txtQty.setText("");
        txtPrice.setText("");
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
