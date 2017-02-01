package junit.rest;

import static org.junit.Assert.*;

import org.junit.Test;

import client.rest.ClientInterface;
import client.rest.RestClient;

public class BenutzerLoeschen {

	public class BenutzerLöschen {

		Boolean test1=false;
		ClientInterface client = new RestClient();
		
		@Test
		public void test() {
			test1 = client.deleteBenutzer("vinfast");
			assertEquals(true,test1);
		}

	}
}
