package jUnit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import client.soap.AlleServicesSEI;
import management.Produktverwaltung;
import modell.Produkt;
import webservice.soap.SoapClient;

public class ProduktLoeschen {
	
	Boolean test=false;
	SoapClient sc = SoapClient.getInstance();
	AlleServicesSEI client = sc.getClient();
	Produktverwaltung produkt = Produktverwaltung.getinstance();
	Produkt p = null;
	String deleteID;

	@Test
	public void test() {
		
		List<Produkt> list = produkt.getProduktListe();
		Produkt p = null;
		
	for (Produkt i : list){
		if(i.getName().equals("Toshiba")){
			p = i;
			deleteID = p.getProduktID().toString();
			System.out.println("das Produkt" + p );
			break;
		}
	}
	
	test = client.produktLoeschen(deleteID);
	assertEquals(true,test);	
	}

}
