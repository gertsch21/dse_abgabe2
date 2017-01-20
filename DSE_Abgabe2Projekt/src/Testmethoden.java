import java.util.UUID;

import dao.PersonDAO;
import dao.ProduktDAO;
import dao.ProduktgruppeDAO;
import dao.SerializedPersonenDAOHibernate;
import dao.SerializedProduktDAOHibernate;
import dao.SerializedProduktgruppeDAOHibernate;
import exceptions.BenutzerNotFoundException;
import management.Auktionsverwaltung;
import management.Benutzerverwaltung;
import management.Produktgruppeverwaltung;
import management.Produktverwaltung;

import modell.*;

public class Testmethoden {

	public static void main(String[] args) {


		Produktverwaltung prodver = Produktverwaltung.getinstance();
		Produktgruppeverwaltung prodgruver = Produktgruppeverwaltung.getinstance();
		Benutzerverwaltung benver = Benutzerverwaltung.getInstance();
		Auktionsverwaltung aukver = Auktionsverwaltung.getInstance();
		
/*		
		personDao.speicherePerson(new Benutzer(UUID.randomUUID(), "Gerhard", "Schmidt", "gertsch@coconut.de", 3714, "Roseldorf", "Roseldorf", 122, "gertsch", "hallo"));
		personDao.speicherePerson(new Benutzer(UUID.randomUUID(), "Mirza", "Talic", "mirza@coconut.de",1100, "Wien", "Wien", 122, "mirzi", "hallo"));
		personDao.speicherePerson(new Benutzer(UUID.randomUUID(), "Snezana", "Milutinovic", "sneza@coconut.de", 1100, "Wien", "Wien", 122, "snezi", "hallo"));
		personDao.speicherePerson(new Benutzer(UUID.randomUUID(), "Josef", "Weber", "jose@coconut.de", 1230, "Wien", "Wien", 122, "josi", "hallo"));

		prodgruDao.produktgruppeAnlegen(new Produktgruppe("Fernseher"));
		prodgruDao.produktgruppeAnlegen(new Produktgruppe("Computer"));
		prodgruDao.produktgruppeAnlegen(new Produktgruppe("Rollstuhl"));
		
		prodDao.produktAnlegen(new Produkt(UUID.randomUUID(), "Samsung Lt 200", 1200, "gertsch", "Fernseher", 100, "Ein 200 Zoll Fernseher!"));
		prodDao.produktAnlegen(new Produkt(UUID.randomUUID(), "Samsung Lt 50", 120, "gertsch", "Fernseher", 100, "Ein 10 Zoll Fernseher!"));
		prodDao.produktAnlegen(new Produkt(UUID.randomUUID(), "Omas Rollstuhl", 25, "mirzi", "Rollstuhl", 100, "Ein alter Rollstuhl!"));
*/
		
		
		
		
		
		
//		if(prodDao.produktAnlegen(new Produkt(UUID.randomUUID(),"name",20,"gertschi","Tisch",200,"beschreibung")) )
//			System.out.println("ohoh");
//		if(prodDao.produktAnlegen(new Produkt(UUID.randomUUID(),"name",20,"gertsch","Tischi",200,"beschreibung")) )
//			System.out.println("ohoh");
	
//		prodver.produktAendern(p1.getProduktID(), "Epiphone Les Pauli", 200, "mirzi", "Gitarre", 20, "geil");
//	
//		prodver.produktAnlegen("Fender Strat", 1000, "mirzi", "Klavier", 100, "testbeschreibung");
//		prodver.produktLoeschen(p1.getProduktID().toString());
		
		
		
		
		
//		for(Produkt pg : prodver.getProduktListe()){
//			prodver.produktAendern(pg.getProduktID(), pg.getName(), 20, pg.getOwnerUsername(), "Gitarre", 100, "haha");
//		}
		
		//aukver.gebotAbgeben("snezi", 30, "9995348e-88df-4a86-958f-5595d95a91a8");
		//aukver.gebotLoeschen("9995348e-88df-4a86-958f-5595d95a91a8");
		
//		prodver.produktVerschieben(UUID.fromString("9995348e-88df-4a86-958f-5595d95a91a8"), "Rolla");

		
//		prodgruver.produktgruppeLoeschen("Rollstuhl");

//		prodgruver.produktgruppeAendern("Handy", "Smartphone");
		
		aukver.gebotAbgeben("gertsch", 1000, "9995348e-88df-4a86-958f-5595d95a91a8");
		
		
		try {
			System.out.println("getZumVerkaufStehendeProdukteVonBenutzer");
			System.out.println(benver.getZumVerkaufStehendeProdukteVonBenutzer("gertsch"));
//			System.out.println("\ngetVerkaufteProdukteVonBenutzer");
//			System.out.println(benver.getVerkaufteProdukteVonBenutzer("mirzi"));
//			System.out.println("\ngetGebotshistorieVonBenutzer");
//			System.out.println(benver.getGebotshistorieVonBenutzer("mirzi"));
		} catch (BenutzerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Produkte");
		for(Produkt p : prodver.getProduktListe()){
			System.out.println(" " + p);
		}
		
		System.out.println("Produktgruppen");
		for(Produktgruppe pg : prodgruver.getProduktgruppeList()){
			System.out.println(" " + pg);
		}
		
		System.out.println("Personen");
		for(Person p : benver.getBenutzerListe()){
			System.out.println(" " + p);
		}
		
		System.exit(0);
		
	}

}
