package jUnit;

import static org.junit.Assert.*;
import org.junit.Test;
import client.soap.AlleServicesSEI;
import webservice.soap.SoapClient;


public class ProduktAnlegen {
	
	Boolean test=false;
	SoapClient sc = SoapClient.getInstance();
	AlleServicesSEI client = sc.getClient();

	@Test
	public void test() {
		test = client.produktAnlegen("Toshiba", 300, "gertsch", "Computer", 0, "sehr gut");
		assertEquals(true,test);
	}

}
