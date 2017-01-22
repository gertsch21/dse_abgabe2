package junit.rest;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.List;

import org.junit.Test;

import client.rest.ClientInterface;
import client.rest.RestClient;
import management.Auktionsverwaltung;
import modell.Produkt;

public class VerkauftProdukteVonBenutzer {
	
	Auktionsverwaltung auktion = Auktionsverwaltung.getInstance();
	Boolean test=false;

	ClientInterface client = new RestClient();

	

	@Test
	public void test12() throws ParseException {
		int count = 0;
		auktion.gebotEnde();
		
		List<Produkt> allePr = client.getVerkaufteProdukteVonBenutzer("gertsch");
		for(Produkt i : allePr){
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
