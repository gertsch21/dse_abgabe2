package messenger;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Broker implements MessageListener, ExceptionListener{
	
	// ActiveMQ Consumer/Producer
		private ActiveMQConnectionFactory connectionFactory;
		private Connection connection;
		private Session session;
		private Destination subjectQueue;
		private Destination subjectQueue2;
		private Destination subjectQueue3;
		private Destination consumerSubject;
		private MessageConsumer consumer;
		private MessageProducer producer;
		private MessageProducer producer2;
		private MessageProducer producer3;
		// ActiveMQ Consumer/Producer
	
		
 public Broker(){}
 
 public void message()throws JMSException{
			
	try{	
		// Create the connection
        connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
        connection = connectionFactory.createConnection();
        connection.start();
        
     // Create the session
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        consumerSubject = session.createQueue("ServerQueue");
        
        // Create the Consumer
        consumer = session.createConsumer(consumerSubject);
        consumer.setMessageListener(this);
        
        subjectQueue = session.createQueue("tcpTasksQueue");
        producer = session.createProducer(subjectQueue);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        
        subjectQueue2 = session.createQueue("RESTTasksQueue");
        producer2 = session.createProducer(subjectQueue2);
        producer2.setDeliveryMode(DeliveryMode.PERSISTENT);
        
        subjectQueue3 = session.createQueue("SOAPTasksQueue");
        producer3 = session.createProducer(subjectQueue3);
        producer3.setDeliveryMode(DeliveryMode.PERSISTENT);
      //Message sending
        TextMessage message = session.createTextMessage("Hallo Bitte Listen aktuallisieren");
        System.out.println("[ Sending Message  an TCP"+ message.getText());
        producer.send(message);
        
        producer2.send(message);
        System.out.println("[  Sending Message  an REST"+ message.getText());
        producer3.send(message);
        System.out.println("[  Sending Message   an SOAP"+ message.getText());
        
        
        
	} catch (Exception e) {
			System.out.println("[   Caught: " + e);
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (Throwable ignore) {
		}
	}
 }
	
		@Override
		public void onMessage(Message incomingMsg) {
			
			if(incomingMsg instanceof TextMessage) {
				TextMessage txtMsg =(TextMessage) incomingMsg;
				if(txtMsg.equals("Hallo Bitte Listen aktuallisieren")){
				System.out.println("[ Received: '“ + txtMsg.getText() + ");
				try {
					//Message sending
			        TextMessage message = session.createTextMessage("Hallo Bitte Listen aktuallisieren");
			        System.out.println("[ Sending Message  an TCP"+ message.getText());
			        producer.send(message);
			        
			        producer2.send(message);
			        System.out.println("[  Sending Message  an REST"+ message.getText());
			        producer3.send(message);
			        System.out.println("[  Sending Message   an SOAP"+ message.getText());
			        
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					System.out.println("Alles Upgedates vom Server");
				}
			}
		}

		@Override
		public void onException(JMSException e) {
			System.out.println("[" + e + "] JMS Exception occured");
			
		}
			
       
    
   
 }
