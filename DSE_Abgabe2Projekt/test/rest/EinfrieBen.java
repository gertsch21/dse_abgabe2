package junit.rest;

import static org.junit.Assert.*;

import org.junit.Test;

import client.rest.ClientInterface;
import client.rest.RestClient;

public class EinfrieBen {

		
	
		
		Boolean test=false;
		ClientInterface client = new RestClient();
		
		@Test
		public void test() {
			test=client.einfrierenBenutzer("	");
			
			assertEquals(true,test);
		}
		
	}

