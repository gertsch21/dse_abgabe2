/**
 * In diesem Package werden die Mehtoden des WebServices in SOAP überprüft und kontrolliert
 */
package SoapLogin;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import modell.Benutzer;
import soap.services.Benutzerservices;

public class PruefeBenutzelisteJunitTest {

	Benutzerservices test = new Benutzerservices();
	
	
	/**
	 * Dieser Testfall prüft ob alle in der Liste vorhandenen Objekte
	 *  vom Typ Benutzer stammen.
	 */
	
	@Test
	public void test() {
		
		boolean check=false;
		  List<Benutzer> liste = test.getBenutzerliste();
		  List<Benutzer> benutzerListe = liste;
		  for(Benutzer i:benutzerListe){
				if (i.getClass()==Benutzer.class){
					check=true;
				}
				else{
					check=false;	
				}
		  }
		  assertEquals (true,check);
	   }
}
