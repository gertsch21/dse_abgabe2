package junit.benutzer;

import static org.junit.Assert.*;

import org.junit.Test;

import management.Benutzerverwaltung;

/**
 * Diese Methode testet den Anlegen des Admins.
 * Hierbei geben wir die Werte des Admins an
 * und erwarten einen Bool'schen Wert.
 * 
 */


public class AdminAnlegenJUnitT {
		Benutzerverwaltung benVer = Benutzerverwaltung.getInstance();
	@Test
	public void anlegenAdminT() {
		boolean an_admin = benVer.adminAnlegen("Mickey23" , "Rourke","mikiruri@hotmail.com", 90210, "RodeoDrive", "BevHills", 569, "miki1", "hallo", 50000);
		assertEquals(true,an_admin);
	
	}
	
	
	

}
