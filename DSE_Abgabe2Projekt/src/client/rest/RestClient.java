package client.rest;

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

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.cxf.jaxrs.client.WebClient;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;


public class RestClient implements ClientInterface, MessageListener{

	
		private ConnectionFactory factory = null;
		private Connection connection = null;
		private Session session = null;
		private Destination destination = null;
		private Destination destination2 = null;
		private MessageProducer producer = null;
		private MessageConsumer consumer;
		private Boolean kontrolle;
		XStream xstream = new XStream(new StaxDriver());
	
		static final String REST_URI = "http://localhost:9999/";
	    static final String USER_PATH = "user/login";
	    static final String USER_PATHXML = "user/login/xml";
	    String s;
	   
		    @Override
			public boolean pruefeLoginXml(String usern, String pwd) {
		    	
		    	WebClient loginClient = WebClient.create(REST_URI);
		        loginClient.path(USER_PATHXML).path(usern + "/" + pwd).accept("text/xml");
		        s=usern+";"+pwd;
		        //s = loginClient.get(String.class);

		    	try {
					factory = new ActiveMQConnectionFactory(
					ActiveMQConnection.DEFAULT_BROKER_URL);
					connection = factory.createConnection();
					connection.start();
					session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
					destination = session.createQueue("RestConsumer");
					
					producer = session.createProducer(destination);
					
					destination2 = session.createQueue("RestQueue");
					
					consumer = session.createConsumer(destination2);
			        consumer.setMessageListener(this);
					
					//convert Object to XML-based TextMessage by using xstream
					TextMessage message = session.createTextMessage(xstream.toXML(s));
					
					producer.send(message);
					System.out.println("Messae sollte ab hier weg sein ALLASOASD");
					if(kontrolle)return false;
					return true;
					
					
				} catch (JMSException e) {
					e.printStackTrace();
				}
		    	
				if(s.equals("Bitte ueberpruefen Sie Benutzername und/oder Passwort")){
					System.out.println(usern + " 1-");
					return false;
				} else {
					System.out.println(usern + " 2-");
					return true;
				}
			    
				
				
			}

			@Override
			public boolean pruefeLoginPlain(String usern, String pwd) {
				WebClient loginClient = WebClient.create(REST_URI);
				loginClient.path(USER_PATH).path(usern + "/" + pwd).accept("text/plain");
				s = loginClient.get(String.class);
				
				
				try {
					factory = new ActiveMQConnectionFactory(
					ActiveMQConnection.DEFAULT_BROKER_URL);
					connection = factory.createConnection();
					connection.start();
					session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
					destination = session.createQueue("RestConsumer");
					
					producer = session.createProducer(destination);
					
					destination2 = session.createQueue("RestQueue");
					
					consumer = session.createConsumer(destination2);
			        consumer.setMessageListener(this);
					
					//convert Object to XML-based TextMessage by using xstream
					TextMessage message = session.createTextMessage(xstream.toXML(s));
					
					producer.send(message);


				if(s.equals("Bitte ueberpruefen Sie Benutzername und/oder Passwort")){
					System.out.println(usern + " 1");
					return false;
				} else {
					System.out.println(usern + " 2");
					return true;
				} 
				}catch (JMSException e) {
					e.printStackTrace();
				}
				return kontrolle;
				

				
			}

			@Override
			public void onMessage(Message incomingMsg) {
				TextMessage textMessage = (TextMessage) incomingMsg;
				try{
					
					if(incomingMsg instanceof TextMessage) {
			           System.out.println("TextMessage bei OnMessage angekommen");
			 
			          String text = (String) textMessage.getText();
			          check(text);
			        } else {
			            
			        }
				}catch(JMSException ex){
					ex.printStackTrace();
				}
				
			}

	public boolean check(String text){
		if(text.contains("Willkommen")){
			return true;
			
		}
		return false;
	}

}

        
    
