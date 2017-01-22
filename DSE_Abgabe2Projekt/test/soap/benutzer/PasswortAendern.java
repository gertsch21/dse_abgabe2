package junitSOAP;

import static org.junit.Assert.*;

import org.junit.Test;

import client.soap.AlleServicesSEI;
import webservice.soap.SoapClient;

public class PasswortAendern {
	
	Boolean test=false;
	SoapClient sc = SoapClient.getInstance();
	AlleServicesSEI client = sc.getClient();

	@Test
	public void test() {
		test = client.passwortAendern("jamesbond", "halloeki899");
		
		assertEquals(true,test);
	}
	
	@Test
	public void test1() {
		test = client.passwortAendern("unbekannt", "halloeki899");
		
		assertEquals(false,test);
	}

}
