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
			test = client.adressAendern("JosefBro11", 2145369, "RodeoDrive3453", "Manhatten4", 1659);
			assertEquals(true,test);
			
			
		}

		@Test
		public void test1(){
			test = client.adressAendern("nobody", 25369, "RodeoDrive345", "BevHills", 569);
			assertEquals(false,test);
		}
	}


