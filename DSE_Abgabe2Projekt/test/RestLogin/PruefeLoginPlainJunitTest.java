/**
 * In diesem Package werden die Mehtoden des WebServices in REST überprüft und kontrolliert
 */
package RestLogin;

import static org.junit.Assert.*;
import client.rest.ClientInterface;
import client.rest.RestClient;
import org.junit.Test;

public class PruefeLoginPlainJunitTest {

	ClientInterface test = new RestClient();
				
	/**
	 * Dise Methode testet den Login des Users "mirzi".
	 * Hierbei geben wir den Username und das dazugehörige Passwort an
	 * und erwarten einen Bool'schen Wert.
	 * 
	 */
				
		@Test
		public void LoginPlain(){
			boolean pruefe = test.pruefeLoginPlain("mirzi", "hallo");
			assertEquals(true,pruefe);
		}
		
		
		/**
		 * Dise Methode testet den Login des Users "gertsch".
		 * Hierbei geben wir den Username und das dazugehörige Passwort an
		 * und erwarten einen Bool'schen Wert.
		 * 
		 */
		
		
		@Test
		public void LoginPlain1(){
			boolean pruefe = test.pruefeLoginPlain("gertsch", "hallo");
			assertEquals(true,pruefe);
		}
		
		
		/**
		 * Dise Methode testet den Login des Users "gertsch2".
		 * Hierbei geben wir den Username und das dazugehörige Passwort an
		 * und erwarten einen Bool'schen Wert.
		 * 
		 */
		
		@Test
		public void LoginPlain2(){
			boolean pruefe = test.pruefeLoginPlain("gertsch2", "hallo");
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
		public void LoginPlain3(){
			boolean pruefe = test.pruefeLoginPlain("gert", "hal");
			assertEquals(false,pruefe);
		}
				
}
