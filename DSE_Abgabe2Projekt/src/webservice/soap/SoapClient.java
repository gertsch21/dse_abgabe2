package webservice.soap;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import client.soap.*;

public class SoapClient {
	public static void main(String args[]) throws Exception {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(AlleServicesSEI.class);
		factory.setAddress("http://localhost:9000/AlleServices");
		AlleServicesSEI client = (AlleServicesSEI) factory.create();
		System.out.println("Login mit nein/nein: " + client.pruefeLogin("nein", "nein"));
		System.out.println("Login mit gertsch/hallo: " + client.pruefeLogin("gertsch", "hallo"));

		for(Benutzer b : client.getBenutzerliste())
			System.out.println(b.getUsername());
		for(Produkt p : client.getProduktListe())
			System.out.println("Produkt: " + p.getName()+", "+p.getOwnerUsername());
		
		System.out.println(client.getProduktgruppeByName("Rollstuhl"));
		
		System.exit(0);
	}
}
