package junit.rest;

import static org.junit.Assert.*;

import org.junit.Test;

import client.rest.ClientInterface;
import client.rest.RestClient;

public class adressdatenAendern {

		Boolean test=false;
		ClientInterface client = new RestClient();
	
		
		@Test
		public void test() {
			test = client.adressAendern("vinfast", 67, "RodeoDriv89", "Manhatte9089", 789);
			assertEquals(true,test);
			
			
		}

	}


