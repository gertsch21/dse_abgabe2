import management.Benutzerverwaltung;
import management.Produktgruppeverwaltung;
import management.Produktverwaltung;

import modell.*;

public class Testmethoden {

	public static void main(String[] args) {


		Produktverwaltung prodver = Produktverwaltung.getinstance();
		Produktgruppeverwaltung prodgruver = Produktgruppeverwaltung.getinstance();
		
		if(prodgruver.produktgruppeAnlegen("Gitarre"))
			System.out.println("Produktgruppe Gitarre angelegt");
		else
			System.out.println("Produktgruppe Gitarre nicht angelegt");
		
		for(Produkt pg : prodver.sucheProdukt("exnder"))
			System.out.println(pg);
		
		if(prodver.produktAnlegen("Fender Squier Affinity Strat", 199, "gertccccsch", "Gitarre", 20, "eine günstige Gitarre"))
			System.out.println("Produkt angelegt");
		else
			System.out.println("Produkt nicht angelegt");
	}

}
