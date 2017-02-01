package junit.rest.gebot;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import client.rest.ClientInterface;
import client.rest.RestClient;
import modell.Produkt;

public class GebotLoeschen {
	
	ClientInterface client = new RestClient();
	boolean test = false;
	


	@Test
	public void test() {
		List<Produkt> list = client.sucheProdukt();
		Produkt p = new Produkt();
		for(Produkt i : list){
			if(i.getOwnerUsername().equals("josi")){
				if(i.getName().equals("AutoBianchi")){
					p=i;
					
				}	
			}
	     }
		System.out.println("Produkt   " + p.getProduktID());
		String iD =  p.getProduktID().toString();	
		test = client.gebotdelete(iD);
		assertEquals(true,test);
		

	}
}
