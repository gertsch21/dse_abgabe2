package junit.produkt;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import management.Produktverwaltung;
import modell.Produkt;

public class ProduktVerschieben {
	
	Produktverwaltung pv_ver = Produktverwaltung.getinstance();

	@Test
	public void produktVerschieben() {
		
		Produkt p = null;
		List<Produkt> list = pv_ver.getProduktListe();
		for (Produkt i : list){
			if(i.getName().equals("Samsung Lt 200")){
				p = i;
			}
		}
		System.out.println(p.getOwnerUsername());
		boolean verschiebung = pv_ver.produktVerschieben(p.getProduktID(), "Computer");
		assertEquals(true,verschiebung);
	}

}
