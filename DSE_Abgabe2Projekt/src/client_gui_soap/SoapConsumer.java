package client_gui_soap;



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

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class SoapConsumer implements MessageListener {
	
	private ActiveMQConnectionFactory connectionFactory;
	private Connection connection;
	private Session session;
	private Destination subjectQueue;
	private Destination consumerQueue;
	private XStream xstream;
	private MessageProducer producer;
	private MessageConsumer consumer;
	private StaxDriver dr;
	 String username;
     String passwort;
     
     
	public SoapConsumer() throws JMSException {
		
	 connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
	 connection = connectionFactory.createConnection();
	 connection.start();

     session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
     subjectQueue = session.createQueue("SOAPTasksQueue");
     xstream =   new XStream(dr);
     
     producer = session.createProducer(subjectQueue);
     producer.setDeliveryMode(DeliveryMode.PERSISTENT);
     
     consumer = session.createConsumer(consumerQueue);
     consumer.setMessageListener(this);
     
      username = "gertsch";
      passwort = "hallo";
     
     String objekt = username + ";" + passwort;
     System.out.println(" This is the object" + objekt);
     //sending message
 	   ObjectMessage message = session.createObjectMessage(objekt);
     //TextMessage message = session.createTextMessage(xstream.toXML(objekt));
      
		message.setJMSCorrelationID(Integer.toString(1));
		producer.send(message);	
		 
       
   
	 
	
	}
	
	
	@Override
	public void onMessage(Message arg0) {
		
		
		
	}

	public static void main(String[] args) {
		try {
			new SoapConsumer();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	

}
