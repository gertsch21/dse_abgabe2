import management.Benutzerverwaltung;
import management.Produktgruppeverwaltung;
import management.Produktverwaltung;

import modell.*;

public class Testmethoden {

	public static void main(String[] args) {


		Produktverwaltung prodver = Produktverwaltung.getinstance();
		Produktgruppeverwaltung prodgruver = Produktgruppeverwaltung.getinstance();
		

//		prodver.produktAendern(p1.getProduktID(), "Epiphone Les Pauli", 200, "mirzi", "Gitarre", 20, "geil");
//	
//		prodver.produktAnlegen("Fender Strat", 1000, "mirzi", "Klavier", 100, "testbeschreibung");
//		prodver.produktLoeschen(p1.getProduktID().toString());
		
		
		
		
		
//		for(Produkt pg : prodver.getProduktListe()){
//			prodver.produktAendern(pg.getProduktID(), pg.getName(), 20, pg.getOwnerUsername(), "Gitarre", 100, "haha");
//		}
		
		System.out.println("Produkte");
		for(Produkt pg : prodver.getProduktListe()){
			System.out.println(" " + pg);
		}
		
		System.out.println("Produktgruppen");
		for(Produktgruppe pg : prodgruver.getProduktgruppeList()){
			System.out.println(" " + pg);
		}
		
		if(prodgruver.produktgruppeAendern("Klavier","Gitarre"))
			System.out.println("Produktgruppe geaendert");
		else
			System.out.println("Produktgruppe nicht geaendert");
		
		
	}

}
