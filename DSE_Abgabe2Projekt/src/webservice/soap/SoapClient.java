package webservice.soap;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import client.soap.*;

/**
 * Dabei handelt es sich um eine Klasse, mithilfe dessen man auf den Soapserver zugreifen kann
 * Es wird der gesamte Verbindungsaufbau hier gehandhabt, und eine client Variable zur Verfügung gestellt,
 * damit man auf die Services zugreifen kann.
 *
 */
public class SoapClient {
	
	private JaxWsProxyFactoryBean factory;
	private AlleServicesSEI client;
	
	private static SoapClient instance;
	
	/**
	 * Da Singleton
	 * @return Eine Instanz der Klasse
	 */
	public static SoapClient getInstance(){
		if(instance == null) instance = new SoapClient();
		return instance;
	}
	
	/**
	 * Da Singleton
	 * hier werden die gesamten Instanzvariablen initialisiert
	 */
	private SoapClient(){
		this.factory = new JaxWsProxyFactoryBean();
		this.factory.setServiceClass(AlleServicesSEI.class);
		this.factory.setAddress("http://localhost:9000/AlleServices");
		
		this.client = (AlleServicesSEI) factory.create();
	}


	public AlleServicesSEI getClient() {
		return client;
	}
}
