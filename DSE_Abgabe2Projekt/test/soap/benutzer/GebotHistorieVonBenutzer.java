/**
 * 
 */
package junitSOAP;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.List;

import org.junit.Test;

import client.soap.AlleServicesSEI;
import management.Auktionsverwaltung;
import webservice.soap.SoapClient;

/**
 * @author Mirz'n
 *
 */
public class GebotHistorieVonBenutzer {
	Boolean test=false;
	SoapClient sc = SoapClient.getInstance();
	AlleServicesSEI client = sc.getClient();
	Auktionsverwaltung auktion = Auktionsverwaltung.getInstance();
	int count=0;

	@Test
	public void test() throws ParseException {
		
		auktion.gebotEnde();
		List<client.soap.Produkt> allePr = client.getGebotshistorieVonBenutzer("gertsch");
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
