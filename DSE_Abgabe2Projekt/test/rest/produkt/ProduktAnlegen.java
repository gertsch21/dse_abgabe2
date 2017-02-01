package junit.rest.produkt;

import static org.junit.Assert.*;

import org.junit.Test;

import client.rest.ClientInterface;
import client.rest.RestClient;

public class ProduktAnlegen {

	Boolean test=false;
	ClientInterface sc = new RestClient();
	

	@Test
	public void test() {
		test = sc.produktAnlegen("asusComputer", 305, "gertsch", "Fernseher", 2, "sehr gut");
		
		assertEquals(true,test);
	}
}
