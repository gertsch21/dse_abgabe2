package junit.rest;

import static org.junit.Assert.*;

import org.junit.Test;

import client.rest.ClientInterface;
import client.rest.RestClient;

public class AdminAnlegen {


	Boolean test=false;
	ClientInterface client = new RestClient();

	
	@Test
	public void test() {
		test = client.adminAnlegen("Vin", "Diesel", "vindiesel@gmail.com", 2356, "RodeoDrive3453", "Wien", 125, "vinfast", "vindiesel678", 12999);
		assertEquals(true,test);
		
		
	}

	

}
