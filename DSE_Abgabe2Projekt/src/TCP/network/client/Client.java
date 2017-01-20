package TCP.network.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.DoubleSummaryStatistics;
import java.util.List;

import modell.*;

/**
 * Diese Klasse stellt alle Funktionalit�ten dar, welche ein Clientprogramm braucht(bei uns)
 * Mithilfe dieser Klasse, kann vom GUI auf den Server zugegriffen werden
*/
public class Client {

	private Socket toSocket;
	private OutputStream rawOut;
	private DataOutputStream out;
	
	private InputStream rawIn;
	private DataInputStream dataIn;
	private ObjectInputStream objIn;
	
	/**
	 * Der Basiskonstruktor baut eine Verbindung auf dem Port 1234 auf
	 */
	public Client(){
		this(1234);
	}
	/**
	 * Mit diesem Konstruktor kann auf einen bestimmten Serverport eines Client zugegriffen werden
	 * @param port Der zu ben�tzende Port des Client
	 */
	public Client(int port){
		this(port,"localhost");
	}
	/**
	 * Mit diesem Konstruktor kann auf einen bestimmten Serverport eines Client zugegriffen werden 
	 * und auch noch die Serverlokation eingegeben werden
	 * @param port Der zu ben�tzende Port des Client
	 * @param host Der bestimmte Server, mit welchem kommuniziert werden soll
	 */
	public Client(int port, String host){
		try {
			this.toSocket = new Socket(host, port);
			
			this.rawOut = toSocket.getOutputStream();
			this.out = new DataOutputStream(rawOut);
			
			this.rawIn = toSocket.getInputStream();
			this.objIn = new ObjectInputStream(rawIn);
			this.dataIn = new DataInputStream(rawIn);
		} catch (UnknownHostException e) {
			System.err.println("SimpleClient:UnkownHost("+e.getMessage()+")!");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("SimpleClient:IOException("+e.getMessage()+")!");
			System.exit(1);
		}
		
		
	}
	
	/**
	 * Mit dieser Methode wird die Verbindung mit einem Server korrekt beendet
	 * (Dem Server wird gesagt, dass er die Verbindung abbauen kann)
	 */
	public void beenden(){
		try {
			out.writeUTF("ende");
		} catch (IOException e) {
			System.err.println("SimpleClient:beenden: Fehler beim beenden("+e.getMessage()+")");
		}
	}
	
	/**
	 * Diese Methode prueft eine username/passwort Kombinatin, indem er diese Parameter an den 
	 * Server schickt. Je nachdem bekommt man dann vom Server ein true oder false zurueck, 
	 * welches dann auch zurueckgegeben wird
	 * @param username Der zu pruefende Username
	 * @param password Das zu pruefende Passwort
	 * @return Falls korrekt true, sonst false
	 */
	public boolean pruefeLogin(String username, String password){
		try{
			this.getOut().writeUTF("pruefeLogin-"+username+"-"+password);
			return (boolean)this.dataIn.readBoolean();
			
		}catch(IOException e){
			System.err.println("SimpleClient:pruefeLogin: "+e.getMessage());
			return false;
		}
	}

	public boolean pruefeRegister(String username, String password, String email){
		try{
			this.getOut().writeUTF("pruefeRegister-"+username+"-"+password+"-"+email);
			return (boolean)this.dataIn.readBoolean();

		}catch(IOException e){
			System.err.println("SimpleClient:pruefeRegister: "+e.getMessage());
			return false;
		}
	}

	public boolean addProdukt(String name, String category, Double price, String description, String username){
		try{
			this.getOut().writeUTF("neuesProdukt-"+name+"-"+category+"-"+price+"-"+description+"-"+username);
			return (boolean)this.dataIn.readBoolean();

		}catch(IOException e){
			System.err.println("SimpleClient:pruefeRegister: "+e.getMessage());
			return false;
		}
	}



	
	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Benutzer> getBenutzerListe(){
		try {
			this.getOut().writeUTF("getBenutzer");
			return (List<Benutzer>)this.getobjIn().readObject();
		} catch (IOException e) {
			System.err.println("SimpleClient:getPersonenListe: "+e.getMessage());
			return null;
		} catch (ClassNotFoundException e) {
			System.err.println("SimpleClient:getPersonenListe: "+e.getMessage());
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Produkt> getProduktListe(){
		try {
			this.getOut().writeUTF("getProdukte");
			return (List<Produkt>)this.getobjIn().readObject();
		} catch (IOException e) {
			System.err.println("SimpleClient:getProduktListe: "+e.getMessage());
			return null;
		} catch (ClassNotFoundException e) {
			System.err.println("SimpleClient:getProduktListe: "+e.getMessage());
			return null;
		}
	}
	
	
	
	
	public DataOutputStream getOut() {
		return out;
	}
	public ObjectInputStream getobjIn() {
		return objIn;
	}
	public DataInputStream getDataIn() {
		return dataIn;
	}

}
