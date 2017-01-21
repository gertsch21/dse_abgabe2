package junit.benutzer;

import static org.junit.Assert.*;

import org.junit.Test;

import management.Benutzerverwaltung;

public class BenutzerAnlegenT {

	Benutzerverwaltung benVer = Benutzerverwaltung.getInstance();
	@Test
	public void anlegenBenutzerT() {
	
		boolean an_ben = benVer.benutzerAnlegen("Enrique" , "Iglesias","eki@hotmail.com", 90210, "E Santa Clara St", "California", 122, "eki8", "hallo");
		assertEquals(true,an_ben);
		
	}
}
