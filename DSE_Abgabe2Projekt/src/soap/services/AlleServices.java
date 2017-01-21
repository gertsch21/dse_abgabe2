package soap.services;


import java.util.List;
import java.util.UUID;

import javax.jws.WebService;

import management.Auktionsverwaltung;
import management.Benutzerverwaltung;
import management.Produktgruppeverwaltung;
import management.Produktverwaltung;
import modell.Benutzer;
import modell.Person;
import modell.Produkt;
import modell.Produktgruppe;

/**
 * 
 * Diese Klasse realisiert alle Methoden, welche nach aussen verfuegbar sein sollen
 *
 */
@WebService(targetNamespace = "http://services.soap/", endpointInterface = "soap.services.AlleServicesSEI", portName = "AlleServicesPort", serviceName = "AlleServicesService")
public class AlleServices implements AlleServicesSEI {
	
	
//Benutzerverwaltung
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

	public List<Produkt> getGebotshistorieVonBenutzer(String username) {
		return Benutzerverwaltung.getInstance().getGebotshistorieVonBenutzer(username);
	}
	
	public List<Produkt> getVerkaufteProdukteVonBenutzer(String username) {
		return Benutzerverwaltung.getInstance().getVerkaufteProdukteVonBenutzer(username);
	}
	
	public List<Produkt> getZumVerkaufStehendeProdukteVonBenutzer(String username){
		return Benutzerverwaltung.getInstance().getZumVerkaufStehendeProdukteVonBenutzer(username);
	}

	
//Produktverwaltung
	public Produkt getProduktByID(String produktID){
		return Produktverwaltung.getinstance().getProduktByID(produktID);
	}
	
	public boolean produktAnlegen( String name, double startpreis, String Uname, String kategorie, int dauer, String beschreibung){
		return Produktverwaltung.getinstance().produktAnlegen(name, startpreis, Uname, kategorie, dauer, beschreibung);
	}
	
	public List<Produkt> sucheProdukt(String parameter){
		return Produktverwaltung.getinstance().sucheProdukt(parameter);	
	}
	
	public boolean produktLoeschen(String id){
		return Produktverwaltung.getinstance().produktLoeschen(id);
	}
	
	public boolean produktVerschieben(UUID id,String kategorie){
		return Produktverwaltung.getinstance().produktVerschieben(id, kategorie);
	}
	
	public boolean produktAendern(UUID id, String name, double startpreis, String Uname, String kategorie, int dauer, String beschreibung){
		return Produktverwaltung.getinstance().produktAnlegen(name, startpreis, Uname, kategorie, dauer, beschreibung);
	}
	
	public List<Produkt> getProduktListe(){
		return Produktverwaltung.getinstance().getProduktListe();
	}
	
	
//Produktgruppenverwaltung
	public boolean produktgruppeAnlegen(String name){
		return Produktgruppeverwaltung.getinstance().produktgruppeAnlegen(name);
	}

	public boolean produktgruppeLoeschen(String name){
		return Produktgruppeverwaltung.getinstance().produktgruppeLoeschen(name);
	}
	
	public List<Produktgruppe> getProduktgruppeList(){
		return Produktgruppeverwaltung.getinstance().getProduktgruppeList();
	}

	public Produktgruppe getProduktgruppeByName(String name){
		return Produktgruppeverwaltung.getinstance().getProduktgruppeByName(name);
	}
	
	public boolean produktgruppeAendern(String alterName, String neuerName){
		return Produktgruppeverwaltung.getinstance().produktgruppeAendern(alterName, neuerName);
	}
	
	
//Auktionsverwaltung
	public boolean gebotAbgeben(String username,double gebot,String produktID){
		return Auktionsverwaltung.getInstance().gebotAbgeben(username, gebot, produktID);
	}
	
	public boolean gebotLoeschen(String produktID){
		return Auktionsverwaltung.getInstance().gebotLoeschen(produktID);
	}
	
}

