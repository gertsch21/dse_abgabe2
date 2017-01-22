package TCP.network.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import management.Auktionsverwaltung;
import management.Benutzerverwaltung;
import exceptions.ServerException;
import management.Produktverwaltung;
import messenger.Broker;

/**
 * 
 * Diese Klasse stellt den eigentlichen Serverprozess dar. Mittels der Generalisierungsbeziehung
 * von Thread wird die Nebenlï¿½ufigkeit ermï¿½glicht.
 *
 */
public class Server extends Thread implements MessageListener {
	// ActiveMQ Consumer/Producer
	private ActiveMQConnectionFactory connectionFactory;
	private Connection connection;
	private Session session;
	private Destination subjectQueue;
	private Destination consumerSubject;
	private MessageConsumer consumer;
	private MessageProducer producer;
	private Broker br = new Broker();
	// ActiveMQ Consumer/Producer
	
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
	 * Diese Methode ist genau fï¿½r jeweils eine Anfrage zustï¿½ndig und verarbeitet die (ï¿½bers 
	 * Netzwerk) einkommenden Operationen(mittels Stringvergleich wird dann das jeweilige 
	 * Objekt zurï¿½ck ï¿½bertragen)
	 */
	
	public void messaging()throws JMSException{
		
	try{	
		// Create the connection
        connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
        connection = connectionFactory.createConnection();
        connection.start();
        
     // Create the session
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        consumerSubject = session.createQueue("tcpTasksQueue");
        
        // Create the Consumer
        consumer = session.createConsumer(consumerSubject);
        consumer.setMessageListener(this);
        
        subjectQueue = session.createQueue("ServerQueue");
        producer = session.createProducer(subjectQueue);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        //Message sending
        TextMessage message = session.createTextMessage("Hallo Bitte Listen aktuallisieren");
        System.out.println("[" + this.getName() + "] Sending Message "+ message.getText());
        producer.send(message);
        
	} catch (Exception e) {
			System.out.println("[" + this.getName() +"] Caught: " + e);
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (Throwable ignore) {
		}
	}
       
}
	
	void messageSenden() throws JMSException{
		
		subjectQueue = session.createQueue("ServerQueue");
        producer = session.createProducer(subjectQueue);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
		TextMessage message = session.createTextMessage("Hallo Bitte Listen aktuallisieren");
        System.out.println("[" + this.getName() + "] Sending Message "+ message.getText());
        producer.send(message);
	}
	

	public void run() {
		System.out.println("Neuer Thread erfolgreich gestartet(fï¿½r IP-Adresse: "+this.clientSocket.getInetAddress()+")!");

		try {
		//anlegen der Streams(out und dann in)
			rawOut = this.clientSocket.getOutputStream();
			outObj = new ObjectOutputStream(rawOut);
			outData = new DataOutputStream(rawOut);
			rawIn = this.clientSocket.getInputStream();
			inData = new DataInputStream(rawIn);
			messaging();
			
			String eingabe;
			try{
				while((eingabe = inData.readUTF())!=null && !eingabe.equals("ende")){
					String[] eingabeGesplittet = eingabe.trim().split("-");
					String anfrage = eingabeGesplittet[0];
					messaging();
					//br.message();
					System.out.println("Befehl von Client("+this.clientSocket.getInetAddress()+"): "+anfrage);
					if (anfrage.equals("ende")){
						System.out.println("Client("+this.clientSocket.getInetAddress()+") beendete Verbindung mittels Eingabe 'ende'");
						break;
					}
		
					
					if (anfrage.equals("getBenutzer")){
						outObj.writeObject(benver.getBenutzerListe());
						continue;
					}
					
					
					//Loginprï¿½fung
					if (anfrage.equals("pruefeLogin")) {
						try{
							String username = eingabeGesplittet[1];
							String password = eingabeGesplittet[2];
							if(username == null || password == null) throw  new ServerException("Register: Ein Parameter ist null");


							if(!benver.pruefeLogin(username, password)) throw new ServerException("Userdaten stimmen nicht mit Passwortdaten ï¿½berein("+username+"/"+password+")");
							outData.writeBoolean(true);
						}catch(ServerException e){
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
							if(username == null || password == null || email == null) throw  new ServerException("Register: Ein Parameter ist null");
							
							//if (!benver.benutzerAnlegen(username,"Secondname",email,123,"Street","Ort",4,username,password)) throw new ServerException("Register fehlgeschlagen ("+username+"/"+password+"/"+email+")");
							messaging();
							br.message();
							
							outData.writeBoolean(true);
						} catch(ServerException e){
						System.err.println("Server:pruefeRegister:"+e.getMessage());
						outData.writeBoolean(false);
						}
					}

					if (anfrage.equals("neuesProdukt")) {
						try {
							String name = eingabeGesplittet[1];
							String category = eingabeGesplittet[2];
							String price = eingabeGesplittet[3];
							Double pprice = Double.parseDouble(price);

							String description = eingabeGesplittet[4];
							String username = eingabeGesplittet[5];

							Produktverwaltung prodver = Produktverwaltung.getinstance();

							if (name == null || category == null || pprice == null || description == null)
								throw new ServerException("Register: Ein Parameter ist null");


							System.out.println("Server:neuesProdukt: " + name + " - " + pprice + " - " + username + " - " + category + " - " +  description);


							//if (!prodver.produktAnlegen(name,pprice,username,category,10,description)) throw new ServerException("Add Produkt fehlgeschlagen ("+username+"/"+name+"/"+category+")");
							outData.writeBoolean(true);
							messageSenden();
							br.message();
						} catch (ServerException e) {
							System.err.println("Server:neuesProdukt:" + e.getMessage());
							outData.writeBoolean(false);
						}
					}
				
					//Get benutzer nach Usernamen
					if(anfrage.equals("getBenutzerByUname")){
						System.out.println("Client("+this.clientSocket.getInetAddress()+"): "+anfrage+", Uname: "+eingabeGesplittet[1]);
						outObj.writeObject(benver.getPersonByUsername(eingabeGesplittet[1]));
						continue;
					}

					if (anfrage.equals("getProdukte")){
						System.out.println("Server:getProdukte: #########");
						Produktverwaltung prodver = Produktverwaltung.getinstance();
						outObj.writeObject(prodver.getProduktListe());
						continue;
					}

					if (anfrage.equals(("bieteProdukt"))){


						System.out.println("Server:: bieteProdukt");
						String username = eingabeGesplittet[1];
						String gebot = eingabeGesplittet[2];
						Double gebotparsed = Double.parseDouble(gebot);
						String produktID = eingabeGesplittet[3];

						String merge = eingabeGesplittet[3]+"-"+eingabeGesplittet[4]+"-"+eingabeGesplittet[5]+"-"+eingabeGesplittet[6]+"-"+eingabeGesplittet[7];

						System.out.println("Server: " + merge);

						if (username == null || gebotparsed == null || produktID == null)
							throw new ServerException("biete: Ein Parameter ist null");

						Auktionsverwaltung av = Auktionsverwaltung.getInstance();

						if (!av.gebotAbgeben(username, gebotparsed, merge)) throw new ServerException("Neues Gebot fehlgeschlagen ("+username+"/"+produktID+"/"+gebotparsed+")");
						messaging();
						br.message();
						outData.writeBoolean(true);
					}




				}
			}catch(Exception e){
				//Da Port geschlossen wird, wï¿½hrend er noch abhï¿½rt, wird eine Exception geworfen, welche hiermit abgefangen wird
			}

			System.out.println("Server: Beende Connection mit Client("+this.clientSocket.getInetAddress()+")");
			outObj.flush();
			outObj.close();
			outData.close();
			rawOut.close();

			//inObj.close();
			rawIn.close();
		}catch(IOException | JMSException e)
		{
			System.err.println("Server:run: bei Client("+this.clientSocket.getInetAddress()+") " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public void onMessage(Message incomingMsg) {
		System.out.println("Bin im Incoming Message");
	if(incomingMsg instanceof TextMessage) {
		TextMessage txtMsg =(TextMessage) incomingMsg;
		try {
			System.out.println("[" + this.getName() +"] Received: '“" + txtMsg.getText() + "");
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(update()){
			System.out.println("Alles Upgedates TCP bin fertig");
		}
		
		}
	}

	
		public boolean update(){
			Produktverwaltung prodver = Produktverwaltung.getinstance();
			benver.getBenutzerListe();
			benver.getPersonenListe();
			prodver.getProduktListe();
							
			return true;
		}
	

}
