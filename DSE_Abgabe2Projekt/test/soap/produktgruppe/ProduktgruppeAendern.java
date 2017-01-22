package jUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import client.soap.AlleServicesSEI;
import webservice.soap.SoapClient;
import webservice.soap.SoapServer;

public class ProduktgruppeAendern {
	
	Boolean test=false;
	SoapClient sc = SoapClient.getInstance();
	AlleServicesSEI client = sc.getClient();

	@Test
	public void test() {
		test = client.produktgruppeAendern("Handy", "Smartphone");
		assertEquals(true,test);
	}

}
