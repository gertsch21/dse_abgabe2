package junit.produktgruppe;

import static org.junit.Assert.*;

import org.junit.Test;

import management.Produktgruppeverwaltung;

public class ProduktGruppeLoeschen {
	
		Produktgruppeverwaltung pg_ver = Produktgruppeverwaltung.getinstance();
	
	@Test
	public void produktgruppeLoeschen() {
		
		boolean pgandern = pg_ver.produktgruppeLoeschen("Handy");
		assertEquals(true,pgandern);
	}

}
