package DB;

import Model.Item;
import com.sun.javafx.scene.control.behavior.DateCellBehavior;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataBase {
    private List<Item> itemList;


    private DataBase(){
       itemList=new ArrayList<>();
    }

    private static DataBase dataBase;

    public static DataBase getInstance(){
        if(dataBase==null){
            return dataBase=new DataBase();
        }
        return dataBase;
    }
    public List<Item> getItemList(){
        return itemList;
    }
}
