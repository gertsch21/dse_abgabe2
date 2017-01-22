package junit.rest;

import static org.junit.Assert.*;

import org.junit.Test;

import client.rest.ClientInterface;
import client.rest.RestClient;

public class BenutzerLoeschen {

	public class BenutzerLöschen {

		Boolean test=false;
		ClientInterface client = new RestClient();
		
		@Test
		public void test() {
			test = client.deleteBenutzer("jamesbond1");
			assertEquals(true,test);
		}

	}
}
