package TCP.GUI;

import TCP.MyDataModel;
import TCP.testprodukt;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import TCP.network.client.Client;
import javafx.util.Callback;
import modell.Produkt;

import java.io.IOException;
import java.util.*;

import static java.awt.SystemColor.window;

/**
 * Created by josefweber on 29.10.16.
 */
public class ControllerHome {

    @FXML private Button logoutbtn;
    @FXML private Button addPBtn;
    @FXML private Label welcomeName;
    @FXML private TextField searchRequest;
    @FXML private Label searchError;



    // Bucky
    @FXML private TableView tableview;

    public ObservableList<testprodukt> getProduct(){
        ObservableList<testprodukt> produkts = FXCollections.observableArrayList();

        produkts.add(new testprodukt("Produkt1",1));
        produkts.add(new testprodukt("Produkt2",2));
        produkts.add(new testprodukt("Produkt3",3));
        produkts.add(new testprodukt("Produkt4",4));
        return produkts;
    }
    // BUcky

    Client cl;
    private String name;


    public void setUsername(String name) throws IOException {
        this.name = name;
        welcomeName.setText("Welcome " + name);

        List<String> columns = new ArrayList<String>();
        columns.add("Name");
        columns.add("Price");
        columns.add("Owner");
        int columnIndex = 0;

        for(int i=0 ; i<3; i++) {

            final int j = i;
            TableColumn col = new TableColumn(columns.get(i));
            col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){

                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });
                tableview.getColumns().addAll(col);
        }
        // bis da hin





    }

    public void setCl(Client cl) {
        this.cl = cl;
    }

    public void logout() throws IOException {
        System.out.println("Logging Out..");

        System.out.println("Username: " + name);

       // cl.beenden();
        System.out.println("Verbindung beendet ..");

        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene home = new Scene(root);
        Stage homeStage = (Stage) logoutbtn.getScene().getWindow();
        homeStage.setScene(home);
        homeStage.show();
    }

    public void gotoprodukt() throws IOException {
        System.out.println("Go to Produkt Add..");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("produkt.fxml"));
        Parent root = fxmlLoader.load();


        ControllerProdukt ch = fxmlLoader.<ControllerProdukt>getController();
        System.out.println(name + name + name + " --- - - - - - -");
        ch.setUsername(name);
        ch.setCl(cl);

        Scene scene = new Scene(root);
        Stage homeStage = (Stage) addPBtn.getScene().getWindow();

        homeStage.setScene(scene);
        homeStage.show();
    }

    public void searchProdcts(){
        String searchrequest = searchRequest.getText();
        searchError.setText("");

        if (searchrequest.length() == 0){
            searchError.setText("Enter Value");
            searchError.setTextFill(Color.web("#BF0000"));
        } else {
            System.out.println("Home: " + searchrequest);
            searchError.setText("Request: " + searchrequest);

            List<Produkt> pd = cl.getProduktListe();
            /*
            Produkt p1 = pd.get(0);
            System.out.println(p1.getName());
            int i = 0;



            List<String> list = new ArrayList<String>();
            //list.add(1,"Test1");
            //list.add(2,"Test2");
            list.add("Teststring");
             */






            for (int i = 0; i<pd.size(); i++){
                ObservableList<String> row = FXCollections.observableArrayList();
                String ppname = pd.get(i).getName();
                double ppreis = pd.get(i).getAktuellesGebot();
                String parsedprice = String.valueOf(ppreis);

                String ppuuid = pd.get(i).getProduktID().toString();
                row.addAll(ppname);
                row.addAll(parsedprice);
                row.addAll(ppuuid);
                tableview.getItems().add(row);
            }
            tableview.setEditable(true);

        }

    }

    private List<MyDataModel> getItemsToAdd(){
        MyDataModel md1 = new MyDataModel("11");
        MyDataModel md2 = new MyDataModel("2");

        List<MyDataModel> md = new ArrayList<MyDataModel>();
        md.add(1,md1);
        md.add(2,md1);

        return md;
// this method would fetch the necessary items from database.
    }

}
