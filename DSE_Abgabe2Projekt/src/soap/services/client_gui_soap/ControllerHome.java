package soap.services.client_gui_soap;


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
import webservice.soap.SoapClient;

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

    @FXML private Label gebottag;
    @FXML private TextField neuesGebot;
    @FXML private Button gotoBtn;

    @FXML private TableView tableview;

    Client cl;
    private String name;


    public void setUsername(String name) throws IOException {
        this.name = name;
        welcomeName.setText("Welcome " + name);

        List<String> columns = new ArrayList<String>();
        columns.add("Name");
        columns.add("Price");
        columns.add("ProduktID");

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

            clearSearch();

            SoapClient si = SoapClient.getInstance();

            client.soap.AlleServicesSEI as = si.getClient();

            List<client.soap.Produkt> pd = as.getProduktListe();

            if (searchrequest.equals("all")) {
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

            } else {
                List<client.soap.Produkt> pdselect = new ArrayList();

                for (int i = 0; i < pd.size(); i++) {
                    if (pd.get(i).getName().contains(searchrequest)) {
                        pdselect.add(pd.get(i));
                    }
                }
                if (pd.size() == 0 || pdselect.size() == 0){
                    searchError.setText("No Products found");
                    searchError.setTextFill(Color.web("#BF0000"));
                } else {
                    for (int i = 0; i < pd.size(); i++) {
                        ObservableList<String> row = FXCollections.observableArrayList();

                        String ppname = pdselect.get(i).getName();
                        double ppreis = pdselect.get(i).getAktuellesGebot();
                        String parsedprice = String.valueOf(ppreis);
                        String ppuuid = pdselect.get(i).getProduktID().toString();

                        row.addAll(ppname);
                        row.addAll(parsedprice);
                        row.addAll(ppuuid);
                        tableview.getItems().add(row);
                    }
                    tableview.setEditable(true);
                }
            }
        }
    }

    public void clearSearch(){
        ObservableList<Produkt>  alle;
        alle = tableview.getItems();
        System.out.println("So v? san in do:" + alle.size());
        if (alle.size() != 0) {
            tableview.getItems().clear();
        }
    }

    private Double aktgebot;
    private String produktId;

    public void printselection(){

        gebottag.setText("");
        aktgebot = null;
        produktId = null;

        ObservableList<String> selected;

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
            gebottag.setText("Mindestgebotot: " + parsedPrice);
            gebottag.setTextFill(Color.web("green"));
        }

    }

    public void doBet(){
        System.out.println("Client does Bet..");

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

                SoapClient si = SoapClient.getInstance();

                client.soap.AlleServicesSEI as = si.getClient();

                List<client.soap.Produkt> pd = as.getProduktListe();

                if(as.gebotAbgeben(name, newgebotparsed, produktId)){
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
