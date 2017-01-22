package soap.services.client_gui_soap;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import webservice.soap.SoapClient;

import java.io.IOException;
import java.net.Socket;

public class ControllerLogin {

    @FXML private Button loginbtn;
    @FXML private Button registerloginBtn;
    @FXML private TextField unameinput;
    @FXML private TextField pwinput;
    @FXML private Label loginerror;
    @FXML private Label serverstatus;

    private SoapClient scl;

    public void loginClicked() throws IOException {
        String name = unameinput.getText();
        String pass = pwinput.getText();

        if (name.length() == 0 || pass.length() == 0){
            //System.out.println("No valid Data");
            loginerror.setText("Insert all fields");
        } else {
            System.out.println("Login attempt: " + unameinput.getText() + " , " + pwinput.getText().toString());

            if (available(9000)) {

                SoapClient si = SoapClient.getInstance();

                client.soap.AlleServicesSEI as = si.getClient();

                boolean x = as.pruefeLogin(name,pass);

                if (x) {

                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home.fxml"));
                    Parent root = fxmlLoader.load();


                    ControllerHome ch = fxmlLoader.<ControllerHome>getController();
                    ch.setUsername(name);
                    //ch.setCl(sc);

                    Scene scene = new Scene(root);
                    Stage homeStage = (Stage) loginbtn.getScene().getWindow();

                    homeStage.setScene(scene);
                    homeStage.show();

                } else {
                    //System.out.println("login failed");
                    loginerror.setText("Login failed");
                    loginerror.setTextFill(Color.web("#BF0000"));
                }

            } else {
                //System.out.println("login failed");
                loginerror.setText("Login failed");
                loginerror.setTextFill(Color.web("#BF0000"));
            }
        }
    }

    

    public static boolean available(int port) {
        try (Socket ignored = new Socket("localhost", port)) {
            return true;
        } catch (IOException ignored) {
            return false;
        }

    }

    public void registerClicked() throws IOException {
        System.out.println("pressed Registration in Login..");

        Parent root = FXMLLoader.load(getClass().getResource("registration.fxml"));
        Scene regiScene = new Scene(root);
        Stage regiStage = (Stage) registerloginBtn.getScene().getWindow();
        regiStage.setScene(regiScene);
        regiStage.show();
    }

    public boolean checkClicked(){
        if (available(9000)){
            System.out.println("System: Online SOAP");
            serverstatus.setText("System: Online SOAP");
            serverstatus.setTextFill(Color.web("#168500"));
        } else {
            System.out.println("System: Offline SOAP");
            serverstatus.setText("System: Offline SOAP");
            serverstatus.setTextFill(Color.web("#BF0000"));
        }
        return false;
    }
}
