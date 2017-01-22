package junitSOAP;

import static org.junit.Assert.*;

import org.junit.Test;

import client.soap.AlleServicesSEI;
import webservice.soap.SoapClient;

public class BenutzerAnlegen {
	
	Boolean test=false;
	SoapClient sc = SoapClient.getInstance();
	AlleServicesSEI client = sc.getClient();

	@Test
	public void test() {
		test=client.benutzerAnlegen("Enrique5e55","Iglesias","eki@hotmail.com", 90210, "E Santa Clara St", "California", 122, "laris89", "hallooo");
		assertEquals(true,test);
	}
	
	@Test
	public void test1() {
		test=client.benutzerAnlegen("Enrique555","Iglesias","eki@hotmail.com", 90210, "E Santa Clara St", "California", 122, "ek", "hall");
		assertEquals(false,test);
	}

}
