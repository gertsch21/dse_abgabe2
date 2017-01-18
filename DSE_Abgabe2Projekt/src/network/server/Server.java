package network.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import management.Benutzerverwaltung;
import management.MyException;

/**
 * 
 * Diese Klasse stellt den eigentlichen Serverprozess dar. Mittels der Generalisierungsbeziehung
 * von Thread wird die Nebenl�ufigkeit erm�glicht.
 *
 */
public class Server extends Thread {

	private static Benutzerverwaltung benver = Benutzerverwaltung.getInstance();
	
	
	private Socket clientSocket;

	private OutputStream rawOut;
	private ObjectOutputStream outObj;
	private DataOutputStream outData;

	private InputStream rawIn;
	private DataInputStream inData;

	/**
	 * Mithilfe dieses Konstruktors wird eine Clientanfrage an einen thread deligiert und dieser 
	 * auch gleich gestartet. 
	 * 
	 * @param clientsocket der Clientsocket der neuen Anfrage
	 */
	public Server(Socket clientsocket) {
		this.clientSocket = clientsocket;
		start();
	}

	/**
	 * Diese Methode Startet den Server und lauscht auf Anfragen, kommen welche herein, 
	 * dann wird ein neuer Thread gestartet
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(1234);
			System.out.println("Server gestartet(Port " + serverSocket.getLocalPort() + ")");
			try {
				while (true) {
					System.out.println("Server wartet auf eine neue Verbindung!");
					
					new Server(serverSocket.accept());
				}
			} catch (IOException e) {
				System.err.println("Server:main: Connetion Failed");
				System.exit(1);
			}

		} catch (IOException e) {
			System.err.println("Server:main: " + e.getMessage());
			System.exit(1);
		}
	}

	/**
	 * Diese Methode ist genau f�r jeweils eine Anfrage zust�ndig und verarbeitet die (�bers 
	 * Netzwerk) einkommenden Operationen(mittels Stringvergleich wird dann das jeweilige 
	 * Objekt zur�ck �bertragen)
	 */
	public void run() {
		System.out.println("Neuer Thread erfolgreich gestartet(f�r IP-Adresse: "+this.clientSocket.getInetAddress()+")!");

		try {
		//anlegen der Streams(out und dann in)
			rawOut = this.clientSocket.getOutputStream();
			outObj = new ObjectOutputStream(rawOut);
			outData = new DataOutputStream(rawOut);

			rawIn = this.clientSocket.getInputStream();
			inData = new DataInputStream(rawIn);

			
			String eingabe;
			try{
				while((eingabe = inData.readUTF())!=null && !eingabe.equals("ende")){
					String[] eingabeGesplittet = eingabe.trim().split("-");
					String anfrage = eingabeGesplittet[0];
		
					System.out.println("Befehl von Client("+this.clientSocket.getInetAddress()+"): "+anfrage);
					if (anfrage.equals("ende")){
						System.out.println("Client("+this.clientSocket.getInetAddress()+") beendete Verbindung mittels Eingabe 'ende'");
						break;
					}
		
					
					if (anfrage.equals("getBenutzer")){
						outObj.writeObject(benver.getBenutzerListe());
						continue;
					}
					
					
					//Loginpr�fung
					if (anfrage.equals("pruefeLogin")) {
						try{
							String username = eingabeGesplittet[1];
							String password = eingabeGesplittet[2];
							if(username == null || password == null) throw  new MyException("Register: Ein Parameter ist null");


							if(!benver.pruefeLogin(username, password)) throw new MyException("Userdaten stimmen nicht mit Passwortdaten �berein("+username+"/"+password+")");
							outData.writeBoolean(true);
						}catch(MyException e){
							System.err.println("Server:pruefeLogin:"+e.getMessage());
							outData.writeBoolean(false);
						}
						continue;
					}
					
					if (anfrage.equals("pruefeRegister")) {
						//System.out.println("TCP Server: 1 neue -pruefeRegister Anfrage");
						try {
							String username = eingabeGesplittet[1];
							String password = eingabeGesplittet[2];
							String email = eingabeGesplittet[3];
							if(username == null || password == null || email == null) throw  new MyException("Register: Ein Parameter ist null");

							if (!benver.benutzerAnlegen(username,"Secondname",email,123,"Street","Ort",4,username,password)) throw new MyException("Register fehlgeschlagen ("+username+"/"+password+"/"+email+")");
							outData.writeBoolean(true);
						} catch(MyException e){
						System.err.println("Server:pruefeRegister:"+e.getMessage());
						outData.writeBoolean(false);
					}

					}
				
					//Get benutzer nach Usernamen
					if(anfrage.equals("getBenutzerByUname")){
						System.out.println("Client("+this.clientSocket.getInetAddress()+"): "+anfrage+", Uname: "+eingabeGesplittet[1]);
						outObj.writeObject(benver.getPersonByUsername(eingabeGesplittet[1]));
						continue;
					}
				}
			}catch(Exception e){
				//Da Port geschlossen wird, w�hrend er noch abh�rt, wird eine Exception geworfen, welche hiermit abgefangen wird
			}

			System.out.println("Server: Beende Connection mit Client("+this.clientSocket.getInetAddress()+")");
			outObj.flush();
			outObj.close();
			outData.close();
			rawOut.close();

			//inObj.close();
			rawIn.close();
		}catch(IOException e)
		{
			System.err.println("Server:run: bei Client("+this.clientSocket.getInetAddress()+") " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
	}

}
