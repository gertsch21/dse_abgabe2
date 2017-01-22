package junitSOAP;

import static org.junit.Assert.*;

import org.junit.Test;

import client.soap.AlleServicesSEI;
import webservice.soap.SoapClient;

public class BenutzerAuftauen {

	Boolean test=false;
	SoapClient sc = SoapClient.getInstance();
	AlleServicesSEI client = sc.getClient();
	
	@Test
	public void test() {
		test = client.benutzerEinfAufheben("snezi");
		assertEquals(true,test);
	}	
	@Test
	public void test1() {
		test = client.benutzerEinfAufheben("unbekannt");
		assertEquals(false,test);
	}
	

}
