package junit.rest;

import static org.junit.Assert.*;

import org.junit.Test;

import client.rest.ClientInterface;
import client.rest.RestClient;

public class Benutzerreg {
	

		@Test
		public void test() {
			
			Boolean test=false;
			ClientInterface client = new RestClient();

			
		if(client.benutzerAnlegen("Enrique13" , "Iglesias1","eki@hotmail1.com", 90210, "E Santa Clara St", "California", 122, "ek55695998", "halloo678549o")){
			test=true;
		}else{
			test=false;
		}
			
		assertEquals(true,test);
		}

	}


