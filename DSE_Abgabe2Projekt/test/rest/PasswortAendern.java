package junit.rest;

import static org.junit.Assert.*;

import org.junit.Test;

import client.rest.ClientInterface;
import client.rest.RestClient;
import management.Auktionsverwaltung;

public class PasswortAendern {


		
	

		Boolean test=false;
		ClientInterface client = new RestClient();
	

		@Test
		public void test() {
			test = client.passwortAendern("jamesbond", "halloeki99899");
			
			assertEquals(true,test);
		}
		
		@Test
		public void test1() {
			test = client.passwortAendern("unbekannt", "halloeki88899");
			
			assertEquals(false,test);
		}

	}