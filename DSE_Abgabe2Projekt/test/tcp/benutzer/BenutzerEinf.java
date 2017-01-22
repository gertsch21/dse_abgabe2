package junit.benutzer;

import static org.junit.Assert.*;

import org.junit.Test;

import management.Benutzerverwaltung;

public class BenutzerEinf {
	
	Benutzerverwaltung benVer = Benutzerverwaltung.getInstance();

	@Test
	public void benutzerEinf() {
		boolean ein = test.benutzerEinfrieren("miki");
		assertEquals(false,ein);
		
		
	}
	@Test
	public void benutzerEinfF() {
		boolean ein = test.benutzerEinfrieren("eki");
		assertEquals(true,ein);
		
	}
	


}
