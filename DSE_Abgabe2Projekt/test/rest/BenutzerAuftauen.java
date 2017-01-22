package junit.rest;

import static org.junit.Assert.*;

import org.junit.Test;

import client.rest.ClientInterface;
import client.rest.RestClient;

public class BenutzerAuftauen {


	Boolean test=false;
	ClientInterface client = new RestClient();
	
	@Test
	public void test() {
		test = client.einaufhebenBenutzer("mirzi");
		assertEquals(true,test);
	}	
	@Test
	public void test1() {
		test = client.einaufhebenBenutzer("unbekannt");
		assertEquals(false,test);
	}
	

}
