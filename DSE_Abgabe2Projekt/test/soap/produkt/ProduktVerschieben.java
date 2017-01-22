package jUnit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import client.soap.AlleServicesSEI;
import management.Produktverwaltung;
import modell.Produkt;
import webservice.soap.SoapClient;

public class ProduktVerschieben {
	
	Produktverwaltung pv_ver = Produktverwaltung.getinstance();
	
	Boolean test=false;
	SoapClient sc = SoapClient.getInstance();
	AlleServicesSEI client = sc.getClient();
	Produkt p = null;
	
	@Test
	public void test() {
		List<Produkt> list = pv_ver.getProduktListe();
		for (Produkt i : list){
			if(i.getName().equals("tv2")){
				p = i;
			}
		}
		System.out.println(p.getOwnerUsername());
		test= client.produktVerschieben(p.getProduktID().toString(), "Computer");
		assertEquals(true,test);
	}

}
