package junitSOAP;

import static org.junit.Assert.*;
import java.text.ParseException;
import java.util.List;
import org.junit.Test;
import client.soap.AlleServicesSEI;
import management.Auktionsverwaltung;
import webservice.soap.SoapClient;

public class VerkauftProdukteVonBenutzer {
	
	Auktionsverwaltung auktion = Auktionsverwaltung.getInstance();
	Boolean test=false;
	SoapClient sc = SoapClient.getInstance();
	AlleServicesSEI client = sc.getClient();
	
	

	@Test
	public void test() throws ParseException {
		int count = 0;
		auktion.gebotEnde();
		
		List<client.soap.Produkt> allePr = client.getVerkaufteProdukteVonBenutzer("gertsch");
		for(client.soap.Produkt i : allePr){
			count++;
		}
		
		if(count == 0){
			test = false; 
		}else{
			test = true;
		}
		
	 	
		assertEquals(true,test);
	}

}
