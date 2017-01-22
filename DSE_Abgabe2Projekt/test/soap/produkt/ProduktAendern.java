package jUnit;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import client.soap.AlleServicesSEI;
import management.Produktverwaltung;
import modell.Produkt;
import webservice.soap.SoapClient;

public class ProduktAendern {

	Boolean test=false;
	SoapClient sc = SoapClient.getInstance();
	AlleServicesSEI client = sc.getClient();
	Produktverwaltung produkt = Produktverwaltung.getinstance();
	Produkt p = null;
	
	@Test
	public void test() {
		List<Produkt> list = produkt.getProduktListe();
		for (Produkt i : list){
			
			if(i.getName().equals("Der Chef")){
				p = i;
				break;
			}
		}
		System.out.println("das ist die SYSO ID" + p.getProduktID());
		test = client.produktAendern(p.getProduktID().toString(),"sneza",200, "snezi", "Computer", 18, "Voll145 anders");
		assertEquals(true,test);	
	}

}
