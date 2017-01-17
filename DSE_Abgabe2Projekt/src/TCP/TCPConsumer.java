package TCP;

import javax.jms.MessageListener;

import java.util.Random;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class TCPConsumer extends Thread implements MessageListener{
	
	private ActiveMQConnectionFactory connectionFactory;
	private Connection connection;
	private Session session;
	private Destination subjectQueue;
	private Destination consumerQueue;
	private MessageProducer producer;
	private MessageConsumer consumer;
	private String uname;
	private String pwort;
	private String kontrolle;
	
	
	public TCPConsumer(String uname, String pwort) throws JMSException {
		this.uname=uname;
		this.pwort=pwort;
		System.out.println("halllooooooo");
		
			connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);

	        connection = connectionFactory.createConnection();
	        connection.start();

	        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

	        subjectQueue = session.createQueue("tcpTasksQueue");
	        consumerQueue = session.createQueue("tcpBenutzerQueue");

	        producer = session.createProducer(subjectQueue);
	        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
	        
	        consumer = session.createConsumer(consumerQueue);
	        consumer.setMessageListener(this);
	        sendMessages();
	}
	
	
	public void sendMessages() throws JMSException {
		System.out.println("# The customers send username & passwort ");
		int x=0;
		Random rand = new Random();
		
		for( int i =0; i < 5 ; i++){
			 x = rand.nextInt(10);
		}
		System.out.println("correlationID "+ x);
		
		String ben = uname+";"+pwort;
		
		
		
		System.out.println("DAs ist der USername  " + ben);
		ObjectMessage message = session.createObjectMessage(ben); 
		message.setJMSCorrelationID(Integer.toString(x));
		producer.send(message);	
			
			
			
		}

	
	@Override
	public void onMessage(Message incomingMsg) {
	    TextMessage textMessage = (TextMessage) incomingMsg;
		try{
			if(incomingMsg instanceof TextMessage) {
	           System.out.println("# The customers get notified about the status of the order");
	           System.out.println("Customer> " + textMessage.getText());
	           kontrolle = (String) textMessage.getText();
	           setKontrolle(kontrolle);
	           
	        } else {
	            
	        }
		}catch(JMSException ex){
			ex.printStackTrace();
		}
		
	}
	
	public String getKontrolle() {
		return kontrolle;
	}


	public void setKontrolle(String kontrolle) {
		this.kontrolle = kontrolle;
	}


	public boolean MessageConsumer(){
		boolean test = false;
	    test = Boolean.valueOf(kontrolle);
	    return test;
	}

}
