package junitSOAP;

import static org.junit.Assert.*;

import org.junit.Test;

import client.soap.AlleServicesSEI;
import webservice.soap.SoapClient;

public class AdressdatenAendern {
	Boolean test=false;
	SoapClient sc = SoapClient.getInstance();
	AlleServicesSEI client = sc.getClient();
	
	@Test
	public void test() {
		test = client.adressdatenAendern("Herman", 2145369, "RodeoDrive345", "Manhatten", 169);
		assertEquals(true,test);
		
		
	}

	@Test
	public void test1(){
		test = client.adressdatenAendern("nobody", 25369, "RodeoDrive345", "BevHills", 569);
		assertEquals(false,test);
	}
}
