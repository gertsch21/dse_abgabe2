package junit.produktgruppe;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import management.Produktgruppeverwaltung;
import modell.Produktgruppe;

public class ProduktguppeAendern {
	
Produktgruppeverwaltung pg_ver = Produktgruppeverwaltung.getinstance();
	
	@Test
	public void produktgruppeAendern() {
		
		boolean pgandern = pg_ver.produktgruppeAendern("Smartphone", "Handy");
	
		
		assertEquals(true,pgandern);
	}

}
