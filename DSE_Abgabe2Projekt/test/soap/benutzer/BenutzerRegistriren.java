package junitSOAP;

import static org.junit.Assert.*;
import org.junit.Test;
import client.soap.AlleServicesSEI;
import webservice.soap.SoapClient;

public class BenutzerRegistriren {

	@Test
	public void test() {
		
		Boolean test=false;
		SoapClient sc = SoapClient.getInstance();
		AlleServicesSEI client = sc.getClient();
		
	if(client.benutzerAnlegen("Enrique13" , "Iglesias1","eki@hotmail1.com", 90210, "E Santa Clara St", "California", 122, "ekiQ12345", "hallooo")){
		test=true;
	}else{
		test=false;
	}
		
	assertEquals(true,test);
	}

}
