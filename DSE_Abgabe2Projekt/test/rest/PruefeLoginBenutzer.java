package junit.rest;

import static org.junit.Assert.*;

import org.junit.Test;

import client.rest.ClientInterface;
import client.rest.RestClient;

public class PruefeLoginBenutzer {
	ClientInterface rest = new RestClient();
	@Test
	public void test() {
		boolean pruefe = rest.pruefeLogin("gertsch2", "hallo");
		assertEquals(true,pruefe);
	}

}



