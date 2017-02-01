package junit.rest.produkt;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import client.rest.ClientInterface;
import client.rest.RestClient;
import modell.Produkt;

public class ProduktVerschiebenRest {
	
	ClientInterface client = new RestClient();
	boolean test = false;
	
	@Test
	public void test() {
			
			Produkt p = new Produkt();
			
			List<Produkt> list = client.sucheProdukt();
			for (Produkt i : list){
				if(i.getName().equals("NiceBike")){
					p = i;
				}
			}
			
			test= client.produktVerschieben(p.getProduktID(), "Rollstuhl");
			assertEquals(true,test);
		}

}
