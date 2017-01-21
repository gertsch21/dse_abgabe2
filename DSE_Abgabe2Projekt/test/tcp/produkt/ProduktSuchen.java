package junit.produkt;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import management.Produktverwaltung;
import modell.Produkt;

public class ProduktSuchen {
	
	Produktverwaltung proVer = Produktverwaltung.getinstance();

	@Test
	public void produktSuche() {
		
		
		
		List<Produkt> prod = proVer.getProduktListe();
		
		boolean produktcheck = false;
		 
		 for (Produkt i : prod){
			System.out.println(i.getName());
				if(i.getName().equals("ASUS k55v")  ){
					System.out.println(i.getName());
					produktcheck = true;
					break;
				}
				else{
					produktcheck = false; 
				}
					
			 }
		 assertEquals(true,produktcheck);
		
	}
	
	@Test
	public void produktSucheFALSE() {
	List<Produkt> prod = proVer.getProduktListe();
		
		boolean produktcheck = false;
		 
		 for (Produkt i : prod){
			
				if(i.getName().equals("Nokia Lumia 920")  ){
					System.out.println(i.getName());
					produktcheck = true;
					break;
				}
				else{
					produktcheck = false; 
				}
					
			 }
		 assertEquals(false,produktcheck);
		
	}

}
