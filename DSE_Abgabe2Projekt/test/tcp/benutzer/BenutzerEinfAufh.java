package junit.benutzer;

import static org.junit.Assert.*;

import org.junit.Test;

import management.Benutzerverwaltung;

public class BenutzerEinfAufh {

	Benutzerverwaltung benVer = Benutzerverwaltung.getInstance();
	@Test
	public void benutzerEinfAufh() {
		boolean ein = benVer.benutzerEinfrieren("eki");
		assertEquals(true,ein);
		
	}
	@Test
	public void benutzerEinfAufhF() {
		boolean ein = benVer.benutzerEinfrieren("miki");
		assertEquals(false,ein);
		
	}

}
