package jUnit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import client.soap.AlleServicesSEI;
import modell.Produktgruppe;
import webservice.soap.SoapClient;

public class ProduktgruppeAnzeigen {

	
	Boolean test=false;
	SoapClient sc = SoapClient.getInstance();
	AlleServicesSEI client = sc.getClient();
	int count=0;

	@Test
	public void test() {
		
		List<client.soap.Produktgruppe> pg = client.getProduktgruppeList();
		for(client.soap.Produktgruppe i : pg){
			if(i.getClass()==client.soap.Produktgruppe.class){
				
				test = true;
				}
			
		else {
			test = false;
		}
	}
		assertEquals(true,test);
	}
	 
 }
