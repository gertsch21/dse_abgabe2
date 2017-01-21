package soap.services;

import java.util.List;
import java.util.UUID;

import javax.jws.WebService;

import modell.Benutzer;
import modell.Person;
import modell.Produkt;
import modell.ProduktOhneGruppe;
import modell.Produktgruppe;

@WebService(name = "AlleServicesSEI2", targetNamespace = "http://services.soap/")
public interface AlleServicesSEI2 {

	//Benutzerverwaltung
	boolean pruefeLogin(String username, String password);

	List<Benutzer> getBenutzerliste();

	boolean benutzerAnlegen(String vorname, String nachname, String email, int plz, String strasse, String wohnort,
			int hausnummer, String username, String password);

	boolean benutzerloeschen(String username);

	boolean benutzerEinfrieren(String username);

	boolean benutzerEinfAufheben(String username);

	boolean adminAnlegen(String vorname, String nachname, String email, int plz, String strasse, String wohnort,
			int hausnummer, String username, String password, double gehalt);

	Person getPersonByUsername(String username);

	boolean passwortAendern(String username, String neuesPasswort);

	boolean adressdatenAendern(String username, int plz, String strasse, String wohnort, int hausnummer);

	List<Produkt> getGebotshistorieVonBenutzer(String username);

	List<Produkt> getVerkaufteProdukteVonBenutzer(String username);

	List<Produkt> getZumVerkaufStehendeProdukteVonBenutzer(String username);

	//Produktverwaltung
	Produkt getProduktByID(String produktID);

	boolean produktAnlegen(String name, double startpreis, String Uname, String kategorie, int dauer,
			String beschreibung);

	List<Produkt> sucheProdukt(String parameter);

	boolean produktLoeschen(String id);

	boolean produktVerschieben(UUID id, String kategorie);

	boolean produktAendern(UUID id, String name, double startpreis, String Uname, String kategorie, int dauer,
			String beschreibung);

	List<Produkt> getProduktListe();

	//Produktgruppenverwaltung
	boolean produktgruppeAnlegen(String name);

	boolean produktgruppeLoeschen(String name);

	List<Produktgruppe> getProduktgruppeList();

	Produktgruppe getProduktgruppeByName(String name);

	boolean produktgruppeAendern(String alterName, String neuerName);

	//Auktionsverwaltung
	boolean gebotAbgeben(String username, double gebot, String produktID);

	boolean gebotLoeschen(String produktID);

	List<ProduktOhneGruppe> getProduktListeOhne();

}