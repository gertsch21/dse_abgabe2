package junit.produktgruppe;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import management.Produktgruppeverwaltung;
import modell.Produktgruppe;

public class GetProduktgruppeList {
	
	Produktgruppeverwaltung pg_ver = Produktgruppeverwaltung.getinstance();
	
	@Test
	public void getProduktgruppeList() {
		
		List<Produktgruppe> pg = pg_ver.getProduktgruppeList();
		boolean pgtest = false;
		
		for(Produktgruppe i : pg){
		//System.out.println(i.getName());
			if(i.getClass() == Produktgruppe.class){
				pgtest = true;
			}else {
				pgtest = false;
			}
		}
		assertEquals(true,pgtest);
	}

}
