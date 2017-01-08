package webservice.rest;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.cxf.jaxrs.client.WebClient;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import management.Benutzerverwaltung;
/**
 * RootResource 
 * @author 
 *
 */

@Path("/user")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public class UserService implements MessageListener{
	
	private ConnectionFactory factory = null;
	private Connection connection = null;
	private Session session = null;
	private Destination destination = null;
	private Destination destination2 = null;
	private MessageProducer producer = null;
	private MessageConsumer consumer;
	XStream xstream = new XStream(new StaxDriver());
	Benutzerverwaltung benutzer = Benutzerverwaltung.getInstance();

	@GET
    @Path("/login/{username}/{password}")
    @Produces(MediaType.TEXT_PLAIN)
    public String einloggenText(@PathParam("username") String usern, @PathParam("password") String pwd) {
		if(benutzer.pruefeLogin(usern, pwd)==true){
			String response = "Willkommen   " + usern;
			try {
				factory = new ActiveMQConnectionFactory(
				ActiveMQConnection.DEFAULT_BROKER_URL);
				connection = factory.createConnection();
				connection.start();
				session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
				destination = session.createQueue("RestQueue");
				producer = session.createProducer(destination);
				
				destination2 = session.createQueue("RestConsumer");
				consumer = session.createConsumer(destination2);
		        consumer.setMessageListener(this);
				
				//convert Object to XML-based TextMessage by using xstream
				TextMessage message = session.createTextMessage(xstream.toXML(response));
				
				producer.send(message);
			
				return response;
				
				
			} catch (JMSException e) {
				e.printStackTrace();
			}
			
		}
		return "Bitte ueberpruefen Sie Benutzername und/oder Passwort";
		
	}
	
	@GET
    @Path("login/xml/{username}/{password}")
    @Produces(MediaType.TEXT_XML)
    public String einloggen(@PathParam("username") String usern, @PathParam("password") String pwd) {

		if(benutzer.pruefeLogin(usern, pwd)==true){    
			
		String response = "<title>" + "Willkommen " +  usern + "</title>";
		
		try {
			factory = new ActiveMQConnectionFactory(
			ActiveMQConnection.DEFAULT_BROKER_URL);
			connection = factory.createConnection();
			connection.start();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue("RestQueue");
			producer = session.createProducer(destination);
			
			//convert Object to XML-based TextMessage by using xstream
			TextMessage message = session.createTextMessage(xstream.toXML(response));
			
			producer.send(message);
			return response;
			
			
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}
		
	return "<title>"+ "Bitte ueberpruefen Sie Benutzername und/oder Passwort" +"</title>";
     
    }

	@Override
	public void onMessage(Message incomingMsg) {
		TextMessage textMessage = (TextMessage) incomingMsg;
		try{
			
			if(incomingMsg instanceof TextMessage) {
	           System.out.println("TextMessage bei OnMessage angekommen");
	           System.out.println("Customer> " + textMessage.getText());
	           String text = (String) textMessage.getText();
	          
	           String benutzer[]=text.split(";");
	           //einloggen(benutzer[0],benutzer[1]);
	           
	     
	        }  
	       
		}catch(JMSException ex){
			ex.printStackTrace();
		}
		
	}
}