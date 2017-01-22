package junit.gebot;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import client.soap.AlleServicesSEI;
import management.Auktionsverwaltung;
import management.Produktverwaltung;
import modell.Produkt;
import webservice.soap.SoapClient;

public class GebotLoeschen {
	Auktionsverwaltung aktion = Auktionsverwaltung.getInstance();
	Produktverwaltung produkt = Produktverwaltung.getinstance();
	Produkt p = null;
	List<Produkt> list = produkt.getProduktListe();
	boolean max = false; 
	


	@Test
	public void test() {
		
		for(Produkt i : list){
			if(i.getOwnerUsername().equals("gertsch")){
				if(i.getName().equals("Samsung Lt 200")){
					p=i;
					System.out.println("ich habe mein produkt P" );
				}	
			}
	     }
		String iD =  p.getProduktID().toString();	
		max = produkt.produktLoeschen(iD);
		assertEquals(true,max);
		

	}
}
