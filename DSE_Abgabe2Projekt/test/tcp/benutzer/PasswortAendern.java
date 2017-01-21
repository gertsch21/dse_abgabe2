package junit.benutzer;

import static org.junit.Assert.*;

import org.junit.Test;

import management.Benutzerverwaltung;

public class PasswortAendern {
	Benutzerverwaltung benVer = Benutzerverwaltung.getInstance();
	
	@Test
	public void test() {
		boolean pwd = benVer.passwortAendern("eki8", "halloeki899");
		
		assertEquals(true,pwd);
		
	}
	
	@Test
	public void testFALSE() {
		boolean pwd = benVer.passwortAendern("eki8", "hallo");
		
		assertEquals(false,pwd);
		
	}

}
