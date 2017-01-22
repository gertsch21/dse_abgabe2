package jUnit;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;

import client.soap.AlleServicesSEI;
import modell.Produkt;
import webservice.soap.SoapClient;

public class ProduktSuchen {

	Boolean test=false;
	SoapClient sc = SoapClient.getInstance();
	AlleServicesSEI client = sc.getClient();
	
	@Test
	public void test() {
		List<client.soap.Produkt> prod = client.getProduktListe();

		 for (client.soap.Produkt i : prod){
				if(i.getName().equals("tv2")  ){
					test = true;
					break;
				}
				else{
					test = false; 
				}
					
			 }
		 assertEquals(true,test);
		
	}
	
	@Test
	public void test1() {
		List<client.soap.Produkt> prod = client.getProduktListe();

		 for (client.soap.Produkt i : prod){
				if(i.getName().equals("unbekannt")  ){
					test = true;
					break;
				}
				else{
					test = false; 
				}
					
			 }
		 assertEquals(false,test);
		
	}

}
