package TCP.GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import TCP.network.client.Client;

import java.io.IOException;

/**
 * Created by josefweber on 29.10.16.
 */
public class ControllerHome {

    @FXML
    private Button logoutbtn;
    @FXML
    private Button addPBtn;

    @FXML private Label welcomeName;
    Client cl;
    private String name;

    public void setUsername(String name){
        this.name = name;
        welcomeName.setText("Welcome " + name);
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


}
