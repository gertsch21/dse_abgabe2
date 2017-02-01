package junit.rest.produktgruppe;

import static org.junit.Assert.*;

import org.junit.Test;

import client.rest.ClientInterface;
import client.rest.RestClient;

public class GetProduktgruppebyName {
	
	ClientInterface client = new RestClient();
	boolean test = false;

	@Test
	public void test() {
		if(client.getProduktgruppebyUsername("Handy")!=null){
			
			test=true;
		}
		else test = false;
		 
		assertEquals(true,test);
	}
}
