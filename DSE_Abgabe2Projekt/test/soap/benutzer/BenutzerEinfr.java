package junitSOAP;

import static org.junit.Assert.*;

import org.junit.Test;

import client.soap.AlleServicesSEI;
import webservice.soap.SoapClient;

public class BenutzerEinfr {
	
	Boolean test=false;
	SoapClient sc = SoapClient.getInstance();
	AlleServicesSEI client = sc.getClient();
	
	@Test
	public void test() {
		test=client.benutzerEinfrieren("snezi");
		assertEquals(true,test);
	}
	
	@Test
	public void test1() {
		test=client.benutzerEinfrieren("unbekannt");
		assertEquals(false,test);
	}


}
