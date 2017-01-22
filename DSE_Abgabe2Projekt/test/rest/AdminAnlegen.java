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
		test = client.adminAnlegen("JosefBro119","Weber","email@mail.com", 2145369, "RodeoDrive3453", "Manhatten4", 1659,"apfelsaft","123456789",45678);
		assertEquals(true,test);
		
		
	}

	

}
