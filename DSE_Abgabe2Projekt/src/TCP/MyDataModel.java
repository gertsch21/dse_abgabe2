package TCP;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by josefweber on 20.01.17.
 */
public class MyDataModel {
    private final SimpleStringProperty idColumnProperty = new SimpleStringProperty("");

    public MyDataModel(){
        this("");
    }

    public MyDataModel(String id){
        setIdColumn(id);
    }



    public void setIdColumn(String id){
        idColumnProperty.set(id);
    }
}
