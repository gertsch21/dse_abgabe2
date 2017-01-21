package soap.services;

import java.util.List;

import javax.jws.WebService;

import exceptions.BenutzerNotFoundException;
import modell.Benutzer;
import modell.Person;
import modell.Produkt;

@WebService(name = "BenutzerservicesSEI2", targetNamespace = "http://services.soap/")
public interface BenutzerservicesSEI2 {

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

	List<Produkt> getGebotshistorieVonBenutzer(String username) throws BenutzerNotFoundException;

	List<Produkt> getVerkaufteProdukteVonBenutzer(String username) throws BenutzerNotFoundException;

	List<Produkt> getZumVerkaufStehendeProdukteVonBenutzer(String username) throws BenutzerNotFoundException;

}