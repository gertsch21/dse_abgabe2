package jUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import client.soap.AlleServicesSEI;
import webservice.soap.SoapClient;

public class ProduktgruppeAnlegen {
	
	Boolean test=false;
	SoapClient sc = SoapClient.getInstance();
	AlleServicesSEI client = sc.getClient();

	@Test
	public void test() {
		test=client.produktgruppeAnlegen("Antike");
		assertEquals(true,test);
	}
	
}
