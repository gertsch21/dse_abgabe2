package webservice.soap;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import client.soap.*;

public class SoapClient {
	
	private JaxWsProxyFactoryBean factory;
	private AlleServicesSEI client;
	
	private static SoapClient instance;
	
	public static SoapClient getInstance(){
		if(instance == null) instance = new SoapClient();
		return instance;
	}
	
	private SoapClient(){
		this.factory = new JaxWsProxyFactoryBean();
		this.factory.setServiceClass(AlleServicesSEI.class);
		this.factory.setAddress("http://localhost:9000/AlleServices");
		
		this.client = (AlleServicesSEI) factory.create();
	}
	
	public static void main(String args[]) throws Exception {
		 
		SoapClient sc = SoapClient.getInstance();
		
		AlleServicesSEI client = sc.getClient();
		
		
		
		
//		
//		System.out.println("Login mit nein/nein: " + client.pruefeLogin("nein", "nein"));
//		System.out.println("Login mit gertsch/hallo: " + client.pruefeLogin("gertsch", "hallo"));
//
//		for(Benutzer b : client.getBenutzerliste())
//			System.out.println(b.getUsername());
//		for(Produkt p : client.getProduktListe())
//			System.out.println("Produkt: " + p.getName()+", "+p.getOwnerUsername());
//		
//		client.produktLoeschen("38910565-720f-463e-9cf9-cfb30e9053ce");
//		client.benutzerloeschen("king");
//		System.out.println(client.getProduktgruppeByName("Rollstuhl"));
//		
		System.exit(0);
	}

	public AlleServicesSEI getClient() {
		return client;
	}

	public void setClient(AlleServicesSEI client) {
		this.client = client;
	}
}
