package jUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import client.soap.AlleServicesSEI;
import management.Produktverwaltung;
import modell.Produkt;
import modell.Produktgruppe;
import webservice.soap.SoapClient;

public class ProduktgruppeByName {
	
	Boolean test=false;
	SoapClient sc = SoapClient.getInstance();
	AlleServicesSEI client = sc.getClient();
	Produktverwaltung produkt = Produktverwaltung.getinstance();
	Produkt p = null;


	@Test
	public void test() {
		if(client.getProduktgruppeByName("Handy")!=null){
			
			test=true;
		}
		else test = false;
		 
		assertEquals(true,test);
	}

}
