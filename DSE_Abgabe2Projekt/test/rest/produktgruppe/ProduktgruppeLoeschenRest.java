package junit.rest.produktgruppe;

import static org.junit.Assert.*;

import org.junit.Test;

import client.rest.ClientInterface;
import client.rest.RestClient;

public class ProduktgruppeLoeschenRest {
	ClientInterface client = new RestClient();
	boolean test = false;
	@Test
	public void test() {
		test = client.produktgruppeLoeschen("Handy");
		assertEquals(true,test);
	}
}
