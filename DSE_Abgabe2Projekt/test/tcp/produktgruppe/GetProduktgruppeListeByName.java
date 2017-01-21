package junit.produktgruppe;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import management.Produktgruppeverwaltung;
import modell.Person;
import modell.Produkt;
import modell.Produktgruppe;

public class GetProduktgruppeListeByName {
	
	Produktgruppeverwaltung proVerw = Produktgruppeverwaltung.getinstance();

	@Test
	public void getProduktgruppeListeByName() {
		
		 List<Produktgruppe> liste = proVerw.getProduktgruppeList();
		 Produktgruppe produkt = proVerw.getProduktgruppeByName("Handy");
		 boolean pgcheck = false;
		 
		 for (Produktgruppe i : liste){
				if(i.getName().equals(produkt.equals("Handy")) ){
					pgcheck = true;
				}
				else{
					pgcheck = false; 
				}
					
			 }
		 assertEquals(true,pgcheck);
		
	}
	
	@Test
	public void getProduktgruppeListeByNameFALSE() {
		
		 List<Produktgruppe> liste = proVerw.getProduktgruppeList();
		 Produktgruppe produkt = proVerw.getProduktgruppeByName("Ss");
		 boolean pgcheck = false;
		 
		 for (Produktgruppe i : liste){
				if(i.getName().equals(produkt.equals("Ss")) ){
					pgcheck = true;
				}
				else{
					pgcheck = false; 
				}
					
			 }
		 assertEquals(false,pgcheck);
		
	}

}
