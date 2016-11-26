/**
 * In diesem Package werden die Mehtoden des WebServices in SOAP überprüft und kontrolliert
 */
package SoapLogin;

import static org.junit.Assert.*;
import org.junit.Test;
import soap.services.Benutzerservices;

public class PruefeLoginJuniTest {

	Benutzerservices test = new Benutzerservices();
	
	/**
	 * Dise Methode testet den Login des Users "mirzi".
	 * Hierbei geben wir den Username und das dazugehörige Passwort an
	 * und erwarten einen Bool'schen Wert.
	 * 
	 */
	
	@Test
	public void testLogin() {
		boolean pruefe = test.pruefeLogin("gertsch", "hallo");
		assertEquals(true,pruefe);
		
	}
	
	
	/**
	 * Dise Methode testet den Login des Users "mirzi".
	 * Hierbei geben wir den Username und das dazugehörige Passwort an
	 * und erwarten einen Bool'schen Wert.
	 * 
	 */
	
	@Test
	public void testLogin1() {
		boolean pruefe = test.pruefeLogin("gertsch2", "hallo");
		assertEquals(true,pruefe);
		
	}
	
	
	/**
	 * Dise Methode testet den Login des Users "mirzi".
	 * Hierbei geben wir den Username und das dazugehörige Passwort an
	 * und erwarten einen Bool'schen Wert.
	 * 
	 */
	
	@Test
	public void testLogin2() {
		boolean pruefe = test.pruefeLogin("mirzi", "hallo");
		assertEquals(true,pruefe);
		
	}
	
	
	/**
	 * Dise Methode testet den Login des Users "gert".
	 * Hierbei geben wir den Username und das falsche Passwort an
	 * und erwarten einen Bool'schen Wert. In diesem Fall eben False, weil
	 * es nicht stimmen kann.
	 * 
	 */
	
	@Test
	public void testLogin3() {
		boolean pruefe = test.pruefeLogin("mirzi", "lo");
		assertEquals(false,pruefe);
		
	}

}
