/**
 * In diesem Package werden die Mehtoden des WebServices in REST überprüft und kontrolliert
 */
package RestLogin;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import client.rest.ClientInterface;
import client.rest.RestClient;


public class PruefeLoginXmlJunitTest {
	
	ClientInterface test = new RestClient();
	
	/**
	 * Dise Methode testet den Login des Users "mirzi".
	 * Hierbei geben wir den Username und das dazugehörige Passwort an
	 * und erwarten einen Bool'schen Wert.
	 * 
	 */
				
		@Test
		public void LoginXML(){
			boolean pruefe = test.pruefeLoginXml("mirzi", "hallo");
			assertEquals(true,pruefe);
			
		}
		
		
		/**
		 * Dise Methode testet den Login des Users "gertsch".
		 * Hierbei geben wir den Username und das dazugehörige Passwort an
		 * und erwarten einen Bool'schen Wert.
		 * 
		 */
		
		
		@Test
		public void LoginXML1(){
			boolean pruefe = test.pruefeLoginXml("gertsch", "hallo");
			assertEquals(true,pruefe);
		}
		
		
		/**
		 * Dise Methode testet den Login des Users "gertsch2".
		 * Hierbei geben wir den Username und das dazugehörige Passwort an
		 * und erwarten einen Bool'schen Wert.
		 * 
		 */
		
		@Test
		public void LoginXML2(){
			boolean pruefe = test.pruefeLoginXml("gertsch2", "hallo");
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
		public void LoginXML3(){
			boolean pruefe = test.pruefeLoginXml("gert", "hal");
			assertEquals(false,pruefe);
		}
}
