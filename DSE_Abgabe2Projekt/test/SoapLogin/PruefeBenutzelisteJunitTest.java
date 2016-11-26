package SoapLogin;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import modell.Benutzer;

import soap.services.Benutzerservices;

public class PruefeBenutzelisteJunitTest {

	Benutzerservices test = new Benutzerservices();
	
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
