package Admin_GUI;

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

import management.Benutzerverwaltung;
import modell.Benutzer;





public class TCPProducer extends Thread implements MessageListener {
	
	
	
		private ActiveMQConnectionFactory connectionFactory;
		private Connection connection;
		private Session session;
		private Destination subjectQueue;
		private Destination consumerSubject;
		private MessageConsumer consumer;
		private MessageProducer producer;
	
		
		//Konstruktor
		public TCPProducer() throws JMSException {
			
	        connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
	        connection = connectionFactory.createConnection();
	        connection.start();

	        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

	    
	    
	        consumerSubject = session.createQueue("tcpTasksQueue");
	        consumer = session.createConsumer(consumerSubject);
	        consumer.setMessageListener(this);
	        
	        subjectQueue = session.createQueue("tcpBenutzerQueue");
	        producer = session.createProducer(subjectQueue);
	        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	       
		}
		
		public static void main(String[] args) {
				
				try{
					new TCPProducer();
				}catch(JMSException e){
					e.printStackTrace();
				}

	}

	@Override
	public void onMessage(Message incomingMsg) {
		try{
			if(incomingMsg instanceof ObjectMessage) {
				System.out.println("The Message is delivered to the Server");
				ObjectMessage objectMsg = (ObjectMessage) incomingMsg;
				//Benutzer benutzer = (Benutzer) objectMsg.getObject();
				String ben = (String) objectMsg.getObject();
				
				String user[] = ben.split(";");
				
				System.out.println("Recieved Username" + user[0]+ "with" + user[1]+" tha's all folks");
				
				Benutzerverwaltung benVer = Benutzerverwaltung.getInstance();
				
				if(benVer.pruefeLogin(user[0], user[1])){
					System.out.println(" Wahrheit! ");
					 String text;
					 text = "true";
					 
					 TextMessage message = session.createTextMessage(text);
					 message.setJMSCorrelationID(incomingMsg.getJMSCorrelationID());
			           
			         producer.send(message);
			          
				}
				else{
					String text = ((TextMessage) incomingMsg).getText();
					 
					 System.out.println("User is registered " + text);
					 TextMessage message = session.createTextMessage(text);
					 message.setJMSCorrelationID(incomingMsg.getJMSCorrelationID());
					 producer.send(message); 
				}
					
			}else{
				String text = ((TextMessage) incomingMsg).getText();
				 
				 System.out.println("User is registered(incommingMessage) " + text);
				 TextMessage message = session.createTextMessage(text);
				 message.setJMSCorrelationID(incomingMsg.getJMSCorrelationID());
				 producer.send(message); 
			}
					
			}catch(JMSException e){
			e.printStackTrace();
		
	}

	}
}
