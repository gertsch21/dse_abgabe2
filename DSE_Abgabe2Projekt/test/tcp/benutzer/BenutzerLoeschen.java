package junit.benutzer;

import static org.junit.Assert.*;

import org.junit.Test;

import management.Benutzerverwaltung;

public class BenutzerLoeschen {

	Benutzerverwaltung benVer = Benutzerverwaltung.getInstance();
	@Test
	public void benutzerLoeschen() {
		boolean ein = benVer.benutzerloeschen("eki7");
		assertEquals(true,ein);
		
	}

}
