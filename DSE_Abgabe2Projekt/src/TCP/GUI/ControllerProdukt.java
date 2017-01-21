package TCP.GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import modell.Benutzer;

import java.io.IOException;
import java.util.List;

/**
 * Created by josefweber on 19.01.17.
 */
public class ControllerProdukt {

    @FXML private Button backHomeBtn;

    @FXML private TextField pname;
    @FXML private TextField pcategory;
    @FXML private TextField pprice;
    @FXML private TextField pdetail;

    @FXML private Label err1;
    @FXML private Label err2;
    @FXML private Label err3;
    @FXML private Label err4;
    @FXML private Label errMain;


    TCP.network.client.Client cl;
    private String name;

    public void setUsername(String name){
        this.name = name;
        errMain.setText("The User: " + name + " wants to add a new product..");
        errMain.setTextFill(Color.web("green"));
    }
    public void setCl(TCP.network.client.Client cl) {
        this.cl = cl;
    }


    @FXML
    void addnewproduct(){

        //System.out.println("addnewProdukt: " + name + name );

        String productname = pname.getText();
        String category = pcategory.getText();
        String price = pprice.getText();
        String detail= pdetail.getText();

        errMain.setTextFill(Color.web("#999"));

        if (productname.length() == 0){
            err1.setText("!");
            System.out.println("Name = 0");
        } else {
            err1.setText("");
        }
        if (category.length() == 0){
            err2.setText("!");
            System.out.println("Mail = 0");
        }
        else {
            err2.setText("");
        }
        if (price.length() == 0){
            err3.setText("!");
            System.out.println("Pw = 0");
        }  else {
            err3.setText("");
        }
        double parsedPrice = 0;
        try {
            parsedPrice = Double.parseDouble(price);
        } catch(NumberFormatException e)
        {
            System.out.println("GUI controllerProdukt: Price is not a Double");
            errMain.setText("Price is not a Double!");
        }


        if(productname.length() == 0 || category.length() == 0 || parsedPrice == 0){
            errMain.setText("Fill in all the Fields!");
        }  else {
            errMain.setText(name + " " + category + " " + parsedPrice + " " + detail + " .");

            System.out.println("GUI controllerProdukt: the user: " + name + "wants to add a new Product");

            if (cl.addProdukt(productname,category,parsedPrice,detail,name)){
                errMain.setText("Success");
                errMain.setTextFill(Color.web("green"));
            } else {
                errMain.setText("Failed adding a new Product");
                errMain.setTextFill(Color.web("#BF0000"));
            }
        }


    }

    public void clickHomeBack() throws IOException {
        System.out.println("Home Button was clicked..");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home.fxml"));
        Parent root = fxmlLoader.load();


        ControllerHome ch = fxmlLoader.<ControllerHome>getController();
        System.out.println(name + name + name + " --- - - - - - -");
        ch.setUsername(name);
        ch.setCl(cl);

        Scene scene = new Scene(root);
        Stage homeStage = (Stage) backHomeBtn.getScene().getWindow();

        homeStage.setScene(scene);
        homeStage.show();



        /*
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene home = new Scene(root);
        Stage homeStage = (Stage) backHomeBtn.getScene().getWindow();
        homeStage.setScene(home);
        homeStage.show();
        */
    }



}
