package junit.rest.produkt;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import client.rest.ClientInterface;
import client.rest.RestClient;
import modell.Produkt;

public class ProduktSuchenRest {
	ClientInterface client = new RestClient();
	
	boolean test = false;
	@Test
	public void test() {
		List<Produkt> prod = client.sucheProdukt();

		 for (Produkt i : prod){
				if(i.getName().equals("Fahrzeug")  ){
					test = true;
					break;
				}
				else{
					test = false; 
				}
					
			 }
		 assertEquals(true,test);
		
	}
}
