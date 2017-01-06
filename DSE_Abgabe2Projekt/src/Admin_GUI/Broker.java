package Admin_GUI;

import org.apache.activemq.broker.*;



public class Broker {

	public static void main(String[] args) {
		
		
		try{
			BrokerService broker = new BrokerService();
			broker.setPersistent(false);
			broker.setUseJmx(false);
			broker.addConnector("tcp://localhost:61616");
			broker.start();
			
			while(true){
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
