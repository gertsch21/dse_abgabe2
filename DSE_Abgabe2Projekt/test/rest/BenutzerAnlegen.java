package junit.rest;

import static org.junit.Assert.*;

import org.junit.Test;

import client.rest.ClientInterface;
import client.rest.RestClient;
public class BenutzerAnlegen {
	
	Boolean test=false;
	ClientInterface client = new RestClient();

	@Test
	public void test() {
		test=client.benutzerAnlegen("Enhjfi","Iglesias","eki@hotmail.com", 90210, "E Santa Clara St", "California", 122, "michael", "hal9loooooo");
		assertEquals(true,test);
	}
	
	@Test
	public void test1() {
		test=client.benutzerAnlegen("Enrique555","Iglesias","eki@hotmail.com", 90210, "E Santa Clara St", "California", 122, "ek", "hall");
		assertEquals(false,test);
	}

}
