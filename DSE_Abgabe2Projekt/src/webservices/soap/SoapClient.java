package webservices.soap;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import client.soap.*;
import client.soap.services.BenutzerservicesSEI;

public class SoapClient {
	public static void main(String args[]) throws Exception {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(BenutzerservicesSEI.class);
		factory.setAddress("http://localhost:9000/Benutzerservice");
		BenutzerservicesSEI client = (BenutzerservicesSEI) factory.create();
		System.out.println("Login mit nein/nein: " + client.pruefeLogin("nein", "nein"));
		System.out.println("Login mit gertsch/hallo: " + client.pruefeLogin("gertsch", "hallo"));

		System.exit(0);
	}
}
