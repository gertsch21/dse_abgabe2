package junit.produktgruppe;

import static org.junit.Assert.*;

import org.junit.Test;

import management.Produktgruppeverwaltung;
import management.Produktverwaltung;

public class ProduktGruppeAnlegen {
	
	Produktgruppeverwaltung pg = Produktgruppeverwaltung.getinstance();
	
	@Test
	public void produktGruppeAnlegenJUNIT() {
		
		boolean pg_test = pg.produktgruppeAnlegen("Handy");
		assertEquals(true,pg_test);
		
	}

}
