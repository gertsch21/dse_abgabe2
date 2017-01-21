package junit.produkt;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import management.Produktverwaltung;
import modell.Produkt;

public class ProduktLoeschen {
	
	
	Produktverwaltung proVer = Produktverwaltung.getinstance();
	String deleteID;
	

	
	@Test
	public void produktLoeschen() {
			List<Produkt> list = proVer.getProduktListe();
			Produkt p = null;
			
		for (Produkt i : list){
			if(i.getName().equals("Nokia XL")){
				p = i;
				deleteID = p.getProduktID().toString();
				System.out.println("das Produkt" + p );
				break;
			}
		}
		
		boolean loesch_pro = proVer.produktLoeschen(deleteID);
		assertEquals(true,loesch_pro);	
	}
	

}
