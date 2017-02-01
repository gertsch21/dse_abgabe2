package junit.rest.produktgruppe;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import client.rest.ClientInterface;
import client.rest.RestClient;
import modell.Produktgruppe;

public class ProduktgruppeAnzeigenRest {
	
	ClientInterface client = new RestClient();
	boolean test = false;

	@Test
	public void test() {
		
		List<Produktgruppe> pg = client.produktgruppeListe();
		for(Produktgruppe i : pg){
			if(i.getClass()==Produktgruppe.class){
				
				test = true;
				}
			
		else {
			test = false;
		}
	}
		assertEquals(true,test);
	}

}
