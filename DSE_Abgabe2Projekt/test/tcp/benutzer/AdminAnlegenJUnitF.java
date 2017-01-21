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

public class AdminAnlegenJUnitF  extends Thread {
	Thread i = new Thread();
	Benutzerverwaltung benVer = Benutzerverwaltung.getInstance();
	@Test
	public void anlegenAdminF() throws Exception {
		i.sleep(2000);
		boolean an_admin = benVer.adminAnlegen("Mickey23" , "Rourke","mikiruri@hotmail.com", 90210, "RodeoDrive", "BevHills", 569, "miki1", "hallo", 50000);
		assertEquals(false,an_admin);
		
	}
	

}
