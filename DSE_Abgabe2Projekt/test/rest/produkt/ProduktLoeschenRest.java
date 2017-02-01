package junit.rest.produkt;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import client.rest.ClientInterface;
import client.rest.RestClient;
import management.Produktverwaltung;
import modell.Produkt;

public class ProduktLoeschenRest {

	Boolean test=false;
	ClientInterface sc = new RestClient();
	Produktverwaltung produkt = Produktverwaltung.getinstance();
	String deleteID;
	@Test
	public void test() {
		
		
			
			List<Produkt> list = produkt.getProduktListe();
			Produkt p = null;
			
			
		for (Produkt i : list){
			if(i.getName().equals("asusComputer")){
				p = i;
				deleteID = p.getProduktID().toString();
				
				break;
			}
		}
		
		test = sc.produktDelete(deleteID);
		assertEquals(true,test);	
		}
	
}

