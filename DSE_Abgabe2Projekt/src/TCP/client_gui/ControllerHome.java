package TCP.client_gui;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import TCP.network.client.Client;
import javafx.util.Callback;
import modell.Produkt;

import java.io.IOException;
import java.util.*;

/**
 * Created by josefweber on 29.10.16.
 */
public class ControllerHome {

    @FXML private Button logoutbtn;
    @FXML private Button addPBtn;
    @FXML private Label welcomeName;
    @FXML private TextField searchRequest;
    @FXML private Label searchError;

    // Bieten
    @FXML private Label gebottag;
    @FXML private TextField neuesGebot;
    @FXML private Button gotoBtn;

    // Bucky
    @FXML private TableView tableview;

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


            if (pd.size() == 0){

            } else {
                for (int i = 0; i < pd.size(); i++) {
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

    }

    private Double aktgebot;
    private String produktId;

    public void printselection(){

        aktgebot = null;
        produktId = null;

        ObservableList<String> selected, all;
        //all = tableview.getItems();
        selected = tableview.getSelectionModel().getSelectedItems();

        if (selected.size() == 0){
            gebottag.setText("No selection..");
        } else {

            String x1 = selected.toString();
            String[] parts = x1.split(",");

            parts[1].replaceAll("\\s+","");
            parts[2].replaceAll("\\s+","");
            Double parsedPrice = Double.parseDouble(parts[1]);
            aktgebot = parsedPrice;

            parsedPrice = parsedPrice + 5;
            // trim schneided whitespace vorn und hinten weg
            String pid = parts[2].replaceAll("]","").trim();

            produktId = pid;

            neuesGebot.setText(parts[1]);
            gebottag.setText("Gebot abgeben f?r: ");
            gebottag.setText(parts[0] + " ->min: " + parsedPrice);
            gebottag.setTextFill(Color.web("green"));
        }

    }

    public void doBet(){
        System.out.println("DO BET");

        if (aktgebot == null){
            gebottag.setText("Not possible without selection");
            gebottag.setTextFill(Color.web("#BF0000"));
        } else {

            String newgebot = neuesGebot.getText();
            Double newgebotparsed = Double.parseDouble(newgebot);

            if (newgebotparsed <= aktgebot + 5) {
                gebottag.setText("Bet is too small");
                gebottag.setTextFill(Color.web("#BF0000"));
            } else {

                if(cl.bieteProdukt(name,produktId,newgebotparsed)){
                    gebottag.setText("Bet was successful");
                    gebottag.setTextFill(Color.web("green"));
                } else {
                    gebottag.setText("Bet was not successful");
                    gebottag.setTextFill(Color.web("red"));
                }


            }

        }

    }

}
