package junit.produkt;

import static org.junit.Assert.*;

import org.junit.Test;

import management.Benutzerverwaltung;
import management.Produktverwaltung;

public class ProduktAnlegen {

	@Test
	public void produktAnlegen() {
		
		Produktverwaltung proVer = Produktverwaltung.getinstance();
		boolean an_pro = proVer.produktAnlegen("Toshiba", 300, "gertsch", "Computer", 0, "sehr gut");
		assertEquals(true,an_pro);
			
		
	}

}
