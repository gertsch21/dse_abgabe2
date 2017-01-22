package junitSOAP;

import static org.junit.Assert.*;

import org.junit.Test;

import client.soap.AlleServicesSEI;
import webservice.soap.SoapClient;

public class BenutzerLöschen {

	Boolean test=false;
	SoapClient sc = SoapClient.getInstance();
	AlleServicesSEI client = sc.getClient();
	
	@Test
	public void test() {
		test = client.benutzerloeschen("hallohallo");
		assertEquals(true,test);
	}

}
