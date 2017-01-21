package junit.benutzer;

import static org.junit.Assert.*;

import org.junit.Test;

import management.Benutzerverwaltung;

public class BenutzerAnlegenF {

	Benutzerverwaltung benVer = Benutzerverwaltung.getInstance();
	@Test
	public void anlegenBenutzerF()  {
	
		boolean an_ben = benVer.benutzerAnlegen("Enrique" , "Iglesias","eki@hotmail.com", 90210, "E Santa Clara St", "California", 122, "ekiQ", "hallo");
		assertEquals(false,an_ben);
		
	}
}
