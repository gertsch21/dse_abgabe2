package junit.benutzer;

import static org.junit.Assert.*;

import org.junit.Test;

import management.Benutzerverwaltung;

public class AdressdatenAendernT {

	@Test
	public void adressdatenAendern() {
		Benutzerverwaltung benVer = Benutzerverwaltung.getInstance();
		boolean address = benVer.adressdatenAendern("miki", 25369, "RodeoDrive345", "BevHills", 569);
		assertEquals(true,address);
	}
	
	@Test
	public void adressdatenAendernFalse() {
		Benutzerverwaltung benVer = Benutzerverwaltung.getInstance();
		boolean address = benVer.adressdatenAendern("nobody", 25369, "RodeoDrive345", "BevHills", 569);
		assertEquals(false,address);
	}


	

}
