package jUnit;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import client.soap.AlleServicesSEI;
import management.Produktverwaltung;
import modell.Produkt;
import webservice.soap.SoapClient;

public class GebotLoeschen {
	

	Boolean test=false;
	SoapClient sc = SoapClient.getInstance();
	AlleServicesSEI client = sc.getClient();
	Produktverwaltung produkt = Produktverwaltung.getinstance();
	Produkt p = null;


	@Test
	public void test() {
		List<Produkt> list =produkt.getProduktListe();
		for(Produkt i : list){
			if(i.getOwnerUsername().equals("gertsch")){
				if(i.getName().equals("Samsung Lt 50")){
					p=i;
					System.out.println("ich habe mein produkt P" );
				}	
			}
	     }
		String iD =  p.getProduktID().toString();	
		test = client.produktLoeschen(iD);
		assertEquals(true,test);
		

	}
}
