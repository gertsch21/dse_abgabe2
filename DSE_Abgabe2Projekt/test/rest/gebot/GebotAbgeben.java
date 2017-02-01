package junit.rest.gebot;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import client.rest.ClientInterface;
import client.rest.RestClient;
import modell.Produkt;

public class GebotAbgeben {
	
	ClientInterface client = new RestClient();
	boolean test = false;
	Produkt p = null;


	@Test
	public void test() {
		
		List<Produkt> list = client.sucheProdukt();
		for(Produkt i : list){
		if(i.getOwnerUsername().equals("gertsch")){
			if(i.getName().equals("Samsung Lt 200")){
				p=i;
				
			}
		}
	}
		String iD = p.getProduktID().toString();	
		test = client.gebotAbgeben("mirzi", 3333, iD);
		assertEquals(true,test);
		
	}
}
