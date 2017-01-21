package soap.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.jws.WebService;

import exceptions.BenutzerNotFoundException;
import management.Benutzerverwaltung;
import management.Produktverwaltung;
import modell.Administrator;
import modell.Benutzer;
import modell.Person;
import modell.Produkt;

/**
 * 
 * Diese Klasse realisiert alle Methoden, welche im BenutzerservicesSEI angegeben worden sind
 *
 */
@WebService(targetNamespace = "http://services.soap/", endpointInterface = "soap.services.BenutzerservicesSEI2", portName = "BenutzerservicesPort", serviceName = "BenutzerservicesService")
public class Benutzerservices implements BenutzerservicesSEI, BenutzerservicesSEI2 {
	public boolean pruefeLogin(String username, String password){
		return Benutzerverwaltung.getInstance().pruefeLogin(username, password);
	}
	public List<Benutzer> getBenutzerliste(){
		return Benutzerverwaltung.getInstance().getBenutzerListe();
	}
	public boolean benutzerAnlegen(String vorname, String nachname, String email, int plz, String strasse, String wohnort, int hausnummer, String username, String password){//Verbesserungswürdig!!!
		return Benutzerverwaltung.getInstance().benutzerAnlegen(vorname, nachname, email, plz, strasse, wohnort, hausnummer, username, password);
	}
	
	public boolean benutzerloeschen(String username){//Achtung person nicht benutzer wird gelöscht!!!
		return Benutzerverwaltung.getInstance().benutzerloeschen(username);
	}
	
	public boolean benutzerEinfrieren(String username){
		return Benutzerverwaltung.getInstance().benutzerEinfrieren(username);
	}
	
	public boolean benutzerEinfAufheben(String username){
		return Benutzerverwaltung.getInstance().benutzerEinfAufheben(username);
	}
	public boolean adminAnlegen(String vorname, String nachname, String email, int plz, String strasse, String wohnort, int hausnummer, String username, String password,double gehalt){//Verbesserungswürdig!!!
		return Benutzerverwaltung.getInstance().adminAnlegen(vorname, nachname, email, plz, strasse, wohnort, hausnummer, username, password, gehalt);
	}
	
	public Person getPersonByUsername(String username){//Achtung, liefert Personen und nicht Benutzer!!!
		return Benutzerverwaltung.getInstance().getPersonByUsername(username);
	}
	
	public boolean passwortAendern(String username, String neuesPasswort){
		return Benutzerverwaltung.getInstance().passwortAendern(username, neuesPasswort);	
	}
	
	public boolean adressdatenAendern(String username, int plz, String strasse, String wohnort, int hausnummer){
		return Benutzerverwaltung.getInstance().adressdatenAendern(username, plz, strasse, wohnort, hausnummer);
	}

	public List<Produkt> getGebotshistorieVonBenutzer(String username) throws BenutzerNotFoundException{
		return Benutzerverwaltung.getInstance().getGebotshistorieVonBenutzer(username);
	}
	
	public List<Produkt> getVerkaufteProdukteVonBenutzer(String username) throws BenutzerNotFoundException{
		return Benutzerverwaltung.getInstance().getVerkaufteProdukteVonBenutzer(username);
	}
	
	public List<Produkt> getZumVerkaufStehendeProdukteVonBenutzer(String username) throws BenutzerNotFoundException{
		return Benutzerverwaltung.getInstance().getZumVerkaufStehendeProdukteVonBenutzer(username);
	}

}
