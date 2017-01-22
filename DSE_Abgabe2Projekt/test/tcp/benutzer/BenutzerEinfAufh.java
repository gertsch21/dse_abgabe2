package junit.benutzer;

import static org.junit.Assert.*;

import org.junit.Test;

import management.Benutzerverwaltung;

public class BenutzerEinfAufh {

	Benutzerverwaltung benVer = Benutzerverwaltung.getInstance();
	@Test
	public void benutzerEinfAufh() {
		boolean ein = benVer.benutzerEinfAufheben("eki");
		assertEquals(true,ein);
		
	}
	@Test
	public void benutzerEinfAufhF() {
		boolean ein = benVer.benutzerEinfAufheben("miki");
		assertEquals(false,ein);
		
	}

}
