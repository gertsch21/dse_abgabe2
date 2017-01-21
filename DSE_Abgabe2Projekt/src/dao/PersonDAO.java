/**
*	Das Paket dient zum persistenten Speichern der Benutzer und Produktdaten um spaeter 
*	wieder darauf zugreifen zu koennen.
 */
package dao;

import java.util.List;

import modell.Benutzer;
import modell.Person;

public interface PersonDAO {

	/**
	 *Wenn keine Liste enthalten ist, wird eine leere Liste erstellt und
	 * diese zurückgegeben!
	 * 
	 * @return Die Liste der gespeicherten Person.
	 */
	public List<Person> getPersonList();

	/**
	 *Wenn keine Liste enthalten ist,wird eine leere Liste erstellt und
	 * diese zurückgegeben!
	 * 
	 * @return Die Liste der gespeicherten Benutzer.
	 */
	public List<Benutzer> getBenutzerList();

	
	/**
	 * 
	 * @param id Anhand der eindeutigen ID wird die Person gesucht.
	 * @return Die gefundene Person wird zurückgegeben, oder null wird zurückgeliefert.
	 */
	public Person getPersonById(String id);
	
	/**
	 * 
	 * @param username Anhand diesem eindeutigen Parameter wird die Person gesucht.
	 * @return Die gefundene Person wird zurückgegeben, oder null.
	 */
	public Person getPersonByUsername(String username);

	/**
	 * 
	 * @param benutzer Die zu speichernde Person(Abstraktion von Benutzer und Administrator).
	 * @return true, falls Vorgang erfolgreich, andernfalls false.
	 */
	public boolean speicherePerson(Person benutzer);

	
	/**
	 * 
	 * @param username Der Username der zu löschenden Person als String.
	 * @return true, falls Vorgang erfolgreich, andernfalls false.
	 */
	public boolean loeschePerson(String username);

	/**
	 * 
	 * @param benutzer Der Username der einzufrierenden Person als String.
	 * @return true, falls Vorgang erfolgreich, andernfalls false.
	 */
	public boolean einfrierenPerson(String benutzer);
	
	/**
	 * 
	 * @param benutzer Der Username der einzufrierenden Person als String.
	 * @return true, falls Vorgang erfolgreich, andernfalls false.
	 */
	public boolean einfrierenAufheben(String benutzer);

	/**
	 * 
	 * @param username Der Username der Person, dessen Passwort geaendert werden soll
	 * @param neuesPasswort Das neue Passwort
	 * @return true, falls erfolgreich, false, falls passwort falsch ist
	 * @throws BenutzerNotFoundException geworfen, falls username mit keinem Benutzer zusammenpasst
	 */
	public boolean passwortAendern(String username, String neuesPasswort);
	
	/**
	 * 
	 * @param username Der Username des betreffenden Users
	 * @param plz Die neue PLZ des betreffenden Users
	 * @param strasse Die neueStrasse des betreffenden Users
	 * @param wohnort Der neue Wohnort des betreffenden Users
	 * @param hausnummer Die Hausnummer des betreffenden Users
	 * @return true, falls erfolgreich, false, falls fehlgeschlagen
	 */
	public boolean adressdatenAendern(String username, int plz, String strasse, String wohnort, int hausnummer);
}