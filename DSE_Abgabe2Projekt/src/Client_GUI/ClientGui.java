package Client_GUI;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import network.client.Client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by josefweber on 28.10.16.
 */
public class ClientGui extends Application {
	boolean x = false;
    Stage window;

    public static void main(String[] args) {
       launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Default Stage
        window = primaryStage;
        window.setTitle("Client Controller");

        // Declare Buttons and Fields
        Label lblPassword = new Label("Password");
        final PasswordField passfield = new PasswordField();
        Label lblUserName = new Label("Username");
        final TextField txtUserName = new TextField();
        Button checkLogin = new Button("Login");
        Label loginError = new Label("<login error here>");
        

        // Grid for Login
        BorderPane bp = new BorderPane();
        GridPane gp = new GridPane();
        // Left, Top, Bottom, Right
        gp.setHgap(4);
        gp.setVgap(10);
        bp.setPadding(new Insets(50, 20, 20, 50));
        gp.add(lblUserName, 0, 0);
        gp.add(txtUserName, 1, 0);
        gp.add(lblPassword, 0, 2);
        gp.add(passfield, 1, 2);
        gp.add(checkLogin, 0, 3);
        gp.add(loginError, 0, 4);

        // Footer
        final Label serverStatus = new Label();
        Button connectionBtn = new Button("Check Connection");
        HBox hboxbottom = new HBox();
        hboxbottom.setPadding(new Insets(15, 12, 15, 12));
        hboxbottom.setSpacing(40);
        hboxbottom.getChildren().addAll(connectionBtn, serverStatus);
        bp.setBottom(hboxbottom);

        // Center
        bp.setCenter(gp);
        Scene login = new Scene(bp, 600, 350);
        window.setScene(login);

        // Scene Home
        BorderPane bphome = new BorderPane();
        Label homeTextArea = new Label();
        Button homeLogout = new Button("Logout");

        bphome.setCenter(homeTextArea);
        bphome.setRight(homeLogout);
        Scene home = new Scene(bphome, 900, 200);

        // Check Login
        checkLogin.setOnAction(e -> {
            String unameinput = txtUserName.getText().toString();
            String pwinput = passfield.getText().toString();

            if (unameinput.length() == 0 || pwinput.length() == 0){
                System.out.println("userdata empty");
            } else {
            	if(true){
            		TCPConsumer tcpC;
					try {
						tcpC = new TCPConsumer(unameinput,pwinput);
						 x = tcpC.MessageConsumer();
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
            		
               // if (available(1234)) {
                    //Client sc = new Client(1234, "localhost");
                   // boolean x = sc.pruefeLogin(unameinput, pwinput);
                    if (x) {
                        System.out.println("TRUE");
                        homeTextArea.setText("Welcome " + unameinput);
                        // Go to Home (Hardcoded)
                        //window.setScene(home);

                        // Go to Home (FXML Notation)
                        Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("home.fxml"));
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        Scene homeScene = new Scene(root);
                        Stage homeStage = (Stage) checkLogin.getScene().getWindow();
                        homeStage.setScene(homeScene);
                        homeStage.show();

                    } else {
                        System.out.println("FALSE");
                    }
                } else {
                    System.out.println("Server Offline..");
                }
            }
        });

        // Check Connection
        connectionBtn.setOnAction(e -> {
            if (available(1234)){
                System.out.println("System: Online");
                serverStatus.setText("System: Online");
                serverStatus.setTextFill(Color.web("#168500"));
            } else {
                System.out.println("System: Offline");
                serverStatus.setText("System: Offline");
                serverStatus.setTextFill(Color.web("#BF0000"));
            }
        });

        // Return to Login
        homeLogout.setOnAction(e -> {
            window.setScene(login);
        });

        window.show();
    }

    public static boolean available(int port) {
        try (Socket ignored = new Socket("localhost", port)) {
            return true;
        } catch (IOException ignored) {
            return false;
        }
    }

}
